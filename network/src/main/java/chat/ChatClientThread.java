package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClientThread extends Thread {
	private Socket socket;
		
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			while(true) {
				System.out.println( reader.readLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		
		
	}
	
	
}