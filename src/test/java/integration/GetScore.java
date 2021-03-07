package integration;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetScore {
    Map<String, String> headers = new HashMap<String, String>();
    Map<String, String> paramMap = new HashMap<String, String>();
    Map<String, String> resultMap= new HashMap<String, String>();
    String nativeJsonTag = "";//表示post发送的参数是json格式，放入paramMap中的第一个key


    @Test
    public void token(){
//        String sx_url = "https://zledutestapi.cailian.net/api-oauth/oauth2/token";
        String sx_url = "https://zledusxapi.cailian.net/api-oauth/oauth2/token";
//        headers.put(":authority","zledutestapi.cailian.net");
        headers.put(":authority","zledusxapi.cailian.net");
        headers.put("method","POST");
        headers.put("path","/api-oauth/oauth2/token");
        headers.put("scheme","https");
        headers.put("accept", "application/json, text/plain, */*");

        headers.put("accept-encoding", "gzip, deflate, br");
        headers.put("accept-language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("authorization","bearer fadacc10-8b50-4752-b3b2-c5886200d6b6");

        headers.put("Content-Length","181");
        headers.put("content-type", "application/x-www-form-urlencoded");
        headers.put("origin", "https://eduresourcetest.cailian.net");
        headers.put("referer", "https://eduresourcetest.cailian.net/");
        headers.put("sec-ch-ua","Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99");
        headers.put("sec-ch-ua-mobile","?0");
        headers.put("Sec-Fetch-Dest","empty");
        headers.put("Sec-Fetch-Mode","cors");
        headers.put("Sec-Fetch-Site","same-site");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.72 Safari/537.36");

        paramMap.put("username", "qqq");
        paramMap.put("password", "111111");
        paramMap.put("client_id", "1163687109021044738");
        paramMap.put("client_secret", "23915e847ed736b72d98857686075b66");
        paramMap.put("grant_type", "password");
        paramMap.put("uuid","212bc81b-834f-4c50-8746-81993df2f0a0");
        paramMap.put("validCode","");
        resultMap = SendUtil.sendPostVSToken(sx_url, headers, paramMap, "POST");
        System.out.println(resultMap.get("code"));
        System.out.println(resultMap.get("data"));
    }


    @Test
    public void getUser(){
        String sx_url = "https://zledusxapi.cailian.net/api-oauth/oauthclient/getUser";
        headers.put(":authority","zledusxapi.cailian.net");
        headers.put("method","POST");
        headers.put("path","/api-oauth/oauthclient/getUser");
        headers.put("scheme","https");
        headers.put("accept", "application/json, text/plain, */*");

        headers.put("Accept-Encoding","gzip, deflate, br");
        headers.put("Accept-Language","zh-CN,zh;q=0.9");
        headers.put("authorization","bearer 197f0ee5-16de-45c4-8e5d-76dbed09ccc1");
        headers.put("Connection","keep-alive");
        headers.put("Content-Length:","16");
//        headers.put("Content-Type","application/x-www-form-urlencoded");
        headers.put("content-type", "application/x-www-form-urlencoded;charset=UTF-8");

        headers.put("Host","zledusxapi.cailian.net");
        headers.put("Origin","https://eduresourcesx.cailian.net");
        headers.put("Referer","https://eduresourcesx.cailian.net");
        headers.put("Sec-Fetch-Mode","cors");
        headers.put("Sec-Fetch-Site","same-site");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");

        paramMap.put("appFlag","resource");

        resultMap = SendUtil.sendPostVSToken(sx_url,headers,paramMap,"POST");
        System.out.println(resultMap.get("code"));
        System.out.println(resultMap.get("data"));
    }

    @Test
    public void getSelectList(){
        String sx_url = "https://zledusxapi.cailian.net/api-resource/profession/selectList";
        headers.put(":authority","zledusxapi.cailian.net");
        headers.put("method","POST");
        headers.put("path","/api-resource/profession/selectList");
        headers.put("scheme","https");
        headers.put("accept", "application/json, text/plain, */*");

        headers.put("Accept-Encoding","gzip, deflate, br");
        headers.put("Accept-Language","zh-CN,zh;q=0.9");
        headers.put("authorization","bearer 197f0ee5-16de-45c4-8e5d-76dbed09ccc1");
        headers.put("Connection","keep-alive");
        headers.put("Content-Length:","16");
//        headers.put("Content-Type","application/x-www-form-urlencoded");
        headers.put("content-type", "application/x-www-form-urlencoded;charset=UTF-8");

        headers.put("Host","zledusxapi.cailian.net");
        headers.put("Origin","https://eduresourcesx.cailian.net");
        headers.put("Referer","https://eduresourcesx.cailian.net");
        headers.put("Sec-Fetch-Mode","cors");
        headers.put("Sec-Fetch-Site","same-site");
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");

//        paramMap.put("appFlag","resource");

        resultMap = SendUtil.sendPostVSToken(sx_url,headers,paramMap,"POST");
        System.out.println(resultMap.get("code"));
        System.out.println(resultMap.get("data"));
    }






//    @Test
    public void test1() {
        String sx_url = "https://zledusxapi.cailian.net/api-score/noAuth/scan-question-score-list";
        headers.put("accept", "application/json, text/plain, */*");
        headers.put("accept-encoding", "gzip, deflate, br");
        headers.put("accept-language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("authorization","bearer 5359804e-8660-483f-8bee-07038287e9ac");
        headers.put("Connection","keep-alive");
        headers.put("Content-Length","98");
        headers.put("content-type", "application/json;charset=UTF-8");
        headers.put("Host","zledusxapi.cailian.net");
        headers.put("origin", "https://eduresourcesx.cailian.net");
        headers.put("referer", "https://eduresourcesx.cailian.net/");
        headers.put("sec-ch-ua","Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99");
        headers.put("sec-ch-ua-mobile","?0");
        headers.put("Sec-Fetch-Dest","empty");
        headers.put("Sec-Fetch-Mode","cors");
        headers.put("Sec-Fetch-Site","same-site");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.72 Safari/537.36");

        paramMap.put("username", "adminF");
        paramMap.put("password", "111111");
        paramMap.put("client_id", "webApp");
        paramMap.put("client_secret", "1945f5eff05b0f7892e477ab76ebf8bd");
        paramMap.put("grant_type", "password");
        resultMap = SendUtil.sendPostVSToken(sx_url, headers, paramMap, "POST");
        System.out.println(resultMap.get("code"));
        System.out.println(resultMap.get("data"));
    }
}