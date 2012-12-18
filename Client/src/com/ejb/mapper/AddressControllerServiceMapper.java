/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.*;
import contract.ejb.business.IAddressRemote;
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
    private IAddressRemote service;

    public AddressControllerServiceMapper(IAddressRemote service)
    {
        this.service = service;
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
}
