package com;

import com.contract.IUseCaseControllerFactory;
import com.CommunicationProblemException;
import com.ejb.EJBUseCaseControllerFactory;
import com.rmi.client.RmiUseCaseControllerFactory;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ServiceClientFactory
{
    public static IUseCaseControllerFactory getRmiServiceClient(String host, int port)
            throws CommunicationProblemException
    {
        return new RmiUseCaseControllerFactory(host, port);
    }
    
    public static IUseCaseControllerFactory getEJBServiceClient(String host, int port)
            throws CommunicationProblemException
    {
        return new EJBUseCaseControllerFactory();
    }
}
