/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.ITypeOfSportDto;
import contract.dto.classes.TypeOfSportDto;
import contract.dto.mapper.ITypeOfSportMapper;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.domain.DomainFacade;

/**

 @author Thomas
 */
public class TypeOfSportMapper
        implements ITypeOfSportMapper
{
    private static TypeOfSportMapper controller;

    TypeOfSportMapper( )
    {
    }

    public static TypeOfSportMapper getInstance( )
    {
        if (controller == null)
        {
            controller = new TypeOfSportMapper();
        }

        return controller;
    }

    public contract.domain.ITypeOfSport getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ITypeOfSport a = DomainFacade.getInstance().getByID(contract.domain.ITypeOfSport.class, id);
            return a;
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public ITypeOfSportDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ITypeOfSport a = DomainFacade.getInstance().getByID(contract.domain.ITypeOfSport.class, id);
            return TypeOfSportDto.copy(a);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ITypeOfSportDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<ITypeOfSportDto> result = new LinkedList<ITypeOfSportDto>();
            DomainFacade instance = DomainFacade.getInstance();
            List<ITypeOfSport> all = instance.getAll(contract.domain.ITypeOfSport.class);

            for (contract.domain.ITypeOfSport a : all)
            {
                result.add(TypeOfSportDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(ITypeOfSportDto value)
    {
        try
        {
            server.domain.classes.TypeOfSport typeofsport = createDomain(value);

            return DomainFacade.getInstance().set(typeofsport);
        } catch (CouldNotSaveException ex)
        {
            Logger.getLogger(TypeOfSportMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ITypeOfSportDto value)
    {
        try
        {
            server.domain.classes.TypeOfSport typeofsport = createDomain(value);

            DomainFacade.getInstance().delete(typeofsport);
        } catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(TypeOfSportMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.TypeOfSport createDomain(ITypeOfSportDto value)
            throws IdNotFoundException
    {
        server.domain.classes.TypeOfSport typeofsport = new server.domain.classes.TypeOfSport(value.getId());

        typeofsport.setDescription(value.getDescription());
        typeofsport.setId(value.getId());
        typeofsport.setName(value.getName());
        LinkedList<contract.domain.IPlayer> list = new LinkedList<IPlayer>();
        for (Integer id : value.getPlayerList())
        {
            list.add(new PlayerMapper().getDomainById(id));
        }
        typeofsport.setPlayerList(list);

        return typeofsport;
    }

    @Override
    public ITypeOfSportDto getByName(String name)
    {
        return TypeOfSportDto.copy(DomainFacade.getInstance().getByName(server.domain.classes.TypeOfSport.class, name));
    }

    @Override
    public ITypeOfSportDto getNew()
    {
        return new TypeOfSportDto();
    }
}
