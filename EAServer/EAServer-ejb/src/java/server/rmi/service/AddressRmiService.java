/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.service;

import contract.dto.*;
import contract.rmi.services.IAddressRmiService;
import java.rmi.*;
import java.rmi.server.*;
import server.useCaseController.*;

/**

 @author Thomas
 */
public class AddressRmiService
        extends UnicastRemoteObject
        implements IAddressRmiService
{
    public AddressRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public IAddressDto getById(Integer id)
    {
        return AddressController.getInstance().getById(id);
    }

    @Override
    public ICountryDto getCountryByName(String text)
    {
        return AddressController.getInstance().getCountryByName(text);
    }

    @Override
    public ICountryDto getCountryById(int country)
    {
        return AddressController.getInstance().getCountryById(country);
    }
}
