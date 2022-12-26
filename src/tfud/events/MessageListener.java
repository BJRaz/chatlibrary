package tfud.events;

/**
 * @author BJR
 */
public interface MessageListener {

    public void messageReceived(Object source, Object data);			// standard message
    
    public void statusMessageReceived(Object source, Object data);		// status  message

    public void privateMessageReceived(Object source, Object data);		// private message

    public void loginMessageReceived(Object source, Object data);		// login message (user logged in)

    public void serverMessageReceived(Object source, Object data);		// server related message (kick, status, whatever)

}
