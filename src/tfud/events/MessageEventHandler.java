/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfud.events;

import tfud.events.MessageListener;

/**
 *
 * @author brian
 */
public interface MessageEventHandler {

    void addMessageListener(MessageListener m);
    
}
