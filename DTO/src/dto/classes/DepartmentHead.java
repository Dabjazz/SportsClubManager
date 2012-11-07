package dto.classes;

import java.io.Serializable;
import java.util.*;
import dto.contract.IDepartmentHead;

public class DepartmentHead
        extends Role
        implements Serializable, IDepartmentHead
{
    private List<Integer> departmentList = new LinkedList<>();

     DepartmentHead(int id)
    {
        super(id);
    }
    private static HashMap<domain.contract.IDepartmentHead, DepartmentHead> departmentHeads = new HashMap<>();

    public static DepartmentHead copy(domain.contract.IDepartmentHead departmentHead)
    {
        DepartmentHead a;

        if (departmentHeads.containsKey(departmentHead))
        {
            a = departmentHeads.get(departmentHead);
        }
        else
        {
            a = new DepartmentHead(departmentHead.getId());

            List<Integer> l = new LinkedList<>();

            for (domain.contract.IDepartment t : departmentHead.getDepartmentList())
            {
                l.add(t.getId());
            }

            a.setDepartmentList(l);

            departmentHeads.put(departmentHead, a);
        }

        return a;
    }

    DepartmentHead()
    {
        super();
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
