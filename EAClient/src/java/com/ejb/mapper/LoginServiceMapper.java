/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.IMemberDto;
import contract.dto.IUserDataDto;
import contract.ejb.business.ILoginRemote;
import contract.useCaseController.ILogin;
import contract.useCaseController.MemberNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginServiceMapper
        implements ILogin
{
    private ILoginRemote service;

//    public LoginServiceMapper(ILoginRemote service)
//    {
//        this.service = service;
//    }

    public LoginServiceMapper()
    {
        this.service = lookupLoginBeanRemote();
    }
    
    @Override
    public IMemberDto getMemberByUserData(IUserDataDto userData)
    {
       return service.getMemberByUserData(userData);
    }

    private ILoginRemote lookupLoginBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (ILoginRemote) c.lookup("java:comp/env/LoginBean");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public IMemberDto getMemberByUsername(String username) throws MemberNotFoundException
    {
        return service.getMemberByUsername(username);
    }

}
