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

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 

		Socket clientSocket = new Socket(serverIP, nPort);

		DataOutputStream outToServer =
				new DataOutputStream(clientSocket.getOutputStream());

		BufferedReader inFromServer = 
				new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		System.out.println("Welcome to Calculator (ADD, MINUS, MULTI, DIV)");
		sentence = inFromUser.readLine();

		outToServer.writeBytes(sentence + '\n');

		resultFromServer = inFromServer.readLine(); 

		System.out.println("FROM SERVER: " + resultFromServer);

		clientSocket.close(); 

	} 
}
