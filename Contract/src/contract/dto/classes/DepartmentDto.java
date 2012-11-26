package contract.dto.classes;

import java.io.Serializable;
import java.util.*;
import contract.dto.IDepartmentDto;

public class DepartmentDto
        implements Serializable, IDepartmentDto
{
    private int id;
    private Integer departmentHead;
    private String name;
    private String description;
    private List<Integer> clubTeamList = new LinkedList<>();
    private List<Integer> typeOfSportList = new LinkedList<>();

   public DepartmentDto()
    {
    }

    DepartmentDto(int id)
    {
        this.id = id;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
    private static HashMap<contract.domain.IDepartment, DepartmentDto> departments = new HashMap<>();

    public static DepartmentDto copy(contract.domain.IDepartment department)
    {
        DepartmentDto a;

        if (departments.containsKey(department))
        {
            a = departments.get(department);
        }
        else
        {
            a = new DepartmentDto();

            a.setName(department.getName());
            a.setDescription(department.getDescription());

            for (contract.domain.IClubTeam c : department.getClubTeamList())
            {
                a.clubTeamList.add(c.getId());
            }

            for (contract.domain.ITypeOfSport d : department.getTypeOfSportList())
            {
                a.typeOfSportList.add(d.getId());
            }

            departments.put(department, a);
        }
        return a;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public List<Integer> getClubTeamList()
    {
        return clubTeamList;
    }

    @Override
    public void setClubTeamList(List<Integer> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
    }

    @Override
    public List<Integer> getTypeOfSportList()
    {
        return typeOfSportList;
    }

    @Override
    public void setTypeOfSportList(List<Integer> typeOfSportList)
    {
        this.typeOfSportList = typeOfSportList;
    }

    @Override
    public Integer getDepartmentHead()
    {
        return departmentHead;
    }

    @Override
    public void setDepartmentHead(Integer departmentHead)
    {
        this.departmentHead = departmentHead;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
