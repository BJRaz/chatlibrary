package tfud.events;

import java.util.*;
import tfud.communication.DataPackage;

/**
 * @author BJR
 */
public class MessageHandler {

    private Vector messageListeners;

    public MessageHandler() {
        messageListeners = new Vector();
    }

    public void addMessageListener(MessageListener m) {
        messageListeners.addElement(m);
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
        for (int i = 0; i < messageListeners.size(); i++) {
            ((MessageListener) messageListeners.elementAt(i)).messageReceived(this, dp);
        }
    }

    public void firePrivateMessageReceived(DataPackage dp) {
        for (int i = 0; i < messageListeners.size(); i++) {
            ((MessageListener) messageListeners.elementAt(i)).privateMessageReceived(this, dp);
        }
    }

    public void fireStatusReceived(DataPackage dp) {
        for (int i = 0; i < messageListeners.size(); i++) {
            ((MessageListener) messageListeners.elementAt(i)).statusMessageReceived(this, dp);
        }
    }

    /* NOTICE THIS MUST BE GIVEN MORE THOUGHTS */
    public void fireLoginMessageReceived(DataPackage dp) {
        for (int i = 0; i < messageListeners.size(); i++) {
            ((MessageListener) messageListeners.elementAt(i)).loginMessageReceived(this, dp);
        }
    }

    public void fireServerMessageReceived(DataPackage dp) {
        for (int i = 0; i < messageListeners.size(); i++) {
            ((MessageListener) messageListeners.elementAt(i)).serverMessageReceived(this, dp);
        }
    }
}
