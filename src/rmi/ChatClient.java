package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ServerCloneException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.swing.JOptionPane;

import rmi.ChatInterface;

public class ChatClient {
	private ChatInterface server;
	private static User user;
	
	private ChatClient(String name) {
		user = new User(name, false, null);
		ChatClient.setUser(user);
	}

	public static User getUser() {
		return ChatClient.user;
	}

	public static void setUser(User user) {
		ChatClient.user = user;
	}
	
	public static void main (String[] args){
		ChatClient client = new ChatClient(JOptionPane.showInputDialog(null, "Gib deinen Chatnamen ein!", "Willkommen!", JOptionPane.INFORMATION_MESSAGE));
		try {
			ChatInterface server = ChatClient.getServer();
			user.setOnline(true);
			user.setOnlineTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			server.setClient(user);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static ChatInterface getServer() throws MalformedURLException, RemoteException, NotBoundException {
		ChatInterface server = (ChatInterface) Naming.lookup("rmi://192.168.1.1/RmiChat");
		return server;
	}
}
