package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex13_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "Ex13_7_abbreviations.txt";
		String inputFileName = "Ex13_7_input.txt";
		String outputFileName = "Ex13_7_output.txt";
		
		try {
			Scanner input = new Scanner(new File(inputFileName));
			String message = input.nextLine();
			input.close();
			
			String m[] = message.split(" ");
			
			Scanner abb = new Scanner(new File(fileName));
			
			
			while(abb.hasNext())
			{
				String contain = abb.next();
				for(int i = 0; i<m.length; i++)
				{
					if(contain.equalsIgnoreCase(m[i]))
					{
						m[i] = "<"+m[i]+">";
						break;
					}
				}
			}
			abb.close();
			
			PrintWriter output = new PrintWriter(new File(outputFileName));
			for(int i = 0; i<m.length; i++)
				output.print(m[i]+" ");
			output.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error to open file "+ outputFileName);
			System.exit(0);
		}
	}
}
