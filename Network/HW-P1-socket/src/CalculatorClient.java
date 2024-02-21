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
			FileReader reader = new FileReader("ServerInfo.dat"); // ������ ������ ����ִ� ������ �д´�.
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            serverIP = bufferedReader.readLine(); // ù° �ٿ��� server Ip address�� �Է��ߴ�.
            nPort = Integer.parseInt(bufferedReader.readLine()); // ��° �ٿ��� Port number�� �Է�
            reader.close();
 
        } catch (IOException e) { // ������ �������� �ʰų� ������ ����� default ���� ����
            System.out.println(e.getMessage());
            serverIP = "127.0.0.1";
            nPort = 6789;
        }

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); // ����ڷκ��� �о�� �� �ֵ��� �ϴ� ���۸���

		Socket clientSocket = new Socket(serverIP, nPort); // server ip address�� Port number�� �Է��� ������ ���� ����

		DataOutputStream outToServer =
				new DataOutputStream(clientSocket.getOutputStream()); // socket�� ���� ������ �����¿�

		BufferedReader inFromServer = 
				new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // socket�� ���� �����κ��� �о���̴¿�
		
		System.out.println("Welcome to Calculator (ADD, MINUS, MULTI, DIV)");
		sentence = inFromUser.readLine(); // ����ڷκ��� 1���� �о�´�.

		outToServer.writeBytes(sentence + '\n'); // �о�� sentence�� \n�� �Բ� ������ ����

		resultFromServer = inFromServer.readLine(); // �����κ��� line 1���� �о��

		System.out.println("FROM SERVER: " + resultFromServer);

		clientSocket.close(); // ������ �ݰ� ����

	} 
}
