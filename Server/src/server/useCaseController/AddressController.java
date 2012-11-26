/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.ICountryDto;
import contract.dto.mapper.IdNotFoundException;
import contract.useCaseController.IAddressController;
import java.rmi.RemoteException;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**

 @author Thomas
 */
public class AddressController
        implements IAddressController
{
    private DtoFactory dtoFactory = new DtoFactory();

    @Override
    public ICountryDto getCountryById(int country)
    {
        try
        {
            return dtoFactory.getCountryMapper().getById(country);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ICountryDto getCountryByName(String name)
    {
        try
        {
            return dtoFactory.getCountryMapper().getByName(name);
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
