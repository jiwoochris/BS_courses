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
			FileReader reader = new FileReader("ServerInfo.dat");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            serverIP = bufferedReader.readLine();
            nPort = Integer.parseInt(bufferedReader.readLine());
            reader.close();
 
        } catch (IOException e) {
            System.out.println(e.getMessage());
            serverIP = "127.0.0.1";
            nPort = 6789;
        }

		welcomeSocket = new ServerSocket(nPort);
		System.out.println("Server start.. (port#=" + nPort + ")\n");

		while(true) {
			Socket connectionSocket = welcomeSocket.accept(); 

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream())); 

			DataOutputStream outToClient = 
					new DataOutputStream(connectionSocket.getOutputStream()); 

			clientSentence = inFromClient.readLine();
			System.out.println("FROM CLIENT: " + clientSentence );
			
			output_string = calculation(clientSentence);
			
			System.out.println(output_string);

			outToClient.writeBytes(output_string + "\n"); 
		} 
	}
	
	public static void argument(int length) throws Exception{
		if(length > 3)
			throw new Exception("Too many arguments");
		else if(length < 3)
			throw new Exception("You must have two arguments");
	}
		
	public static String calculation(String clientSentence) {
		int result = 0;
		String[] input = clientSentence.split(" ");
		
		try {
			argument(input.length);
			switch(input[0]) {
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
				return "[error] Wrong Operation (Only ADD, MINUS, MULTI, DIV)";
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "[error] " + e.getMessage();
		}
	}
}

