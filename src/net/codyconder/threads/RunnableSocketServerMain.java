package net.codyconder.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RunnableSocketServerMain {

	private static int port = 9889;

	public static void main(String[] args) {
		ServerSocket listeningSocket;
		try {
			listeningSocket = new ServerSocket(port);
			Socket clientSocket;

			while (true) {
				try {
					clientSocket = listeningSocket.accept();
					RunnableSocketServer conn = new RunnableSocketServer(clientSocket);

					Thread t = new Thread(conn);
					t.start();
				} catch (IOException e) {
					System.out.println("IOException on socket listen: " + e);
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("IOException on socket listen: " + e);
			e.printStackTrace();
		}

	}

}
