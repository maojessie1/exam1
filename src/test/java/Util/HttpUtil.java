package Util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.maven.surefire.shade.org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 执行一个HTTP GET请求，返回请求响应的HTML
     *
     * @param url
     *            请求的URL地址
     * @param queryString
     *            请求的查询参数,可以为null
     * @return 返回请求响应的HTML
     */
    public static String doGet(String url, String queryString) {
        String response = null;
        HttpClient client = new HttpClient();
        if(url.startsWith("https")){
            //https请求
            Protocol myhttps = new Protocol("https", new HttpSSLProtocolSocketHandler(), 443);
            Protocol.registerProtocol("https", myhttps);
        }
        HttpMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        try {
            if (!"".equals(queryString))
                method.setQueryString(URIUtil.encodeQuery(queryString));
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                response = method.getResponseBodyAsString();
            }
        } catch (Exception e) {

        } finally {
            method.releaseConnection();
        }
        return response;
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的HTML
     *
     * @param url
     *            请求的URL地址
     * @param params
     *            请求的查询参数,可以为null
     * @return 返回请求响应的HTML
     */
    public static String doPost(String url, Map<String, String> params) {
        logger.debug("Post Url:" + url + ",Params:" + params);
        StringBuffer result = new StringBuffer();
        HttpClient client = new HttpClient();
        client.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,10000);//增加超时时长,10秒
        if(url.startsWith("https")){
            //https请求
            Protocol myhttps = new Protocol("https", new HttpSSLProtocolSocketHandler(), 443);
            Protocol.registerProtocol("https", myhttps);
        }
        PostMethod method = new PostMethod(url);
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        // 设置Http Post数据
        if (null != params) {
            NameValuePair[] data = new NameValuePair[params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                data[i++] = new NameValuePair(entry.getKey(), entry.getValue());
            }
            method.setRequestBody(data);
        }
        try {
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), StandardCharsets.UTF_8));
                String str = null;
                while ((str = reader.readLine()) != null) {
                    result.append(str);
                }
            }else{
                System.out.println(method.getStatusLine());
            }
        } catch (Exception e) {
            logger.error("doPost",e);
        } finally {
            method.releaseConnection();
        }
        logger.debug("Post Return:" + result.toString());
        return result.toString();
    }


    public static String doPostWithHeader(String url, List<Header> headerList, Map<String, Object> params, boolean isFormData) throws Exception {
        logger.debug("Post Url:" + url + ",Params:" + params);
        StringBuffer result = new StringBuffer();
        HttpClient client = new HttpClient();
        client.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);// 增加超时时长,10秒
        if(url.startsWith("https")){
            //https请求
            Protocol myhttps = new Protocol("https", new HttpSSLProtocolSocketHandler(), 443);
            Protocol.registerProtocol("https", myhttps);
        }
        PostMethod method = new PostMethod(url);
        method.getParams().setParameter("http.protocol.content-charset", "UTF-8");
        method.addRequestHeader( new Header("Content-Type", (isFormData ? "application/x-www-form-urlencoded":"application/json")));
        if (headerList != null && headerList.size()>0 ) {
            for (Header each: headerList) {
                method.addRequestHeader(each);
            }
        }
        if (isFormData) {
            if (!"".equals(params) && null != params) {
                NameValuePair[] data = new NameValuePair[params.size()];
                int i = 0;
                Map.Entry entry;
                for (Iterator i$ = params.entrySet().iterator();
                     i$.hasNext(); data[i++] = new NameValuePair((String) entry.getKey(), (String) entry.getValue())) {
                    entry = (Map.Entry) i$.next();
                }
                method.setRequestBody(data);
            }
        }	else {
            if (params != null) {
                String requestJson = JSONObject.toJSONString(params);
                method.setRequestBody(requestJson);
            }
        }


        try {
            client.executeMethod(method);
            if (method.getStatusCode() == 200) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(method.getResponseBodyAsStream(), StandardCharsets.UTF_8));
                String str = null;
                while ((str = reader.readLine()) != null) {
                    result.append(str);
                }
            }
        } finally {
            method.releaseConnection();
        }

        logger.debug("Post Return:" + result.toString());
        return result.toString();
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的HTML
     *
     * @param url
     *            请求的URL地址
     * @param params
     *            请求的查询参数,可以为null
     * @return 返回请求响应的HTML
     */
    public static void doThreadPost(String url, Map<String, String> params) {
        HttpUtil httpUtil = new HttpUtil();
        HttpPostThread httpPostThread = httpUtil.new HttpPostThread(url, params);
        httpPostThread.start();
    }

    class HttpPostThread extends Thread {
        private String url;
        private Map<String, String> params;

        public HttpPostThread(String url, Map<String, String> params) {
            this.url = url;
            this.params = params;
        }




        @Override
        public void run() {
            doPost(url, params);
        }
    }


}



