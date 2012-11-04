package sportsclubmanager.dto.classes;

import java.io.Serializable;
import sportsclubmanager.domain.contract.IPermission;

public class Permission
        implements Serializable, IPermission
{
    private String name;
    private String description;

    Permission(IPermission d)
    {
        name = d.getName();
        description = d.getDescription();
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
}
