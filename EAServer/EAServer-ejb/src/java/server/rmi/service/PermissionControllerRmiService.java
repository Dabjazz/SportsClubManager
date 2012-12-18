/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.service;

import contract.dto.*;
import contract.rmi.services.*;
import java.rmi.*;
import java.rmi.server.*;
import server.useCaseController.*;

/**

 @author Thomas
 */
public class PermissionControllerRmiService
        extends UnicastRemoteObject
        implements IPermissionControllerService
{
    public PermissionControllerRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public IMemberDto getMember()
            throws RemoteException
    {
        return PermissionController.getInstance().getMember();
    }

    @Override
    public void setMember(IMemberDto member)
            throws RemoteException
    {
        PermissionController.getInstance().setMember(member);
    }

    @Override
    public boolean hasPermission(String permissionName)
            throws RemoteException
    {
        return PermissionController.getInstance().hasPermission(permissionName);
    }
}
