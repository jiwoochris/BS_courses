import java.io.*;
import java.net.*;

public class CalculatorServer {
	public static void main(String[] args) throws IOException {
		ServerSocket welcomeSocket;
		String clientSentence;
		String output_string;
		String serverIP = null;
		int nPort = 0;
		
		try {
			FileReader reader = new FileReader("ServerInfo.dat"); // 서버의 정보를 담고있는 파일을 읽는다.
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            serverIP = bufferedReader.readLine(); // 첫째 줄에는 server Ip address를 입력했다.
            nPort = Integer.parseInt(bufferedReader.readLine()); // 둘째 줄에는 Port number을 입력
            reader.close();
 
        } catch (IOException e) { // 파일이 존재하지 않거나 오류가 생길시 default 정보 지정
            System.out.println(e.getMessage());
            serverIP = "127.0.0.1";
            nPort = 6789;
        }

		welcomeSocket = new ServerSocket(nPort); // 서버소켓 선언
		System.out.println("Server start.. (port#=" + nPort + ")\n");

		while(true) {
			Socket connectionSocket = welcomeSocket.accept(); // 새로운 소켓이 연결되기를 기다림

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream())); // socket을 통해 Client로부터 읽어오는용

			DataOutputStream outToClient = 
					new DataOutputStream(connectionSocket.getOutputStream()); // socket을 통해 Client에게 보내는용

			clientSentence = inFromClient.readLine(); // Client로부터 1줄을 읽어온다.
			System.out.println("FROM CLIENT: " + clientSentence );
			
			output_string = calculation(clientSentence); // 계산 기능 수행 함수
			
			System.out.println(output_string);

			outToClient.writeBytes(output_string + "\n"); // Client에게 output_string을 \n과 함께 Client에게 전달
		} 
	}
	
	public static void argument(int length) throws Exception{
		if(length > 3)
			throw new Exception("Too many arguments"); // 인자가 너무 적을 경우 에러처리
		else if(length < 3)
			throw new Exception("You must have two arguments"); // 인자가 너무 많을 경우 에러처리
	}
		
	public static String calculation(String clientSentence) {
		int result = 0;
		String[] input = clientSentence.split(" "); // 사용자가 입력한 string을 split
		
		try {
			argument(input.length); // 사용자가 입력한 인자 개수가 3이 아닐시 에러발생
			switch(input[0]) { // 경우에따라 나누어 사칙연산 수행
			case "ADD":
				result = Integer.parseInt(input[1]) + Integer.parseInt(input[2]);
				return Integer.parseInt(input[1]) + " + " + Integer.parseInt(input[2]) + " = " + result;
			case "MINUS":
				result = Integer.parseInt(input[1]) - Integer.parseInt(input[2]);
				return Integer.parseInt(input[1]) + " - " + Integer.parseInt(input[2]) + " = " + result;
			case "DIV":
				result = Integer.parseInt(input[1]) / Integer.parseInt(input[2]);
				return Integer.parseInt(input[1]) + " / " + Integer.parseInt(input[2]) + " = " + result;
			case "MULTI":
				result = Integer.parseInt(input[1]) * Integer.parseInt(input[2]);
				return Integer.parseInt(input[1]) + " * " + Integer.parseInt(input[2]) + " = " + result;
			default:
				return "[error] Wrong Operation (Only ADD, MINUS, MULTI, DIV)"; // 사용자가 다른 operation을 작성했을 때 (Case sensitive!)
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "[error] " + e.getMessage(); // output_string으로 에러메세지를 전달
		}
	}
}

