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

		welcomeSocket = new ServerSocket(nPort); // �������� ����
		System.out.println("Server start.. (port#=" + nPort + ")\n");

		while(true) {
			Socket connectionSocket = welcomeSocket.accept(); // ���ο� ������ ����Ǳ⸦ ��ٸ�

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream())); // socket�� ���� Client�κ��� �о���¿�

			DataOutputStream outToClient = 
					new DataOutputStream(connectionSocket.getOutputStream()); // socket�� ���� Client���� �����¿�

			clientSentence = inFromClient.readLine(); // Client�κ��� 1���� �о�´�.
			System.out.println("FROM CLIENT: " + clientSentence );
			
			output_string = calculation(clientSentence); // ��� ��� ���� �Լ�
			
			System.out.println(output_string);

			outToClient.writeBytes(output_string + "\n"); // Client���� output_string�� \n�� �Բ� Client���� ����
		} 
	}
	
	public static void argument(int length) throws Exception{
		if(length > 3)
			throw new Exception("Too many arguments"); // ���ڰ� �ʹ� ���� ��� ����ó��
		else if(length < 3)
			throw new Exception("You must have two arguments"); // ���ڰ� �ʹ� ���� ��� ����ó��
	}
		
	public static String calculation(String clientSentence) {
		int result = 0;
		String[] input = clientSentence.split(" "); // ����ڰ� �Է��� string�� split
		
		try {
			argument(input.length); // ����ڰ� �Է��� ���� ������ 3�� �ƴҽ� �����߻�
			switch(input[0]) { // ��쿡���� ������ ��Ģ���� ����
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
				return "[error] Wrong Operation (Only ADD, MINUS, MULTI, DIV)"; // ����ڰ� �ٸ� operation�� �ۼ����� �� (Case sensitive!)
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "[error] " + e.getMessage(); // output_string���� �����޼����� ����
		}
	}
}

