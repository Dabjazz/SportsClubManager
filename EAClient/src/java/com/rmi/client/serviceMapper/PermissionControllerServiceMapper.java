/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.IMemberDto;
import contract.rmi.services.IPermissionControllerService;
import contract.useCaseController.IPermissionController;
import java.rmi.RemoteException;
import java.util.logging.*;

/**

 @author Thomas
 */
public class PermissionControllerServiceMapper
        implements IPermissionController
{
    private IPermissionControllerService service;

    public PermissionControllerServiceMapper(IPermissionControllerService service)
    {
        this.service = service;
    }

    @Override
    public IMemberDto getMember()
    {
        try
        {
            return service.getMember();
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(PermissionControllerServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void setMember(IMemberDto member)
    {
        try
        {
            service.setMember(member);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(PermissionControllerServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean hasPermission(String permissionName)
    {
        try
        {
            return service.hasPermission(permissionName);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(PermissionControllerServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
