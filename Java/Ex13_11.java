package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex13_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "words.txt";
		String outputFileName = "Ex13_11_output.txt";
		
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Problem open file "+fileName);
			System.exit(0);
		}
		
		PrintWriter output  = null;
		try {
			output = new PrintWriter(new File(outputFileName));
		} catch(FileNotFoundException e) {
			System.out.println("Problem open file "+fileName);
			System.exit(0);
		}
		
		while(input.hasNext())
		{
			String word = input.next();
			if(word.charAt(word.length()-1) == 's'
					&& word.charAt(word.length()-2) == 'u'
					&& word.charAt(word.length()-3) == 'o'
					&& word.charAt(word.length()-4) == 'd')
			output.println(word);
		}
		input.close();
		output.close();
	}
}
