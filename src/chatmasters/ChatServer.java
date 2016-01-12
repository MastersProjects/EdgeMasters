package chatmasters;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.util.*;

public class ChatServer extends UnicastRemoteObject implements ChatInterface {

    private static final long serialVersionUID = 1L;
    private List<Message> messageList = new ArrayList<Message>();
    private List<User> userList = new ArrayList<User>();

    private ChatServer() throws RemoteException {
        super(0);
    }

    @Override
    public List<User> returnClients() throws RemoteException {
        return this.userList;
    }

    @Override
    public List<Message> returnMessages() throws RemoteException {
        return this.messageList;
    }

    @Override
    public void rmvPrintedMsgs() throws RemoteException {
        try {
            List<Message> msgarray = this.returnMessages();
            Thread.sleep(1000);
            msgarray.clear();
            this.messageList = msgarray;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(Message msg) throws RemoteException {
        this.messageList.add(msg);
        System.out.println(msg.toString());
    }

    @Override
    public void setClient(User client) throws RemoteException {
        this.userList.add(client);
        System.out.println(client.toString());
    }

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("RMI server started");
            try { // special exception handler for registry creation
                LocateRegistry.createRegistry(1099);
                System.out.println("java RMI registry created.");
            } catch (RemoteException e) {
                // do nothing, error means registry already exists
                System.out.println("java RMI registry already exists.");
            }

            ChatServer server = new ChatServer();
            Naming.rebind("//localhost/RmiChat", server);
            System.out.println(Calendar.getInstance().getTime() + "[System] Chat Remote Object is ready:");
        } catch (Exception e) {
            System.out.println("[System] Server failed: " + e);
        }
    }
}
