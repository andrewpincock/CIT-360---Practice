package net.codyconder.clientserver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//import net.codyconder.beans.carbean.OwnerBean;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

/*
 * This tests to see what happens when we send a null to the server.
 * The server will hang until this thread is terminated.
 * The server will then crash (bang, boom).
 */

public class IntClient {

	public static void main(String[] args) throws UnknownHostException, IOException, JSONException {
		// Create an owner
		// OwnerBean anOwner = new OwnerBean(1,"Cody","Conder","male");

		Socket toServer = new Socket("127.0.0.1", 9889);
		toServer.setSoTimeout(5000);
		System.out.println("Connection made");
		JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
		System.out.println("Streams set up");
		outToServer.writeObject(145);
		System.out.println("Integer (145) sent");
		System.out.println(inFromServer.readObject());
		
		toServer.close();
		System.out.println("Connection closed");
	}

}
