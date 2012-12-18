/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.IMemberDto;
import contract.dto.IUserDataDto;
import contract.ejb.business.ILoginRemote;
import contract.useCaseController.ILogin;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginServiceMapper
        implements ILogin
{
    private ILoginRemote service;

    public LoginServiceMapper(ILoginRemote service)
    {
        this.service = service;
    }

    @Override
    public IMemberDto getMemberByUserData(IUserDataDto userData)
    {
       return service.getMemberByUserData(userData);
    }
}
