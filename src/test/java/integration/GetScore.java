package integration;

import Util.HttpUtil;
import org.apache.commons.httpclient.Header;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetScore {
    Map<String, String> headers = new HashMap<String, String>();
    Map<String, String> paramMap = new HashMap<String, String>();
    Map<String, String> resultMap = new HashMap<String, String>();
    String nativeJsonTag = "";//表示post发送的参数是json格式，放入paramMap中的第一个key

    public GetScore() {
        nativeJsonTag = "test_native_json";
    }

    @Test
    public void token() {
        String sx_url = "https://zledusxapi.cailian.net/api-oauth/oauth2/token";
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("accept-language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("authorization", "bearer 07c9117b-ceba-4ec0-8e7e-3098c7ad25c6");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Length", "178");
        headers.put("content-type", "application/x-www-form-urlencoded");
        headers.put("Host", "zledusxapi.cailian.net");

        headers.put("origin", "https://eduresourcesx.cailian.net");
        headers.put("referer", "https://eduresourcesx.cailian.net/");
        headers.put("sec-ch-ua", "\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"");
        headers.put("sec-ch-ua-mobile", "?0");
        headers.put("Sec-Fetch-Dest", "empty");
        headers.put("Sec-Fetch-Mode", "cors");
        headers.put("Sec-Fetch-Site", "same-site");
        headers.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.72 Safari/537.36");


        paramMap.put("client_id", "1163687109021044738");
        paramMap.put("client_secret", "23915e847ed736b72d98857686075b66");
        paramMap.put("grant_type", "password");
        paramMap.put("username", "qqq");
        paramMap.put("password", "111111");
        paramMap.put("uuid", "aeff52bf-40ba-407d-9c6b-3df26027d85c");
        paramMap.put("validCode", "");

        resultMap = SendUtil.sendPostVSToken(sx_url, headers, paramMap, "POST");
        System.out.println(resultMap.get("code"));
        System.out.println(resultMap.get("data"));
    }


    @Test
    public void getUser() {
        String sx_url = "https://zledusxapi.cailian.net/api-oauth/oauthclient/getUser";
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("authorization", "bearer c1122878-316a-48bd-a088-88ac7a8eb0f3");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Length", "16");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Host", "zledusxapi.cailian.net");
        headers.put("Origin", "https://eduresourcesx.cailian.net");
        headers.put("Referer", "https://eduresourcesx.cailian.net/");
        headers.put("sec-ch-ua", "\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"");
        headers.put("sec-ch-ua-mobile", "?0");
        headers.put("Sec-Fetch-Dest", "empty");
        headers.put("Sec-Fetch-Mode", "cors");
        headers.put("Sec-Fetch-Site", "same-site");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        paramMap.put("appFlag", "resource");
        resultMap = SendUtil.sendPostVSToken(sx_url, headers, paramMap, "POST");
        System.out.println(resultMap.get("code"));
        System.out.println(resultMap.get("data"));
    }


    @Test
    public void scanQuestionScoreList() throws Exception{
        String url = "https://zledusxapi.cailian.net/api-score/noAuth/scan-question-score-list";
        Map<String,Object> map = new HashMap<>();
        map.put("examId","104275091001");
        map.put("examPlan","10000587");
        map.put("paperCode","ea04ee51-e3bc-453f-b265-a44e311bb980");
        List<Header> headers = new ArrayList<>();
        Header header = new Header();
        header.setName("Authorization");
        header.setValue("bearer c1122878-316a-48bd-a088-88ac7a8eb0f3");
        String result = HttpUtil.doPostWithHeader(url,headers,map,false);
        System.out.println(result);
    }


}