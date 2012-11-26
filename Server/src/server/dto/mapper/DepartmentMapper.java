/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.IDepartmentDto;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import contract.dto.classes.DepartmentDto;

/**
 @author Thomas
 */
public class DepartmentMapper
        implements IMapper<IDepartmentDto>
{
    private static DepartmentMapper controller;

    DepartmentMapper()
    {
    }

    public static IMapper<IDepartmentDto> getInstance()
    {
        if (controller == null)
        {
            controller = new DepartmentMapper();
        }

        return controller;
    }

    public contract.domain.IDepartment getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IDepartment a = DomainFacade.getInstance().getByID(contract.domain.IDepartment.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IDepartmentDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IDepartment a = DomainFacade.getInstance().getByID(contract.domain.IDepartment.class, id);
            return DepartmentDto.copy(a);
        }
        catch (CouldNotFetchException ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IDepartmentDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<IDepartmentDto> result = new LinkedList<>();

            for (contract.domain.IDepartment a : DomainFacade.getInstance().getAll(contract.domain.IDepartment.class))
            {
                result.add(DepartmentDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IDepartmentDto value)
    {
        try
        {
            server.domain.classes.Department department = createDomain(value);

            return DomainFacade.getInstance().set(department);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(DepartmentMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IDepartmentDto value)
    {
        try
        {
            server.domain.classes.Department department = createDomain(value);

            DomainFacade.getInstance().delete(department);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(DepartmentMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Department createDomain(IDepartmentDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Department department = new server.domain.classes.Department(value.getId());

        department.setDepartmentHead(new DepartmentHeadMapper().getDomainById(value.getDepartmentHead()));
        department.setDescription(value.getDescription());
        department.setName(value.getName());

        List< contract.domain.IClubTeam> clubTeamList = new LinkedList<>();
        List< contract.domain.ITypeOfSport> departmenthasTypeOfSportList = new LinkedList<>();

        for (int i : value.getClubTeamList())
        {
            clubTeamList.add(new ClubTeamMapper().getDomainById(i));
        }

        for (int i : value.getTypeOfSportList())
        {
            departmenthasTypeOfSportList.add(new TypeOfSportMapper().getDomainById(i));
        }

        department.setClubTeamList(clubTeamList);
        department.setTypeOfSportList(departmenthasTypeOfSportList);


        return department;
    }

    @Override
    public IDepartmentDto getNew()
    {
        return new DepartmentDto();
    }
}
