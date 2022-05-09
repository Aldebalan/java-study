package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5555;
	public static Writer printWriter = new OutputStreamWriter(System.out);
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			scanner = new Scanner(System.in);
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 1. 키보드 연결
		
			// 2. socket 생성
			
			// 3. 연결
			
			// 4. reader/writer 생성
			
			// 5. join 프로토콜
			System.out.println("닉네임>>");
			String nickname = scanner.nextLine();
			System.out.println("join:" + nickname);;
			printWriter.flush();
			
			// 6.ChatClientRecieveThread 시작
			
			// 7. 키보드 입력 처리
			while(true) {
				System.out.println(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					break;
				} else {
					// 9. 메시지 처리
				}
			}
		} catch(IOException ex) {
			log("error:" + ex);
		} finally {
			// 10. 자원정리
		}
		
	}

	private static void log(String log) {
		System.out.println("[Echo Client] " + log);
	}

}