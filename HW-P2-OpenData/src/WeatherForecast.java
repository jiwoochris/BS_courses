import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.json.simple.*;
import org.json.simple.parser.*;

public class WeatherForecast {
	
	public static void main(String[] args) throws IOException, ParseException {
		LocalDate today = LocalDate.now();
		String todayString = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=T50%2Bc59xrngJB7TvcxAC93ig2V8pIfbcFT81Qmm3xPCGYUrBvrRuoWYMQGNG5w8%2B5Nm7C8kmMq4IakdSNdv9Yg%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
		urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(todayString, "UTF-8")); /*‘21년 6월 28일 발표*/
		urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0000", "UTF-8")); /*06시 발표(정시단위) */
		urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*예보지점의 X 좌표값*/
		urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		
		JSONParser jsonParser = new JSONParser();

        JSONObject jsonObj = (JSONObject)jsonParser.parse(sb.toString());
        JSONObject jResponse = (JSONObject) jsonObj.get("response");
        JSONObject jBody = (JSONObject) jResponse.get("body");
        JSONObject jItems = (JSONObject) jBody.get("items");
        JSONArray jItem = (JSONArray) jItems.get("item");
        
        String[] info = new String[8];

        for(int i=0 ; i<jItem.size() ; i++){
        	JSONObject itemObj = (JSONObject) jItem.get(i);
        	info[i] = (String) itemObj.get("obsrValue");
        }
        
       if(info[0].equals("0"))
    	   info[0] = "없음";
       else if(info[0].equals("1"))
    	   info[0] = "비";
       else if(info[0].equals("2"))
    	   info[0] = "비 / 눈";
       else if(info[0].equals("3"))
    	   info[0] = "눈";
       else if(info[0].equals("4"))
    	   info[0] = "소나기";
        
        System.out.println("강수 형태 : " + info[0]);
        System.out.println("습도 : " + info[1] + " %");
        System.out.println("1시간 강수량 : " + info[2] + " mm");
        System.out.println("기온 : " + info[3] + " °C");
        System.out.println("풍향 : " + info[5] + " °");
        System.out.println("풍속 : " + info[7] + " m/s");
	}
}