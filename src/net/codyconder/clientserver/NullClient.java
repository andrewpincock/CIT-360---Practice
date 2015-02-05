package net.codyconder.clientserver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

// No need to import the OwnerBean, since we won't be using it
//import net.codyconder.beans.carbean.OwnerBean;

import org.quickconnectfamily.json.JSONException;
// import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

/*
 * This tests to see what happens when we send a null object to the server.
 * The server is programmed to handle this, so it should not crash.
 * The client will close the connection after sending the object.
 * If we were to wait for the timeout to expire, the client would crash.
 */

public class NullClient {

	public static void main(String[] args) throws UnknownHostException, IOException, JSONException {
		// -------------------------------------------------------------------------------------- //
		// The various println statements indicate where we are in the execution of the program.  //
		// -------------------------------------------------------------------------------------- //
		
		// Establish a connection with the server
		// and set a timeout so we don't sit here waiting forever (5 seconds)
		Socket toServer = new Socket("127.0.0.1", 9889);
		toServer.setSoTimeout(5000);
		System.out.println("Connection made");
		
		// Set up our JSON stream so we can send data
		// There is no point in setting up an inFromServer stream, since we'll never hear back anyways.
		// JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
		System.out.println("Streams set up");
		
		// Write our null object to the server
		outToServer.writeObject(null);
		System.out.println("Client: Null object sent.");
		
		// We won't hear back from the server until the connection is closed.
		// By then, the client would have crashed.
		// Instead, we'll close the connection and allow the server to continue on.
		toServer.close();
		System.out.println("Connection closed");
	}

}
