package rmi;

import java.io.Serializable;
import java.security.Timestamp;

public class Message implements Serializable {

    private static final long serialVersionUID = -1724444053149327065L;

    private User sender;
    private String msg;
    private Timestamp time;

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender +
                ", msg='" + msg + '\'' +
                '}';
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
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
