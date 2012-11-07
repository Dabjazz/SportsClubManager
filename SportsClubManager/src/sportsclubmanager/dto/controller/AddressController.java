/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import java.util.logging.*;
import sportsclubmanager.controller.contract.*;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.Address;
import sportsclubmanager.dto.contract.IAddress;

/**

 @author Thomas
 */
public class AddressController
        implements IController<IAddress>
{
    private static AddressController controller;

    public AddressController()
    {
    }

    public static IController<IAddress> getInstance()
    {
        if (controller == null)
        {
            controller = new AddressController();
        }

        return controller;
    }

    public sportsclubmanager.domain.contract.IAddress getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IAddress a : DomainFacade.getAll(sportsclubmanager.domain.contract.IAddress.class))
        {
            if (a.getId() == id)
            {
                return a;
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public IAddress getById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IAddress a : DomainFacade.getAll(sportsclubmanager.domain.contract.IAddress.class))
        {
            if (a.getId() == id)
            {
                return Address.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<IAddress> getAll()
    {
        List<IAddress> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.IAddress a : DomainFacade.getAll(sportsclubmanager.domain.contract.IAddress.class))
        {
            result.add(Address.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(IAddress value)
    {
        try
        {
            sportsclubmanager.domain.classes.Address address = createDomain(value);

            return DomainFacade.set(address);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IAddress value)
    {
        try
        {
            sportsclubmanager.domain.classes.Address address = createDomain(value);

            DomainFacade.delete(address);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private sportsclubmanager.domain.classes.Address createDomain(IAddress value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.Address address = new sportsclubmanager.domain.classes.Address(value.getId());

        address.setCountry(new CountryController().getDomainById(value.getCountry()));
        address.setPostalCode(value.getPostalCode());
        address.setStreet(value.getStreet());
        address.setStreetNumber(value.getStreetNumber());
        address.setVillage(value.getVillage());

        return address;
    }
}
