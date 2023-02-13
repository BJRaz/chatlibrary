package tfud.events;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BJR
 */
public class ConnectionHandler {

    private final List<ConnectionListener> connectionListeners;

    /**
     * Method ConnectionHandler
     *
     *
     */
    public ConnectionHandler() {
        connectionListeners = new ArrayList<>();
    }

    public void addConnectionListener(ConnectionListener c) {
        connectionListeners.add(c);
    }

    public void fireConnectionUpdated(ConnectionEvent event) {
        connectionListeners.forEach(cl -> {
            cl.connectionUpdated(event);
        });
    }
}
