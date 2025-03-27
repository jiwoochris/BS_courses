package myPackage;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Ex13_1b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "names.txt";
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the File " + fileName);
			System.exit(0);
		}
		
		String newFileName = "new names.txt";
		PrintWriter output = null;
		try {
			output = new PrintWriter(newFileName);
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the File " + newFileName);
			System.exit(0);
		}
		
		int i = 0;
		while(input.hasNext())
		{
			String name = input.next();
			if(i%2==0)
				output.print(name + " ");
			else
				output.println(name);
			i++;
		}
		
		input.close();
		output.close();
	}

}
