package tfud.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author brian
 */
public interface ILogger {

    /**
     *
     * @param message
     */
    void log(String message);
    
    void log(Object message);
}
