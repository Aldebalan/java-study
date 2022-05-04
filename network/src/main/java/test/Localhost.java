package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {

	public static void main(String[] args) {

		try {
			InetAddress inetAddress = InetAddress.getLocalHost();

			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();

			System.out.println(hostName);
			System.out.println(hostAddress);

			byte[] addresses = inetAddress.getAddress();
			for (byte address : addresses) {
				// 맨앞의 부호비트로 인해 음수가 나온다
				// System.out.print((int)address);
				// 비트 연산을 사용하여 앞의 부호비트를 날리고 뒤의 숫자를 살린다
				System.out.print(address & 0x000000ff);
				System.out.print('.');
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
