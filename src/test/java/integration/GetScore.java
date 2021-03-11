package integration;

import Util.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPatch;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.httpclient.Header;
import org.testng.annotations.Test;

import java.util.*;

public class GetScore {
    Map<String, String> headers = new HashMap<String, String>();
    Map<String, String> paramMap = new HashMap<String, String>();
    Map<String, String> resultMap = new HashMap<String, String>();
    String nativeJsonTag = "";//表示post发送的参数是json格式，放入paramMap中的第一个key

    public GetScore() {
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        headers.put("Connection", "keep-alive");
        headers.put("Host", "zledusxapi.cailian.net");
        headers.put("Origin", "https://eduresourcesx.cailian.net");
        headers.put("Referer", "https://eduresourcesx.cailian.net/");
        headers.put("sec-ch-ua", "\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"");
        headers.put("sec-ch-ua-mobile", "?0");
        headers.put("Sec-Fetch-Dest", "empty");
        headers.put("Sec-Fetch-Mode", "cors");
        headers.put("Sec-Fetch-Site", "same-site");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.72 Safari/537.36");

        headers.put("authorization", "bearer bbeb5f52-ab62-44db-a903-5b1f38a557a2");
        nativeJsonTag = "test_native_json";
    }

    @Test
    public void token() {
        String sx_url = "https://zledusxapi.cailian.net/api-oauth/oauth2/token";
        headers.put("Content-Length", "178");
        headers.put("content-type", "application/x-www-form-urlencoded");

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
        headers.put("Content-Length", "16");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        paramMap.put("appFlag", "resource");
        resultMap = SendUtil.sendPostVSToken(sx_url, headers, paramMap, "POST");
        System.out.println(resultMap.get("code"));
        System.out.println(resultMap.get("data"));
    }


    @Test
    public void exam() {
        String url = "https://zledusxapi.cailian.net/api-resource/resources/soreView/exam";
        headers.put("Content-Length", "25");
        headers.put("Content-Type", "application/json;charset=UTF-8");
        String json = "{\"cardNo\": \"210305000008\"}";
        paramMap.put(nativeJsonTag, json);
        resultMap = SendUtil.sendPostVSToken(url, headers, paramMap, "POST");
        System.out.println(resultMap.get("code"));
        System.out.println(resultMap.get("data"));
    }

    //传参：examId  examPlan  paperCode
    public void scanQuestionScoreList(String examId,String examPlan,String papercode) {
        String url = "https://zledusxapi.cailian.net/api-score/noAuth/scan-question-score-list";
        headers.put("Content-Length", "98");
        headers.put("Content-Type", "application/json;charset=UTF-8");
//        String json = "{\"examId\": \"+"+examId+"+\", \"examPlan\": \"+"+examPlan+"+\", \"paperCode\": \"ea04ee51-e3bc-453f-b265-a44e311bb980\"}";
        String json = "{\"examId\": \"+"+examId+"+\", \"examPlan\": \"+"+examPlan+"+\", \"paperCode\": \"+"+papercode+"+\"}";

        paramMap.put(nativeJsonTag, json);
        resultMap = SendUtil.sendPostVSToken(url, headers, paramMap, "POST");
        System.out.println("resultMap = " + resultMap);

        JsonParser jp = new JsonParser();
        JsonArray datas = jp.parse(resultMap.get("data")).getAsJsonObject().getAsJsonArray("data");
        int size = datas.size();
        Double allScore = 0d;
        Double allRoundScore = 0d;
        for (int i = 0; i < size; i++) {
            JsonObject jo = (JsonObject) datas.get(i);
            allScore += new Double(jo.get("questionScore").toString());
            allRoundScore += new Double(jo.get("questionRoundScore").toString());
            System.out.println(i + "--" + jo.get("questionScore") + "," + jo.get("questionRoundScore"));
        }
        System.out.println("allScore : " + allScore);
        System.out.println("allRoundScore : " + allRoundScore);

    }

//
//    @Test
//    public void exam1() throws Exception {
//        String url = "https://zledusxapi.cailian.net/api-resource/resources/soreView/exam";
//        Map<String, Object> map = new HashMap<>();
//        map.put("cardNo", "210305000008");
//        List<Header> headers = new ArrayList<>();
//        Header header = new Header();
//        header.setName("Authorization");
//        header.setValue("bearer bbeb5f52-ab62-44db-a903-5b1f38a557a2");
//        headers.add(header);
//        String result = HttpUtil.doPostWithHeader(url, headers, map, false);
//        System.out.println(result);
//
//        JsonParser js = new JsonParser();
//        JsonObject data = js.parse(result).getAsJsonObject().getAsJsonObject("data");
//        String planName = data.get("planName").toString();
//        System.out.println(planName);
//
//
//    }
//
//    @Test
//    public void scanQuestionScoreList1() throws Exception {
//        String resultMap = new String();
//        String url = "https://zledusxapi.cailian.net/api-score/noAuth/scan-question-score-list";
//        Map<String, Object> map = new HashMap<>();
//        map.put("examId", "104275091001");
//        map.put("examPlan", "10000587");
//        map.put("paperCode", "ea04ee51-e3bc-453f-b265-a44e311bb980");
//        List<Header> headers = new ArrayList<>();
//        Header header = new Header();
//        header.setName("Authorization");
//        header.setValue("bearer bbeb5f52-ab62-44db-a903-5b1f38a557a2");
//        headers.add(header);
//        resultMap = HttpUtil.doPostWithHeader(url, headers, map, false);
//        System.out.println("resultMap = " + resultMap);
//        String questionScore = null;
//        JsonParser jp = new JsonParser();
//        JsonArray data = jp.parse(resultMap).getAsJsonObject().getAsJsonArray("data");
//        for (int i = 0; i < data.size(); i++) {
//            JsonObject jsonObject = (JsonObject) data.get(i);
//            questionScore = jsonObject.get("questionScore").toString();
//            System.out.println(questionScore);
//
//        }
//    }

}




















