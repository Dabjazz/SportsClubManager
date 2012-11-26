package contract.dto.classes;

import java.io.Serializable;
import java.util.HashMap;
import contract.dto.IPermissionDto;

public class PermissionDto
        implements Serializable, IPermissionDto
{
    private int id;
    private String name;
    private String description;
    private static HashMap<contract.domain.IPermission, PermissionDto> competitions = new HashMap<>();

    public PermissionDto()
    {
    }

    PermissionDto(int id)
    {
        this.id = id;
    }

    public static PermissionDto copy(contract.domain.IPermission permission)
    {
        PermissionDto a;

        if (competitions.containsKey(permission))
        {
            a = competitions.get(permission);
        }
        else
        {
            a = new PermissionDto(permission.getId());

            a.setName(permission.getName());
            a.setDescription(permission.getDescription());

            competitions.put(permission, a);
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
    public Integer getId()
    {
        return id;
    }
}
