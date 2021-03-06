/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.*;
import contract.rmi.services.ILoginRmiService;
import contract.useCaseController.ILogin;
import contract.useCaseController.MemberNotFoundException;
import java.rmi.RemoteException;
import java.util.logging.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginServiceMapper
        implements ILogin
{
    private ILoginRmiService service;

    public LoginServiceMapper(ILoginRmiService service)
    {
        this.service = service;
    }

    @Override
    public IMemberDto getMemberByUserData(IUserDataDto userData)
    {
        try
        {
            return service.getMemberByUserData(userData);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(LoginServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

        // <editor-fold defaultstate="collapsed" desc="Hard-Coded Data -> Only 4 Testing"> 
//            IMemberDto member = new Member();
//
//            Address adr = new Address();
//            adr.setStreet("Radetzkystraße");
//            adr.setStreetNumber(6);
//            adr.setVillage("Hohenems");
//            adr.setPostalCode(6845);
//
//            Country c = new Country();
//            c.setName("Austria");
//
//            adr.setCountry(1);
//
//            Role role1 = new Role();
//            role1.setName("Admin");
//            Role role2 = new Role();
//            role2.setName("Player");
//            Role role3 = new Role();
//            role3.setName("Trainer");
//
//            List<Integer> roles = new LinkedList<>();
//            roles.add(role1.getId());
//            roles.add(role2.getId());
//            roles.add(role3.getId());
//
//            member.setId(1);
//            member.setPrename("Lucia");
//            member.setLastname("Amann");
//            member.setGender(true);
//            member.setEmailAddress("lucia.amann@students.fhv.at");
//            member.setUsername("lam1977");
//            member.setRoleList(roles);
//            member.setTelephonenumber("06604008041");
//            member.setAddress(123);
//            member.setNationality(1);
//
//            return member;
        // </editor-fold> 
    }

    @Override
    public IMemberDto getMemberByUsername(String username) throws MemberNotFoundException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
