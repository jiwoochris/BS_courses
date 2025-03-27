package myPackage;

public class Ex10_1d_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex10_1d_SubstitutionCipher e1 = new Ex10_1d_SubstitutionCipher(3);
		Ex10_1d_ShuffleCipher e2 = new Ex10_1d_ShuffleCipher(2);
		System.out.println(e1.encode("abced"));
		System.out.println(e2.encode("abced"));

	}

}
