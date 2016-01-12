package chatmasters;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {

    private static final long serialVersionUID = 8934670954363029150L;

    private String name;
    private boolean online;
    private Timestamp onlineTime;

    public User(String name, Boolean online, Timestamp time) {
        this.setOnlineTime(time);
        this.setName(name);
        this.setOnline(online);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", online=" + online +
                '}';
    }

    public Timestamp getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Timestamp onlineTime) {
        this.onlineTime = onlineTime;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
