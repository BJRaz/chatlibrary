package tfud.events;

import java.util.*;
import tfud.communication.DataPackage;

/**
 * @author BJR
 */
public class MessageHandler {

    private final List<MessageListener> messageListeners;

    public MessageHandler() {
        messageListeners = new ArrayList<>();
    }

    public void addMessageListener(MessageListener m) {
        messageListeners.add(m);
    }

    public void handleMessage(DataPackage p) {
        EventType eventType = p.getEventType();
        switch (eventType) {

            case ONLINE:
            case OFFLINE:
                fireStatusReceived(p);
                break;
            case MESSAGE:
            case PRIVATEMESSAGE:
            case AWAY:
            case USERLIST:
            case CHANGEROOM:
                fireMessageReceived(p);
                break;
            case LOGIN:
                fireLoginMessageReceived(p);
                break;
            case SERVERMESSAGE:
                fireServerMessageReceived(p);
                break;
            case DUMMY:
                fireMessageReceived(p);
                break;
            default:
                fireMessageReceived(p);
                break;
        }

    }

    public void fireMessageReceived(DataPackage dp) {
        messageListeners.forEach(ml -> {
            ml.messageReceived(this, dp);
        });
    }

    public void firePrivateMessageReceived(DataPackage dp) {
        messageListeners.forEach(ml -> {
            ml.privateMessageReceived(this, dp);
        });
    }

    public void fireStatusReceived(DataPackage dp) {
        messageListeners.forEach(ml -> {
            ml.statusMessageReceived(this, dp);
        });
    }

    /* NOTICE THIS MUST BE GIVEN MORE THOUGHTS */
    public void fireLoginMessageReceived(DataPackage dp) {
        messageListeners.forEach(ml -> {
            ml.loginMessageReceived(this, dp);
        });
    }

    public void fireServerMessageReceived(DataPackage dp) {
        messageListeners.forEach(ml -> {
            ml.serverMessageReceived(this, dp);
        });
    }
}
