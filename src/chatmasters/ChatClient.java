package chatmasters;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class ChatClient implements Serializable {

	private static final long serialVersionUID = 6253087201489232951L;
	private ChatInterface server;
	private static String msgname = null;
	private Message msg;

	private static ChatClient instance = null;

	private ChatClient(String name) {
		this.setMsgname(name);
	}

	private ChatClient() {

	}

	 static synchronized ChatClient getInstance() {
		if (instance == null) {
			instance = new ChatClient();
		}
		return instance;
	}

	 void send(Message msg) throws RemoteException {
		try {
			getServer().send(msg);
		} catch (MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 static ChatInterface getServer() throws MalformedURLException, RemoteException, NotBoundException {
		ChatInterface server = (ChatInterface) Naming.lookup("rmi://localhost/RmiChat");
		return server;
	}

	 static void main(String[] args) throws Exception {
		try {

			ChatClient client = new ChatClient(JOptionPane.showInputDialog(null, "Gib deinen Chatnamen ein!", "Willkommen!", JOptionPane.INFORMATION_MESSAGE));
			ChatInterface server = ChatClient.getServer();
			server.setClient(new User(msgname, true, new Timestamp(Calendar.getInstance().getTimeInMillis())));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "[System] Server konnte nicht erreicht werden!", "Fehler", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	 static String getMsgname() {
		return msgname;
	}

	 void setMsgname(String msgname) {
		this.msgname = msgname;
	}
}