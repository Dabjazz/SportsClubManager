/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.*;
import contract.rmi.services.IAddressRmiService;
import contract.useCaseController.IAddressController;
import java.rmi.RemoteException;
import java.util.logging.*;

/**

 @author Thomas
 */
public class AddressControllerServiceMapper
        implements IAddressController
{
    private IAddressRmiService service;

    public AddressControllerServiceMapper(IAddressRmiService service)
    {
        this.service = service;
    }

    @Override
    public IAddressDto getById(Integer id)
    {
        try
        {
            return service.getById(id);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddressControllerServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ICountryDto getCountryByName(String text)
    {
        try
        {
            return service.getCountryByName(text);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddressControllerServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ICountryDto getCountryById(int country)
    {
        try
        {
            return service.getCountryById(country);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddressControllerServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
