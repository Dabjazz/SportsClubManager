package domain.classes;

import domain.contract.*;
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
    @OneToMany(mappedBy = "departmentHead")
    private List<Department> departmentList;
    private static final long serialVersionUID = 1L;

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
