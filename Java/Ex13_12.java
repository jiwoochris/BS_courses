package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex13_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "haberman.data";
		
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file"+fileName);
			System.exit(0);
		}
		
		int thirdFieldOf1 = 0;
		int thirdFieldOf2 = 0;
		int numberOf1 = 0;
		int numberOf2 = 0;
		
		while(input.hasNextLine())
		{
			String[] data = input.nextLine().split(",");
			if(data[3].equals("1"))
			{
				thirdFieldOf1 += Integer.parseInt(data[2]);
				numberOf1++;
			}
			else if(data[3].equals("2"))
			{
				thirdFieldOf2 += Integer.parseInt(data[2]);
				numberOf2++;
			}
		}
		
		System.out.println("The average number of positive axillary nodes detected for patients");
		System.out.println("who survived 5 years or longer : " + (double)thirdFieldOf1/numberOf1);
		System.out.println("who died within 6 years : " + (double)thirdFieldOf2/numberOf2);
	}
	
}
