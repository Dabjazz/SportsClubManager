/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.IUserData;
import contract.dto.IMember;
import server.useCaseController.LoginController;
import contract.useCaseController.MemberNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import contract.rmi.services.ILoginRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginRmiService extends UnicastRemoteObject implements ILoginRmiService
{
    
    public LoginRmiService() throws RemoteException {
        super();
    }

    @Override
    public IMember getMemberByUserData(IUserData userData) throws RemoteException
    {
        try
        {
            return LoginController.getInstance().getMemberByUserData(userData );
        }
        catch (MemberNotFoundException ex)
        {
            throw new RemoteException(ex.getMessage());
        }
    }
    

   
    
}
