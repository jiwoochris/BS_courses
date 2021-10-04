import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatServer {
 
	public static void main(String[] args) {
		BufferedReader in = null;
		Scanner stin = null;
		BufferedWriter out = null;

		ServerSocket listener = null;
		Socket socket = null;

		try {
			listener = new ServerSocket(9999); // ���� ���� ����
			
			System.out.println("Start Server...");
			System.out.println("Waiting for clients");
			
			socket = listener.accept(); // Ŭ���̾�Ʈ�κ��� ���� ��û ���

			System.out.println("A new connection has been established!");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Ŭ���̾�Ʈ�κ����� �Է� ��Ʈ��
			stin = new Scanner(System.in); // Ű����κ����� �Է� ��Ʈ��
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Ŭ���̾�Ʈ���� ��� ��Ʈ��

			String inputMessage;

			while (true) {

				inputMessage = in.readLine(); // Ŭ���̾�Ʈ���� �� ���� ���ڿ� ����

				if (inputMessage.equalsIgnoreCase("bye")){ // Ŭ���̾�Ʈ�� "bye"�� ������ ���� ����
					System.out.println("Bye");
					break;
				}

				System.out.println(inputMessage); // Ŭ���̾�Ʈ�� ���� �޽��� ȭ�鿡 ���
				String outputMessage = stin.nextLine(); // Ű���忡�� �� ���� ���ڿ� ����
				out.write("����>" + outputMessage+"\n"); // Ű���忡�� ���� ���ڿ� ����
				out.flush();

			}

		} catch (IOException e) {

			System.out.println(e.getMessage());

		} finally {//try���� ���������� �����.

			try {
				socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�
				listener.close(); // ���� ���� �ݱ�
			} catch (IOException e) {
				System.out.println("Ŭ���̾�Ʈ�� ä�� �� ������ �߻��߽��ϴ�.");
			}
		}
	}
}

