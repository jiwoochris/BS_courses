package myPackage;

public class Ex12_1b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayAsWords(9710);
		displayAsWords(1234809);
		displayAsWords(87263);
		
	}
	
	public static void displayAsWords(int number) {
		String[] word = new String[] {
				"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
		};
		
		String d = "";
		
		while (number>0)
		{
			d= word[number%10] + " " + d;
			number/=10;
		}
		System.out.println(d);
	}

}
