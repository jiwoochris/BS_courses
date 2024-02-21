import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AirPollutionInfo {
    public static void main(String[] args) throws IOException, ParseException {
    	LocalDate today = LocalDate.now(); // 현재 날짜
		String todayString = today.format(DateTimeFormatter.ofPattern("yyyyMMdd")); // 현재 날짜 검색 조건에 맞게 포맷
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1480523/MetalMeasuringResultService/MetalService"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=T50%2Bc59xrngJB7TvcxAC93ig2V8pIfbcFT81Qmm3xPCGYUrBvrRuoWYMQGNG5w8%2B5Nm7C8kmMq4IakdSNdv9Yg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*결과형식(XML/JSON)*/
        urlBuilder.append("&" + URLEncoder.encode("date","UTF-8") + "=" + URLEncoder.encode(todayString, "UTF-8")); /*검색조건 날짜 (예시 : 20171208)*/
        urlBuilder.append("&" + URLEncoder.encode("stationcode","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*검색조건 측정소코드*/
        urlBuilder.append("&" + URLEncoder.encode("itemcode","UTF-8") + "=" + URLEncoder.encode("90303", "UTF-8")); /*검색조건 항목코드*/
        urlBuilder.append("&" + URLEncoder.encode("timecode","UTF-8") + "=" + URLEncoder.encode("RH02", "UTF-8")); /*검색조건 시간구분*/
        URL url = new URL(urlBuilder.toString()); // URL 객체 생성
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // HTTP URL 객체 생성
        conn.setRequestMethod("GET"); // HTTP method 결정
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("[" + today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "]"); // 현재 날짜 출력
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); // input받는 InputStream 생성
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); // error받는 InputStream 설정
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line); // InputStream으로부터 한줄씩 받아와서 저장
        }
        rd.close();
        conn.disconnect();
        
        JSONParser jsonParser = new JSONParser(); // JSONParser 객체 생성

        JSONObject jsonObj = (JSONObject)jsonParser.parse(sb.toString()); // 받아온 정보 parse. 아래 JSONObject들도 구조에 따라 Parse.
        JSONObject jMetalService = (JSONObject) jsonObj.get("MetalService"); 
        JSONArray jItem = (JSONArray) jMetalService.get("item");
        JSONObject itemObj = (JSONObject) jItem.get(0); // parse 후 원하는 데이터 추출
        
        System.out.println("현재 실시간 미세먼지 (금속성분) 실시간 수치 : " + itemObj.get("VALUE") + " ng/m3"); // 데이터 출력
    }
}