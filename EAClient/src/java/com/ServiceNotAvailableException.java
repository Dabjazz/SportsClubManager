/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class ServiceNotAvailableException extends Exception
{

    public ServiceNotAvailableException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ServiceNotAvailableException(Throwable cause)
    {
        super(cause);
    }
    
    
    
    
}
