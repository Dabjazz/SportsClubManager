/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.classes;

import contract.dto.IRoleDto;
import java.util.*;

/**

 @author Thomas
 */
public class RoleDto
        implements IRoleDto
{
    private Integer id;
    private String name;
    private String description;
    private List<Integer> permissionList;
    private Integer member;

    public RoleDto()
    {
    }

    public static <T extends RoleDto> T copy(contract.domain.IRole domainRole, T role)
    {
        role.setId(domainRole.getId());
        role.setName(domainRole.getName());
        role.setDescription(domainRole.getDesciption());

        List<Integer> perList = new LinkedList<>();
        for (contract.domain.IPermission permission : domainRole.getPermissionList())
        {
            perList.add(permission.getId());
        }
        role.setPermisssionList(perList);

        role.setMember(domainRole.getMember().getId());

        return role;
    }

    @Override
    public List<Integer> getPermisssionList()
    {
        return permissionList;
    }

    @Override
    public Integer getMember()
    {
        return member;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public void setMember(Integer member)
    {
        this.member = member;
    }

    @Override
    public void setPermisssionList(List<Integer> permisssionList)
    {
        this.permissionList = permisssionList;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
