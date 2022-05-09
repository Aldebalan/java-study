package chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	public static List<Writer> listWriters = new ArrayList<Writer>();
	public static Writer printWriter = new OutputStreamWriter(System.out);

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	// 1. Remote Host Information

	// 2. 스트림 얻기
	// bufferedReader = new BufferedReader(new
	// InputStreamReader(socket.getInputStream(),StandardCharset.UTF_8));
	// printWriter=new
	// PrintWriter(new
	// OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
	InputStream input = socket.getInputStream();
	BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	// 3. 요청 처리
	while(true)
	{

		List<Writer> listWriters;
		new ChatServerThread(socket, listWriters).start();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String request = bufferedReader.readLine();
		if (request == null) {
			System.out.println("클라이언트로 부터 연결 끊김");
			doQuit(printWriter);
			break;
		}

		// 4. 프로토콜 분석
		String[] tokens = request.split(":");

		if ("join".equals(tokens[0])) {
			dojoin(tokens[1], printWriter);
		} else if ("message".equals(tokens[0])) {
			doMessage(tokens[1]);
		} else if ("quit".equals(tokens[0])) {
			doQuit(null);
		} else {
			ChatServer.log("에러: 알 수 없는 요청 (" + tokens[0] + ")");
		}

	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void dojoin(String nickname, Writer writer) {
		this.nickname = nickname;

		String data = nickname + "님이 참여하였습니다.";
		broadcast(data);

		// writer pool에 저장
		addWriter(writer);

		// ack
		PrintWriter printWriter = (PrintWriter) writer;
		printWriter.println("join:ok");
		printWriter.flush();

	}

	private void doMessage(String string) {
		// TODO Auto-generated method stub

	}

	private void doQuit(Writer writer) {
		removeWriter(writer);

		String data = nickname + "님이 퇴장 하였습니다";
		broadcast(data);

	}

	private void removeWriter(Writer writer) {
		// TODO Auto-generated method stub

	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			PrintWriter writer;
			PrintWriter printWriter = (PrintWriter) writer;
			printWriter.println(data);
			printWriter.flush();
		}
	}

}
