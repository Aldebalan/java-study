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
	private static final int SERVER_PORT = 7777;
	public static Writer printWriter = new OutputStreamWriter(System.out);

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");

			// 4. reader/writer 생성
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 5. join 프로토콜
			System.out.println("닉네임>>");
			String nickname = scanner.nextLine();
			System.out.println("join:" + nickname);
			printWriter.flush();

			if ("join:ok".equals(bufferedReader.readLine())) {
				System.out.println("즐거운 채팅하세요! " + nickname + " 님!");

				// 6.ChatClientRecieveThread 시작
				new ChatClientThread(bufferedReader).start();

				// 7. 키보드 입력 처리
				while (true) {
					System.out.println(">>");
					String input = scanner.nextLine();

					if ("quit".equals(input) == true) {
						// 8. quit 프로토콜 처리
						printWriter.println("quit");
						break;
					} else {
						// 9. 메시지 처리
						if(input.length() == 0)
						{
							input=" ";
						}
						printWriter.println("message:" + input);
					}
				}
			}
		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			// 10. 자원정리
			if(scanner != null) {
				scanner.close();
			}
			if(socket != null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static void log(String log) {
		System.out.println("[ChatClient] " + log);
	}

}