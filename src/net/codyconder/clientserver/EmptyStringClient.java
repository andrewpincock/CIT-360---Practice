package net.codyconder.clientserver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//import net.codyconder.beans.carbean.OwnerBean;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

/*
 * This tests to see what happens when we send an empty string to the server.
 * The server will throw an exception (which is handled).
 * The client will then crash (bang, boom).
 */

public class EmptyStringClient {

	public static void main(String[] args) throws UnknownHostException, IOException, JSONException {
		// Create an owner
		// OwnerBean anOwner = new OwnerBean(1,"Cody","Conder","male");

		Socket toServer = new Socket("127.0.0.1", 9889);
		toServer.setSoTimeout(5000);
		System.out.println("Connection made");
		JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
		System.out.println("Streams set up");
		outToServer.writeObject("");
		System.out.println("Empty string sent");
		System.out.println(inFromServer.readObject());
		
		toServer.close();
		System.out.println("Connection closed");
	}

}
