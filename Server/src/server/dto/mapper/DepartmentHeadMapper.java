/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.IDepartmentHeadDto;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import contract.dto.classes.DepartmentHeadDto;

/**
 *
 * @author Thomas
 */
public class DepartmentHeadMapper
        implements IMapper<IDepartmentHeadDto>
{
    private static DepartmentHeadMapper controller;

    DepartmentHeadMapper()
    {
    }

    public static IMapper<IDepartmentHeadDto> getInstance()
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
            List<IDepartmentHeadDto> result = new LinkedList<>();

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
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(DepartmentHeadMapper.class.getName()).log(Level.SEVERE, null, ex);
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
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(DepartmentHeadMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.DepartmentHead createDomain(IDepartmentHeadDto value)
            throws IdNotFoundException
    {
        server.domain.classes.DepartmentHead departmentHead = new server.domain.classes.DepartmentHead(value.getId());

        List< contract.domain.IDepartment> departmentList = new LinkedList<>();
        List<contract.domain.IPermission> permissionList = new LinkedList<>();

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
}
