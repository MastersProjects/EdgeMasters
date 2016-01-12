package chatmasters;

import java.io.Serializable;
import java.security.Timestamp;

public class Message implements Serializable {

    private static final long serialVersionUID = -1724444053149327065L;

    private User sender;
    private User receiver;
    private String msg;
    private Timestamp time;

    public Message(User sender, User receiver, Timestamp ts, String msg) {
        this.setSender(sender);
        this.setReceiver(receiver);
        this.setTime(ts);
        this.setMsg(msg);
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", msg='" + msg + '\'' +
                '}';
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
