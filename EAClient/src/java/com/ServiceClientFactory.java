package com;

import com.contract.IUseCaseControllerFactory;
import com.ejb.EJBUseCaseControllerFactory;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ServiceClientFactory
{
    public static IUseCaseControllerFactory getEJBServiceClient(String host, int port)
            throws CommunicationProblemException
    {
        return new EJBUseCaseControllerFactory();
    }
}
