import java.io.*;
import java.net.*;

public class CalculatorServer {
	public static void main(String[] args) throws IOException {
		ServerSocket welcomeSocket;
		String clientSentence;
		int result = 0;
		String output_string = null;
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
			String[] input = clientSentence.split(" ");
			
			try {
				argument(input.length);
				switch(input[0]) {
				case "ADD":
					result = Integer.parseInt(input[1]) + Integer.parseInt(input[2]);
					output_string = Integer.parseInt(input[1]) + " + " + Integer.parseInt(input[2]) + " = " + result + "\n";
					break;
				case "MINUS":
					result = Integer.parseInt(input[1]) - Integer.parseInt(input[2]);
					output_string = Integer.parseInt(input[1]) + " - " + Integer.parseInt(input[2]) + " = " + result + "\n";
					break;
				case "DIV":
					result = Integer.parseInt(input[1]) / Integer.parseInt(input[2]);
					output_string = Integer.parseInt(input[1]) + " / " + Integer.parseInt(input[2]) + " = " + result + "\n";
					break;
				case "MULTI":
					result = Integer.parseInt(input[1]) * Integer.parseInt(input[2]);
					output_string = Integer.parseInt(input[1]) + " * " + Integer.parseInt(input[2]) + " = " + result + "\n";
					break;
				default:
					System.out.println("Wrong Operation (Only ADD, MINUS, MULTI, DIV)");
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
				output_string = e.getMessage();
				outToClient.writeBytes(output_string);
				
				clientSentence = inFromClient.readLine();
				System.out.println("FROM CLIENT: " + clientSentence );
				String[] input = clientSentence.split(" ");
			}
			

			outToClient.writeBytes(output_string); 
		} 
	}
	
	public static void argument(int length) throws Exception{
		if(length > 3) {
			throw new Exception("Too many arguments");
		if(length < 3)
			throw new Exception("You must have two arguments");
	}
}

