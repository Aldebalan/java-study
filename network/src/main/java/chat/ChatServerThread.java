package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	

	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	public ChatServerThread(Socket socket, List<Writer>listWriters ) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	/* 요청 처리 */
	@Override
	public void run() {	
		try {
			// 2. 스트림 얻기
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
					
			// 3. 요청 처리
			while (true) {
				String request = bufferedReader.readLine();
				if (request == null) {
					log("클라이언트로부터 연결 끊김");
					doQuit(printWriter);
					break;
				}
				
				// 4. 프로토콜 분석 
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1], printWriter);
				}else if("quit".equals(tokens[0])) {
					doQuit(printWriter);
				}else if("null".equals(tokens[0])) {
					log("채팅을 입력해주세요");
				}else {
					log("ERROR!! 알 수 없는 요청(" + tokens[0] + ")");
				}
			}
			
			

		} catch (IOException e) {
			System.out.println("ERROR : " + e);
		}
	}

	

	private void doMessage(String message, PrintWriter writer) {
		String data = nickname + ">>" +  message;
		broadcast(data);
	}


	private void doJoin(String nickname, PrintWriter writer) {
		this.nickname = nickname;
		
		String data = nickname + "님이 참가하였습니다.";
		broadcast(data);
		
		/* writer pool에 저장 */
		addWriter(writer);
		
		//ack
		writer.println("입장하셨습니다. 즐거운 채팅되세요~");
		writer.flush();
	}

	private void addWriter(Writer writer) { 
		System.out.println("<<");
		synchronized (listWriters) { //synchronized  키워드는  여러 스레드가  하나의 공유 객체에 접근할  때,  동기화를 보장 해준다
			listWriters.add(writer);
		}
	}
	
	//서버에 연결된 모든 클라이언트에 메시지를 보내는(브로드캐스트) 메소드​
	private void broadcast(String data) { 
		synchronized (listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
	
	private void doQuit(Writer writer) {
		String data = nickname + "님이 퇴장하셨습니다.";
		removeWriter(writer);		
		broadcast(data);
	}


	private void removeWriter(Writer writer) {
		listWriters.remove(writer);
	}
	
	
	public static void log(String log) {
		System.out.println("[Info] " + log);
	}
}