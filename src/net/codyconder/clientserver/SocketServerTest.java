package net.codyconder.clientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class SocketServerTest {

	public static void main(String[] args) throws IOException {
		ServerSocket listeningSocket = new ServerSocket(9889);
		Socket clientSocket = listeningSocket.accept();
		
		JSONInputStream inFromClient = new JSONInputStream(clientSocket.getInputStream());
		JSONOutputStream outToClient = new JSONOutputStream(clientSocket.getOutputStream());

	}

}
