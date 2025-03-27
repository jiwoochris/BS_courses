package myPackage;

public class Ex10_1c_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex10_1c_RegularPay r = new Ex10_1c_RegularPay(10.5);
		Ex10_1c_HazardPay h = new Ex10_1c_HazardPay(10.5);
		
		System.out.println(r.computePay(5));
		System.out.println(h.computePay(5));
	}

}
