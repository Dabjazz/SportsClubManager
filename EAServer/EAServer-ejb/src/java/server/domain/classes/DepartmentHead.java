package server.domain.classes;

import contract.domain.IDepartment;
import contract.domain.IDepartmentHead;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "DepartmentHead")
@PrimaryKeyJoinColumn(name="id",referencedColumnName="id")
public class DepartmentHead
        extends Role
        implements Serializable, IDepartmentHead
{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentHead")
    private List<Department> departmentList;

    public DepartmentHead()
    {
    }

    public DepartmentHead(int id)
    {
        super(id);
    }

    @XmlTransient
    @Override
    public List<IDepartment> getDepartmentList()
    {
        List<IDepartment> result = new LinkedList<>();

        for (Department d : departmentList)
        {
            result.add((IDepartment)d);
        }

        return result;
    }

    @Override
    public void setDepartmentList(List<IDepartment> departmentList)
    {
        List<Department> result = new LinkedList<>();

        for (IDepartment d : departmentList)
        {
            result.add((Department) d);
        }

        this.departmentList = result;
    }
}
