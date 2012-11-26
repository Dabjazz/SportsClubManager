package contract.dto.classes;

import contract.dto.IDepartmentHeadDto;
import java.io.Serializable;
import java.util.*;

public class DepartmentHeadDto
        extends RoleDto
        implements Serializable, IDepartmentHeadDto
{
    private List<Integer> departmentList = new LinkedList<>();
    private static HashMap<contract.domain.IDepartmentHead, DepartmentHeadDto> departmentHeads = new HashMap<>();

    public static DepartmentHeadDto copy(contract.domain.IDepartmentHead departmentHead)
    {
        DepartmentHeadDto a;

        if (departmentHeads.containsKey(departmentHead))
        {
            a = departmentHeads.get(departmentHead);
        }
        else
        {
            a = copy(departmentHead, new DepartmentHeadDto());

            List<Integer> l = new LinkedList<>();

            for (contract.domain.IDepartment t : departmentHead.getDepartmentList())
            {
                l.add(t.getId());
            }

            a.setDepartmentList(l);

            departmentHeads.put(departmentHead, a);
        }

        return a;
    }

    @Override
    public List<Integer> getDepartmentList()
    {
        return departmentList;
    }

    @Override
    public void setDepartmentList(List<Integer> departmentList)
    {
        this.departmentList = departmentList;
    }
}
