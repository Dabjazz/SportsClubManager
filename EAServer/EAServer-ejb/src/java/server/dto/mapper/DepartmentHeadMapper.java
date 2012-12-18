/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.*;
import contract.dto.classes.DepartmentHeadDto;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import server.domain.classes.Role;

/**
 *
 * @author Thomas
 */
public class DepartmentHeadMapper
        implements IDepartmentHeadMapper
{
    private static DepartmentHeadMapper controller;

    DepartmentHeadMapper( )
    {
    }

    public static IDepartmentHeadMapper getInstance( )
    {
        if (controller == null)
        {
            controller = new DepartmentHeadMapper();
        }

        return controller;
    }

    public contract.domain.IDepartmentHead getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IDepartmentHead a = DomainFacade.getInstance().getByID(contract.domain.IDepartmentHead.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IDepartmentHeadDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IDepartmentHead a = DomainFacade.getInstance().getByID(contract.domain.IDepartmentHead.class,id);
            return DepartmentHeadDto.copy(a);
        }
        catch (CouldNotFetchException ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IDepartmentHeadDto> getAll() throws NotFoundException
    {
        try
        {
            List<IDepartmentHeadDto> result = new LinkedList<IDepartmentHeadDto>();

            for (contract.domain.IDepartmentHead a : DomainFacade.getInstance().getAll(contract.domain.IDepartmentHead.class))
            {
                result.add(DepartmentHeadDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IDepartmentHeadDto value)
    {
        try
        {
            server.domain.classes.DepartmentHead departmentHead = createDomain(value);

            return DomainFacade.getInstance().set(departmentHead);
        } catch (CouldNotSaveException ex)
        {
            Logger.getLogger(DepartmentHeadMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (IdNotFoundException ex)
        {
            Logger.getLogger(DepartmentMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IDepartmentHeadDto value)
    {
        try
        {
            server.domain.classes.DepartmentHead departmentHead = createDomain(value);

            DomainFacade.getInstance().delete(departmentHead);
        } catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(DepartmentHeadMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (IdNotFoundException ex)
        {
            Logger.getLogger(DepartmentMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.DepartmentHead createDomain(IDepartmentHeadDto value)
            throws IdNotFoundException
    {
        server.domain.classes.DepartmentHead departmentHead = new server.domain.classes.DepartmentHead(value.getId());

        List< contract.domain.IDepartment> departmentList = new LinkedList<contract.domain.IDepartment>();
        List<contract.domain.IPermission> permissionList = new LinkedList<contract.domain.IPermission>();

        for (int i : value.getDepartmentList())
        {
            departmentList.add(new DepartmentMapper().getDomainById(i));
        }

        for (int i : value.getPermisssionList())
        {
            permissionList.add(new PermissionMapper().getDomainById(i));
        }

        departmentHead.setDepartmentList(departmentList);
        departmentHead.setPermissionList(permissionList);

        return departmentHead;
    }

    @Override
    public IDepartmentHeadDto getNew()
    {
        return new DepartmentHeadDto();
    }

    @Override
    public IDepartmentHeadDto getMemberById(Integer id) throws IdNotFoundException {
        IDepartmentHeadDto dto = null;
        try
        {
            List<Role> all = DomainFacade.getInstance().getAll(server.domain.classes.Role.class);
            for(Role r : all)
            {
                              if(r.getMember().getId().equals( id))
  {
                    if(r instanceof server.domain.classes.DepartmentHead)
                    {
                        dto=DepartmentHeadDto.copy((server.domain.classes.DepartmentHead)r);
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