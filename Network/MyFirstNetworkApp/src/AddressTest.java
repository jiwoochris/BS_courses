import java.net.*;

public class AddressTest {
	
	public static void main(String args[]) throws UnknownHostException {
		InetAddress Address = InetAddress.getLocalHost();
		System.out.println("���� ��ǻ���� �̸� : " + Address.getHostName());
		System.out.println("���� ��ǻ���� IP �ּ� : " + Address.getHostAddress());
		
		Address = InetAddress.getByName("www.google.com");
		System.out.println("java.sun.com ��ǻ���� �̸��� IP �ּ� : " + Address);
		InetAddress all[] = InetAddress.getAllByName("www.naver.com");
		
		for (int i=0; i < all.length; i++)
			System.out.println(all[i]);
	}
}