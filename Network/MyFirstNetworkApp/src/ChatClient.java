 import java.io.*;
import java.net.*;

public class ChatClient {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedReader stin = null;
		BufferedWriter out = null;

		Socket socket = null;

		try {
			socket = new Socket("localhost", 9999); // Ŭ���̾�Ʈ ���� ����

			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // �����κ����� �Է� ��Ʈ��
			stin = new BufferedReader(new InputStreamReader(System.in)); // Ű����κ����� �Է� ��Ʈ��

			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // �������� ��� ��Ʈ��

			String outputMessage;
			while (true) {
				outputMessage = stin.readLine(); // Ű���忡�� �� ���� ���ڿ� ����
				if (outputMessage.equalsIgnoreCase("bye")) { // "bye"�� �ԷµǸ� �޽��� ���� �� ���� ����
					out.write(outputMessage);
					out.flush();
					break;
				}
				out.write("Ŭ���̾�Ʈ>"+outputMessage+"\n"); // Ű���忡�� ���� ���ڿ� ����
				out.flush();

				String inputMessage = in.readLine(); // �������� �� ���� ���ڿ� ����
				System.out.println(inputMessage); // ������ ���� �޽��� ȭ�鿡 ���
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close(); // Ŭ���̾�Ʈ ���� �ݱ�
			} catch (IOException e) {
				System.out.println("������ ä�� �� ������ �߻��߽��ϴ�.");
			}
		}
	}
}

