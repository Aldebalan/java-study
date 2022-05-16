package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final String SERVER_IP_STRING = "127.0.0.1";
	private static final int SERVER_PORT = 9999;
	
	public static void main(String[] args) {
		List<Writer> listWriters = new ArrayList<Writer>();
		
		//1. 서버 소켓 연결	
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();
			//2. 바인딩
			//String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(SERVER_IP_STRING, SERVER_PORT));
			
			//3. 요청 대기
			while(true) {
				Socket socket = serverSocket.accept();
				ChatServerThread chatServerThread = new ChatServerThread(socket, listWriters);
				chatServerThread.start();
			}
			
			
		} catch (UnknownHostException e) {
			System.out.println("Error:"+ e);
		} catch (IOException e) {
			System.out.println("Error:"+ e);
		}
		
		

	}

}