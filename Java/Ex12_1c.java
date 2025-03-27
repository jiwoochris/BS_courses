package myPackage;

public class Ex12_1c {
	static int count=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countDigit("010-1234-5678"));
		count=0;
		System.out.println(countDigit("010-1234-5678/1&2#8"));
		count=0;
		System.out.println(countDigit("a0a1a0a-a1a2a3a4a-a5a6a7a8a"));

	}
	
	public static int countDigit(String s) {
		if(s.length()>0) {
			if(s.charAt(0)>='0' && s.charAt(0)<='9')
				count++;
			countDigit(s.substring(1));
		}
		
		return count;
			
	}

}
