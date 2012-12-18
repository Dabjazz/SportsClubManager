/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.CouldNotDeleteException;
import contract.domain.CouldNotFetchException;
import contract.domain.CouldNotSaveException;
import contract.dto.IAddressDto;
import contract.dto.classes.AddressDto;
import contract.dto.mapper.IMapper;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.domain.DomainFacade;

/**
 * @author Thomas
 */
public class AddressMapper
        implements IMapper<IAddressDto>
{
    private static AddressMapper controller;

    public static IMapper<IAddressDto> getInstance()
    {
        if (controller == null)
        {
            controller = new AddressMapper();
        }

        return controller;
    }

    public contract.domain.IAddress getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            return DomainFacade.getInstance().getByID(server.domain.classes.Address.class, id);
        }
        catch (CouldNotFetchException ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public IAddressDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IAddress a = DomainFacade.getInstance().getByID(contract.domain.IAddress.class, id);
            return AddressDto.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IAddressDto> getAll() throws NotFoundException
    {
        try
        {
            List<IAddressDto> result = new LinkedList<IAddressDto>();

            for (contract.domain.IAddress a : DomainFacade.getInstance().getAll(contract.domain.IAddress.class))
            {
                result.add(AddressDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IAddressDto value)
    {
        try
        {
            server.domain.classes.Address address = createDomain(value);

            return DomainFacade.getInstance().set(address);
        } catch (CouldNotSaveException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IAddressDto value)
    {
        try
        {
            server.domain.classes.Address address = createDomain(value);

            DomainFacade.getInstance().delete(address);
        } catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Address createDomain(IAddressDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Address address = new server.domain.classes.Address(value.getId());

        address.setCountry(new CountryMapper().getDomainById(value.getCountry()));
        address.setPostalCode(value.getPostalCode());
        address.setStreet(value.getStreet());
        address.setStreetNumber(value.getStreetNumber());
        address.setVillage(value.getVillage());

        return address;
    }

    @Override
    public IAddressDto getNew()
    {
        return new AddressDto();
    }
}
