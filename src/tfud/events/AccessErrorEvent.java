/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfud.events;

/**
 *
 * @author brian
 */
public class AccessErrorEvent extends ConnectionEvent {
    public AccessErrorEvent(Object source, String command) {
        super(source, command);
    }
}

