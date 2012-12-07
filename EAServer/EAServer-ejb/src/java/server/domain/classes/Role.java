package server.domain.classes;

import contract.domain.IRole;
import contract.domain.IPermission;
import contract.domain.IMember;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "MemberRole")
@Inheritance(strategy = InheritanceType.JOINED)
public class Role
        implements Serializable, IRole
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    protected Integer id;
    @Column(name = "Name")
    protected String name;
    @Column(name = "Description")
    protected String description;
    @JoinTable(name = "Role_has_Permission", joinColumns =
    {
        @JoinColumn(name = "Role_idRole", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Permission_idPermission", referencedColumnName = "id")
    })
    @ManyToMany(fetch = FetchType.LAZY)
    protected List<Permission> permissionList;
    @JoinColumn(name="MemberId",referencedColumnName="id")
    @ManyToOne
    protected Member member;

    public Role()
    {
    }

    public Role(Integer id)
    {
        this.id = id;
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
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public List<IPermission> getPermissionList()
    {
        List<IPermission> result = new LinkedList<>();

        for (Permission d : permissionList)
        {
            result.add((IPermission) d);
        }

        return result;
    }

    @Override
    public void setPermissionList(List<IPermission> permisssionList)
    {
        List<Permission> result = new LinkedList<>();

        for (IPermission d : permisssionList)
        {
            result.add((Permission) d);
        }

        this.permissionList = result;
    }

    @Override
    public IMember getMember()
    {
        return this.member;
    }

    @Override
    public void setMember(IMember member)
    {
        this.member = (Member) member;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role))
        {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String getDesciption()
    {
        return this.description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }
}
