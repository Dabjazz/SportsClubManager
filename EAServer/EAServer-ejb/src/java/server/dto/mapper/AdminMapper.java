/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.CouldNotDeleteException;
import contract.domain.CouldNotFetchException;
import contract.domain.CouldNotSaveException;
import contract.dto.IAdminDto;
import contract.dto.classes.AdminDto;
import contract.dto.mapper.IAdminMapper;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.domain.DomainFacade;
import server.domain.classes.Role;

/**
 @author Thomas
 */
public class AdminMapper
        implements IAdminMapper
{
    private static AdminMapper controller;

    AdminMapper()
    {
    }

    public static IAdminMapper getInstance()
    {
        if (controller == null)
        {
            controller = new AdminMapper();
        }

        return controller;
    }

    public contract.domain.IAdmin getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            return DomainFacade.getInstance().getByID(contract.domain.IAdmin.class, id);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public IAdminDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IAdmin a = DomainFacade.getInstance().getByID(contract.domain.IAdmin.class, id);
            return AdminDto.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IAdminDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<IAdminDto> result = new LinkedList<IAdminDto>();

            for (contract.domain.IAdmin a : DomainFacade.getInstance().getAll(contract.domain.IAdmin.class))
            {
                result.add(AdminDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IAdminDto value)
    {
        try
        {
            server.domain.classes.Admin address = createDomain(value);

            return DomainFacade.getInstance().set(address);
        } catch (CouldNotSaveException ex)
        {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IAdminDto value)
    {
        try
        {
            server.domain.classes.Admin address = createDomain(value);

            DomainFacade.getInstance().delete(address);
        } catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException  ex)
        {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Admin createDomain(IAdminDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Admin admin = new server.domain.classes.Admin(value.getId());

        admin.setName(value.getName());
        admin.setDescription(value.getDescription());

        return admin;
    }

    @Override
    public IAdminDto getNew()
    {
        return new AdminDto();
    }

    @Override
    public IAdminDto getMemberById(Integer id) throws IdNotFoundException {
        
        IAdminDto dto = null;
        try
        {
            List<Role> all = DomainFacade.getInstance().getAll(server.domain.classes.Role.class);
            for(Role r : all)
            {
                                if(r.getMember().getId().equals( id))
  {
                    if(r instanceof server.domain.classes.Admin)
                    {
                        dto=AdminDto.copy((server.domain.classes.Admin)r);
                    }
                }
            }

            return dto;
        }
        catch (CouldNotFetchException ex)
        {
            throw new IdNotFoundException();
        }
    }
}
