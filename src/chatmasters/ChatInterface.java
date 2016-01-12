package chatmasters;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


public interface ChatInterface extends Remote {

    void send(Message msg) throws RemoteException;

    List<Message> returnMessages() throws RemoteException;

    void rmvPrintedMsgs() throws RemoteException;

    List<User> returnClients() throws RemoteException;

    void setClient(User client) throws RemoteException;
}