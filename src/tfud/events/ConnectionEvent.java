package tfud.events;

import java.util.EventObject;


/**
 * @author BJR
 */
public class ConnectionEvent extends EventObject {

    private final String command;

    /**
     * Method ConnectionEvent
     *
     *
     * @param source
     * @param command
     */
    public ConnectionEvent(Object source, String command) {
        super(source);
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}

