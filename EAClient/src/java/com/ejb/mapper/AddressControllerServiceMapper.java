/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.IAddressDto;
import contract.dto.ICountryDto;
import contract.ejb.business.IAddressRemote;
import contract.useCaseController.IAddressController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**

 @author Thomas
 */
public class AddressControllerServiceMapper
        implements IAddressController
{
    private IAddressRemote service;

//    public AddressControllerServiceMapper(IAddressRemote service)
//    {
//        this.service = service;
//    }

    public AddressControllerServiceMapper()
    {
        this.service = lookupAddressBeanRemote();
    }
    
    @Override
    public IAddressDto getById(Integer id)
    {
        return service.getById(id);
    }

    @Override
    public ICountryDto getCountryByName(String text)
    {
        return service.getCountryByName(text);
    }

    @Override
    public ICountryDto getCountryById(int country)
    {
        return service.getCountryById(country);
    }

    private IAddressRemote lookupAddressBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (IAddressRemote) c.lookup("java:comp/env/AddressBean");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
