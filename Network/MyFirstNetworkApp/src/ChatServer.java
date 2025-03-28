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
			listener = new ServerSocket(9999); // 서버 소켓 생성
			
			System.out.println("Start Server...");
			System.out.println("Waiting for clients");
			
			socket = listener.accept(); // 클라이언트로부터 연결 요청 대기

			System.out.println("A new connection has been established!");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터의 입력 스트림
			stin = new Scanner(System.in); // 키보드로부터의 입력 스트림
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림

			String inputMessage;

			while (true) {

				inputMessage = in.readLine(); // 클라이언트에서 한 행의 문자열 읽음

				if (inputMessage.equalsIgnoreCase("bye")){ // 클라이언트가 "bye"를 보내면 연결 종료
					System.out.println("Bye");
					break;
				}

				System.out.println(inputMessage); // 클라이언트가 보낸 메시지 화면에 출력
				String outputMessage = stin.nextLine(); // 키보드에서 한 행의 문자열 읽음
				out.write("서버>" + outputMessage+"\n"); // 키보드에서 읽은 문자열 전송
				out.flush();

			}

		} catch (IOException e) {

			System.out.println(e.getMessage());

		} finally {//try문을 빠져나가면 실행됨.

			try {
				socket.close(); // 클라이언트와 통신용 소켓 닫기
				listener.close(); // 서버 소켓 닫기
			} catch (IOException e) {
				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
			}
		}
	}
}

