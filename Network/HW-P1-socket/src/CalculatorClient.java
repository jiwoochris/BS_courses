import java.io.*; 
import java.net.*;
import java.io.FileReader;
import java.io.IOException;

public class CalculatorClient {
	public static void main(String argv[]) throws Exception 
	{ 
		String sentence; 
		String resultFromServer;
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

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); // 사용자로부터 읽어올 수 있도록 하는 버퍼리더

		Socket clientSocket = new Socket(serverIP, nPort); // server ip address와 Port number를 입력해 소켓을 통해 연결

		DataOutputStream outToServer =
				new DataOutputStream(clientSocket.getOutputStream()); // socket을 통해 서버로 보내는용

		BufferedReader inFromServer = 
				new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // socket을 통해 서버로부터 읽어들이는용
		
		System.out.println("Welcome to Calculator (ADD, MINUS, MULTI, DIV)");
		sentence = inFromUser.readLine(); // 사용자로부터 1줄을 읽어온다.

		outToServer.writeBytes(sentence + '\n'); // 읽어온 sentence를 \n와 함께 서버에 전달

		resultFromServer = inFromServer.readLine(); // 서버로부터 line 1줄을 읽어옴

		System.out.println("FROM SERVER: " + resultFromServer);

		clientSocket.close(); // 소켓을 닫고 종료

	} 
}
