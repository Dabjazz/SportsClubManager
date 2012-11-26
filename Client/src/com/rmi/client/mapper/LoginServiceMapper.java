/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.mapper;

import contract.dto.IMemberDto;
import contract.dto.IUserDataDto;
import contract.rmi.services.ILoginRmiService;
import contract.useCaseController.ILogin;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginServiceMapper
        implements RmiServiceToServiceMapper<ILoginRmiService, ILogin> {

    @Override
    public ILogin getService(ILoginRmiService rmiService) {
        Login n = new Login();
        n.setService(rmiService);
        return n;
    }

    private static class Login
            implements ILogin {

        private ILoginRmiService service;

        public void setService(ILoginRmiService service) {
            this.service = service;
        }

        @Override
        public IMemberDto getMemberByUserData(IUserDataDto userData) {
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
    }
}
