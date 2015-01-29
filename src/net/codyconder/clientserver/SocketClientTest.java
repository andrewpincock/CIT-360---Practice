package net.codyconder.clientserver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import net.codyconder.beans.carbean.OwnerBean;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class SocketClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException, JSONException {
		// Create an owner
		OwnerBean anOwner = new OwnerBean(1,"Cody","Conder","male");
		
		Socket toServer = new Socket("127.0.0.1", 9889);
		
		JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
		
		outToServer.writeObject(anOwner);
		
		System.out.println(inFromServer.readObject());
		
		toServer.close();

	}

}
