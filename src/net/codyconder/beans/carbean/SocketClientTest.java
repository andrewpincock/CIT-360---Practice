package net.codyconder.beans.carbean;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class SocketClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket toServer = new Socket("127.0.0.1", 9889);
		
		JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());

	}

}
