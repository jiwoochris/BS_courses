package myPackage;

public class Ex10_1d_ShuffleCipher implements Ex10_1d_MessageEncoder
{
	public int n;
	public String encodedText="";
	public int median;
	public boolean isOdd;
	
	public Ex10_1d_ShuffleCipher(int initialN) {
		n = initialN;
	}
	
	public String encode(String plainText) {
		if(plainText.length()%2==0)
			{
				median = plainText.length()/2;
				isOdd = false;
			}
		else
		{
			median = (plainText.length()+1)/2;
			isOdd = true;
		}
		
		String t1 = plainText.substring(0, median);
		String t2 = plainText.substring(median);
		
		for(int i=0; i<n; i++)
		{
			encodedText="";
			for (int j=0; j<t1.length()-1; j++)
			{
				encodedText += (char)t1.charAt(j);
				encodedText += (char)t2.charAt(j);
			}
			if (isOdd)
				encodedText += t1.charAt(t1.length()-1);
			
			t1 = encodedText.substring(0, median);
			t2 = encodedText.substring(median);
		}
		
		return encodedText;
	}
}
