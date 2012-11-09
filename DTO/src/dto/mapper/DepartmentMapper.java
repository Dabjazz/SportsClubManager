/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import java.util.*;
import java.util.logging.*;
import domain.*;
import dto.classes.Department;
import dto.contract.IDepartment;
import dto.mapper.contract.*;

/**

 @author Thomas
 */
public class DepartmentMapper
        implements IMapper<IDepartment>
{
    private static DepartmentMapper controller;

     DepartmentMapper()
    {
    }

    public static IMapper<IDepartment> getInstance()
    {
        if (controller == null)
        {
            controller = new DepartmentMapper();
        }

        return controller;
    }

    public domain.contract.IDepartment getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IDepartment a : DomainFacade.getAll(domain.contract.IDepartment.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public IDepartment getById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IDepartment a : DomainFacade.getAll(domain.contract.IDepartment.class))
        {
            if (a.getId() == id)
            {
                return Department.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<IDepartment> getAll()
    {
        List<IDepartment> result = new LinkedList<>();

        for (domain.contract.IDepartment a : DomainFacade.getAll(domain.contract.IDepartment.class))
        {
            result.add(Department.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(IDepartment value)
    {
        try
        {
            domain.classes.Department department = createDomain(value);

            return DomainFacade.set(department);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(DepartmentMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IDepartment value)
    {
        try
        {
            domain.classes.Department department = createDomain(value);

            DomainFacade.delete(department);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(DepartmentMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Department createDomain(IDepartment value)
            throws IdNotFoundException
    {
        domain.classes.Department department = new domain.classes.Department(value.getId());

        department.setDepartmentHead(new DepartmentHeadMapper().getDomainById(value.getDepartmentHead()));
        department.setDescription(value.getDescription());
        department.setName(value.getName());

        List< domain.contract.IClubTeam> clubTeamList = new LinkedList<>();
        List< domain.contract.ITypeOfSport> departmenthasTypeOfSportList = new LinkedList<>();

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
}