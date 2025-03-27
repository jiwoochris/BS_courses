package myPackage;

public class Ex10_1d_SubstitutionCipher implements Ex10_1d_MessageEncoder
{
	public int shift;
	public String encodedText="";
	
	public Ex10_1d_SubstitutionCipher(int iniitialShift)
	{
		shift = iniitialShift;
	}
	
	public String encode(String plainText)
	{
		for (int i=0; i<plainText.length(); i++)
			{
				encodedText += (char)(plainText.charAt(i)+shift);
			}
		return encodedText;
	}
	
}
