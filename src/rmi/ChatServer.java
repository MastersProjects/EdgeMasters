package rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.*;

import rmi.ChatServer;
import rmi.Message;
import rmi.User;

public class ChatServer extends UnicastRemoteObject implements ChatInterface {

	private static final long serialVersionUID = 1L;

	private List<Message> messageList = new ArrayList<Message>();
	private List<User> userList = new ArrayList<User>();

	protected ChatServer() throws RemoteException {
		super(0);
	}

	public static void main(String[] arg) {
		createServer(1257);
	}

	private static void createServer(int port) {
		Registry reg = null;
		try {
			System.out.println("RMI server started");
			try {
				reg = LocateRegistry.createRegistry(port);
				System.out.println("java RMI registry created at port " + port);
				
			} catch (RemoteException e) {
				System.out.println("RMI registry failed.");
				e.printStackTrace();
			}
			ChatServer server = new ChatServer();
			reg.rebind("RmiChat", server);
			System.out.println("[System] Server ready");
			
		} catch (Exception e) {
			System.out.println("[System] Server failed: " + e);
			e.printStackTrace();
		}
	}

	@Override
	public void send(Message msg) throws RemoteException {
		messageList.add(msg);
		System.out.println(msg);
	}

	@Override
	public List<Message> returnMessages() throws RemoteException {
		return this.messageList;
	}

	@Override
	public List<User> returnClients() throws RemoteException {
		return this.userList;
	}

	@Override
	public void setClient(User client) throws RemoteException {
		this.userList.add(client);
		System.out.println(client.getName());
	}

}
