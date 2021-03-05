package integration;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetScore {
    Map<String, String> headers = new HashMap<String, String>();
    Map<String, String> paramMap = new HashMap<String, String>();
    Map<String, String> resultMap= new HashMap<String, String>();

    @Test
    public void test(){
        String sx_url = "https://zledutestapi.cailian.net/api-oauth/oauth2/token";
        headers.put(":authority","zledutestapi.cailian.net");
        headers.put("method","POST");
        headers.put("path","/api-oauth/oauth2/token");
        headers.put("scheme","https");
        headers.put("accept", "application/json, text/plain, */*");

        headers.put("accept-encoding", "gzip, deflate, br");
        headers.put("accept-language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("authorization","bearer 90b7e6e7-38eb-4914-8ba8-7fb281c41be7");

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

        paramMap.put("username", "adminF");
        paramMap.put("password", "111111");
        paramMap.put("client_id", "1163687109021044738");
        paramMap.put("client_secret", "23915e847ed736b72d98857686075b66");
        paramMap.put("grant_type", "password");
        paramMap.put("uuid","290590ee-4df3-43da-ae0c-f80c91e25f19");
        paramMap.put("validCode","");
        resultMap = SendUtil.sendPostVSToken(sx_url, headers, paramMap, "POST");
        System.out.println(resultMap.get("code"));
        System.out.println(resultMap.get("data"));
    }


    @Test
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