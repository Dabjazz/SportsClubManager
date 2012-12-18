/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.IMemberDto;
import contract.ejb.business.IPermissionControllerRemote;
import contract.useCaseController.IPermissionController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Thomas
 */
public class PermissionControllerServiceMapper
        implements IPermissionController
{

    private IPermissionControllerRemote service;

//    public PermissionControllerServiceMapper(IPermissionControllerRemote service) {
//        this.service = service;
//    }
    public PermissionControllerServiceMapper()
    {
        this.service = lookupPermissionControllerBeanRemote();
    }

    @Override
    public IMemberDto getMember()
    {

        return service.getMember();

    }

    @Override
    public void setMember(IMemberDto member)
    {

        service.setMember(member);

    }

    @Override
    public boolean hasPermission(String permissionName)
    {

        return service.hasPermission(permissionName);

    }

    private IPermissionControllerRemote lookupPermissionControllerBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (IPermissionControllerRemote) c.lookup("java:comp/env/PermissionControllerBean");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
