package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class ChatClient {
	private static final String SERVER_IP_STRING = "127.0.0.1";
	private static final int SERVER_PORT = 9999;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			socket = new Socket();
			scanner = new Scanner(System.in);
			
			//연결
			socket.connect(new InetSocketAddress(SERVER_IP_STRING, SERVER_PORT));

			// reader / writer 생성
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

			// ChatClientThread 시작
			ChatClientThread clientThread = new ChatClientThread(socket);
			clientThread.start();
			
			// join 프로토콜
			System.out.print("nickname:");
			String name = scanner.nextLine();
			printWriter.println("join:"+name);
			printWriter.flush();
			
			// 키보드 입력처리
			while(true) {
				//System.out.print(">>");
				String input = scanner.nextLine();
				
				if("".equals(input)) {
					printWriter.println("null:");
					printWriter.flush();
				}else if("quit".equals(input)) {
					printWriter.println("quit:");
					printWriter.flush();
					break;
				}else {
					printWriter.println("message:"+input);
					printWriter.flush();
				}
			}
						
			
		} catch (IOException e) {
			System.out.println("ERROR:"+ e);
		}

	}

}