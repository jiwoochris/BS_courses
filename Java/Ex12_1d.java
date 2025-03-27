package myPackage;

public class Ex12_1d {
	static String forward = "";
	static String backward = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPalindrome("radar"));
		forward="";
		backward="";
		System.out.println(checkPalindrome("Straw? No, too stupid a fad, I put soot on warts."));

	}
	
	public static boolean checkPalindrome(String s) {
		
		if(s.length()>0) {
			if(s.charAt(0)!=' ' && s.charAt(0)!=',' && s.charAt(0)!='?' && s.charAt(0)!='!' && s.charAt(0)!='.')
				{
					backward = s.charAt(0)+backward;
					forward += s.charAt(0);
				}
			checkPalindrome(s.substring(1));
		}
		
		return forward.equalsIgnoreCase(backward);
	}
}
