package chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	private static final int PORT = 5555;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림" + hostAddress + ":" + PORT);

			// 3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();
				new EchoChatServerThread().start();
			}

		} catch (IOException e) {
			System.out.println("[Server] error : " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false)
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	static void log(String log) {
		System.out.println("[Echo Client] " + log);
	}
}
