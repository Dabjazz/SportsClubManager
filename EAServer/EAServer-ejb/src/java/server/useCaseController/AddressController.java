/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.IAddressDto;
import contract.dto.ICountryDto;
import contract.dto.mapper.IdNotFoundException;
import contract.useCaseController.IAddressController;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.dto.mapper.DtoFactory;

/**

 @author Thomas
 */
public class AddressController
        implements IAddressController
{
    private static IAddressController INSTANCE;

    public static IAddressController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new AddressController();
        }
        return INSTANCE;
    }
    private DtoFactory dtoFactory = new DtoFactory();

    @Override
    public ICountryDto getCountryById(int country)
    {
        try
        {
            return dtoFactory.getCountryMapper().getById(country);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public IAddressDto getById(Integer id)
    {
        try
        {
            return dtoFactory.getAddressMapper().getById(id);
        }
        catch(IdNotFoundException ex)
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
        catch(IdNotFoundException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
