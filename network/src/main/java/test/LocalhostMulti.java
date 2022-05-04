package test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class LocalhostMulti {

	public static void main(String[] args) {

		try {
			InetAddress inetAddress = InetAddress.getLocalHost();

			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();

			// System.out.println(hostName);
			// 
			System.out.println(hostAddress);

			// System.out.println(Inet4Address.getLocalHost().getHostAddress());
			// System.out.println(InetAddress.getLocalHost().getHostAddress());

			
			byte[] addresses = inetAddress.getAddress();
			for (byte address : addresses) {
				// 맨앞의 부호비트로 인해 음수가 나온다
				// System.out.print((int)address);
				// 비트 연산을 사용하여 앞의 부호비트를 날리고 뒤의 숫자를 살린다
				//System.out.print(address & 0x000000ff);
				//System.out.print('.');
				

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		Enumeration e = null;
		try {
			e = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(e.hasMoreElements())
		{
		    NetworkInterface n = (NetworkInterface) e.nextElement();
		    Enumeration ee = n.getInetAddresses();
		    while (ee.hasMoreElements())
		    {
		        InetAddress i = (InetAddress) ee.nextElement();
		        System.out.println(i.getHostAddress());
		    }
		}

	}

}
