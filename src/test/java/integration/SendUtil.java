package integration;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

public class SendUtil {
	//区分post发送的参数是json格式还是key value格式，如果为json格式则给一个私有的tag，放入paramMap中的第一个key，让send方法不要拼接此参数
	public static final String NATIVE_JSON_TAG = "test_native_json";

	
    private static Map<String, String> getHttpResponseHeader(HttpURLConnection http) throws UnsupportedEncodingException {
        Map<String, String> header = new LinkedHashMap<String, String>();
        for (int i = 0;; i++) {
            String mine = http.getHeaderField(i);
            if (mine == null)
                break;
            header.put(http.getHeaderFieldKey(i), mine);
        }
        return header;
    }

    /**
     * response content encoding为gip的需要解压缩
     * 
     * 
     * @param in
     * @return
     * @throws IOException
     */
    public static  InputStreamReader getGZIPInputStreamResponse(InputStream in) throws IOException {              
                    GZIPInputStream gzin = new GZIPInputStream(in);
                    InputStreamReader isr = new InputStreamReader(gzin,"utf-8");        
        return isr;
    }


	/**
	 * post 方式发送
	 * @param url
	 * @param param
	 * @param
	 * @return map 中data存返回的json ,code 存返回code,token 存 token
	 * 
	 */
	public static Map<String,String> sendPostVSToken(String url, Map<String, String> headers,Map<String, String> param, String requestMethod) {

		Map<String, String> respMap = new HashMap<String , String>();
		HttpURLConnection connection = null;
		OutputStreamWriter out = null;
		BufferedReader reader = null;

		StringBuffer sb = null;
		int responseCode =0;;
		sb = new StringBuffer("");
		try {
			// 创建连接
			URL localURL = new URL(url);
			Reporter.log("请求URL： " +url);

			//调用忽略证书的方法
	        if("https".equalsIgnoreCase(localURL.getProtocol())){
	            try {
					SslUtils.ignoreSsl();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
			connection = (HttpURLConnection) (localURL.openConnection());
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(requestMethod);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			if(headers == null || headers.isEmpty()) {//如果header为空，则给一个默认的headers
				headers.put("Accept", "application/json, text/plain, */*");
				headers.put("Content-Type", "application/x-www-form-urlencoded");
			}
			StringBuffer headerLogInfo = new StringBuffer();
			for (String key : headers.keySet()) {
				connection.setRequestProperty(key, headers.get(key));
				headerLogInfo.append(key + " : " +  headers.get(key) + '\n');
			}
			Reporter.log("请求header： " + headerLogInfo);

		
			connection.connect();
			// POST请求
			out = new OutputStreamWriter(connection.getOutputStream());
			// 发送参数
			StringBuffer paramStr = new StringBuffer();
			for (String key : param.keySet()) {
				if(key.equals("test_native_json")) {//如果是json格式数据
					paramStr.append(param.get(key));
					break;
				}
				paramStr.append(key + "=" + param.get(key) + "&");
			}
			if(paramStr.toString().endsWith("&")) {
				paramStr.deleteCharAt(paramStr.length() - 1);
//				paramStr.insert(0, '?')
			}
//			out.write(paramStr.toString());
//			out.write(URLDecoder.decode(paramStr.toString(), "utf-8"));
			out.write(new String(paramStr.toString().getBytes(), "utf-8"));
			Reporter.log("请求参数： " +paramStr.toString());

			// 清理当前编辑器的左右缓冲区，并使缓冲区数据写入基础流
			out.flush();
			// 读取响应
			responseCode = connection.getResponseCode();
			if(responseCode == 200) {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			//-------------------------------
			Map<String, String> respHeaderMap = getHttpResponseHeader(connection);
			if(respHeaderMap.get("Content-Encoding") != null) {
				if(respHeaderMap.get("Content-Encoding").equals("gzip")) {
					reader = new BufferedReader(getGZIPInputStreamResponse(connection.getInputStream()));
				}
			}
			
			//------------------------------
			String lines;
			while ((lines = reader.readLine()) != null) {
//				lines = URLDecoder.decode(lines, "utf-8");
				sb.append(lines);
			}
			
				System.out.println(url + "-----" + sb);
			}else {
				System.err.println(url + "-----" + responseCode);

			}
			Reporter.log("响应码： " + responseCode);
			Reporter.log("响应数据： " + sb.toString());

			respMap.put("code",responseCode + "");
			respMap.put("data",sb.toString());
//			respMap.put("token",token);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
		
			try {
				Reporter.log("响应码： " + responseCode, org.apache.maven.doxia.logging.Log.LEVEL_ERROR);
//				("响应码： " + responseCode);
				sb.append(Integer.toString(connection.getResponseCode()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				
				respMap.put("code", Integer.toString(connection.getResponseCode()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (connection != null) {
				connection.disconnect();
			}
		}
		return respMap;
	}



	// get请求
	public static Map<String, String> get(String url, Map<String, String> headers, Map<String, String> parameters) {
		Map<String, String> respMap = new HashMap<String , String>();
		int responseCode =0;;
		HttpURLConnection conn = null;
		BufferedReader rd = null;
		StringBuilder sb = new StringBuilder();
		String line = null;
		String response = null;
		if(parameters != null) {
			StringBuffer params = new StringBuffer();
			for (Iterator<Entry<String, String>> iter = parameters.entrySet().iterator(); iter.hasNext();) {
				Entry<String, String> element = (Entry<String, String>) iter.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(element.getValue()==null?"":element.getValue());
				params.append("&");
			}
			
			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}
			url = url + "?" + params;
		}
		
		try {
			// 创建连接
			URL localURL = new URL(url);
			//调用忽略ssl证书
	        if("https".equalsIgnoreCase(localURL.getProtocol())){
	            SslUtils.ignoreSsl();
	        }
			conn = (HttpURLConnection) localURL.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setReadTimeout(20000);
			conn.setConnectTimeout(20000);
			conn.setUseCaches(false);
			// "Accept": "*/*",

			if(headers == null || headers.isEmpty()) {//如果header为空，则给一个默认的headers
				if(headers == null) {
					headers = new HashMap<String, String>();
				}
				headers.put("Accept", "*/*");
				headers.put("Content-Type", "application/x-www-form-urlencoded");
			}
			for (String key : headers.keySet()) {
				conn.setRequestProperty(key, headers.get(key));
			}
			conn.connect();
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			//-------------------------------
			Map<String, String> respHeaderMap = getHttpResponseHeader(conn);
			if(respHeaderMap.get("Content-Encoding") != null) {
				if(respHeaderMap.get("Content-Encoding").equals("gzip")) {
					rd = new BufferedReader(getGZIPInputStreamResponse(conn.getInputStream()));
				}
			}
			
			//------------------------------
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(url + "-----" + sb);
			responseCode = conn.getResponseCode();
			respMap.put("code",responseCode + "");
			respMap.put("data",sb.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			try {
				response = Integer.toString(conn.getResponseCode());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				respMap.put("code", Integer.toString(conn.getResponseCode()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (rd != null) {
					rd.close();
				}
				if (conn != null) {
					conn.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return respMap;
	}


	/*public String doPost(String url,Map<String,String> map,String charset){
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try{
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			//设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String,String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
			}
			if(list.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
					result = EntityUtils.toString(resEntity,charset);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}*/
}
