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
    	LocalDate today = LocalDate.now(); // ���� ��¥
		String todayString = today.format(DateTimeFormatter.ofPattern("yyyyMMdd")); // ���� ��¥ �˻� ���ǿ� �°� ����
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1480523/MetalMeasuringResultService/MetalService"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=T50%2Bc59xrngJB7TvcxAC93ig2V8pIfbcFT81Qmm3xPCGYUrBvrRuoWYMQGNG5w8%2B5Nm7C8kmMq4IakdSNdv9Yg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*�� ������ ��� ��*/
        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*�������(XML/JSON)*/
        urlBuilder.append("&" + URLEncoder.encode("date","UTF-8") + "=" + URLEncoder.encode(todayString, "UTF-8")); /*�˻����� ��¥ (���� : 20171208)*/
        urlBuilder.append("&" + URLEncoder.encode("stationcode","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*�˻����� �������ڵ�*/
        urlBuilder.append("&" + URLEncoder.encode("itemcode","UTF-8") + "=" + URLEncoder.encode("90303", "UTF-8")); /*�˻����� �׸��ڵ�*/
        urlBuilder.append("&" + URLEncoder.encode("timecode","UTF-8") + "=" + URLEncoder.encode("RH02", "UTF-8")); /*�˻����� �ð�����*/
        URL url = new URL(urlBuilder.toString()); // URL ��ü ����
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // HTTP URL ��ü ����
        conn.setRequestMethod("GET"); // HTTP method ����
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("[" + today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "]"); // ���� ��¥ ���
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); // input�޴� InputStream ����
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); // error�޴� InputStream ����
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line); // InputStream���κ��� ���پ� �޾ƿͼ� ����
        }
        rd.close();
        conn.disconnect();
        
        JSONParser jsonParser = new JSONParser(); // JSONParser ��ü ����

        JSONObject jsonObj = (JSONObject)jsonParser.parse(sb.toString()); // �޾ƿ� ���� parse. �Ʒ� JSONObject�鵵 ������ ���� Parse.
        JSONObject jMetalService = (JSONObject) jsonObj.get("MetalService"); 
        JSONArray jItem = (JSONArray) jMetalService.get("item");
        JSONObject itemObj = (JSONObject) jItem.get(0); // parse �� ���ϴ� ������ ����
        
        System.out.println("���� �ǽð� �̼����� (�ݼӼ���) �ǽð� ��ġ : " + itemObj.get("VALUE") + " ng/m3"); // ������ ���
    }
}