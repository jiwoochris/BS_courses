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
		LocalDate today = LocalDate.now(); // ���� ��¥
		String todayString = today.format(DateTimeFormatter.ofPattern("yyyyMMdd")); // ���� ��¥ �˻� ���ǿ� �°� ����
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=T50%2Bc59xrngJB7TvcxAC93ig2V8pIfbcFT81Qmm3xPCGYUrBvrRuoWYMQGNG5w8%2B5Nm7C8kmMq4IakdSNdv9Yg%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*�� ������ ��� ��*/
		urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*��û�ڷ�����(XML/JSON) Default: XML*/
		urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(todayString, "UTF-8")); /*���� ��¥*/
		urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0000", "UTF-8")); /*00�� */
		urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*���������� X ��ǥ��*/
		urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*���������� Y ��ǥ��*/
		URL url = new URL(urlBuilder.toString()); // URL ��ü ����
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // HTTP URL ��ü ����
		conn.setRequestMethod("GET"); // HTTP method ����
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("[" + today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "] �ܱ⿹��"); // ���� ��¥ ���
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
        JSONObject jResponse = (JSONObject) jsonObj.get("response");
        JSONObject jBody = (JSONObject) jResponse.get("body");
        JSONObject jItems = (JSONObject) jBody.get("items");
        JSONArray jItem = (JSONArray) jItems.get("item");
        
        String[] info = new String[8];

        for(int i=0 ; i<jItem.size() ; i++){
        	JSONObject itemObj = (JSONObject) jItem.get(i); // parse �� ���ϴ� ������ ����
        	info[i] = (String) itemObj.get("obsrValue"); // String �迭 info�� ������ ����
        }
        
       if(info[0].equals("0")) // ���� ���� �ڵ带 ���� ���� ��ȯ
    	   info[0] = "����";
       else if(info[0].equals("1"))
    	   info[0] = "��";
       else if(info[0].equals("2"))
    	   info[0] = "�� / ��";
       else if(info[0].equals("3"))
    	   info[0] = "��";
       else if(info[0].equals("4"))
    	   info[0] = "�ҳ���";
       
       // output ���
       System.out.println("���� ���� : " + info[0]);
       System.out.println("���� : " + info[1] + " %");
       System.out.println("1�ð� ������ : " + info[2] + " mm");
       System.out.println("��� : " + info[3] + " ��C");
       System.out.println("ǳ�� : " + info[5] + " ��");
       System.out.println("ǳ�� : " + info[7] + " m/s");
	}
}