/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.dto.*;
import contract.dto.mapper.*;
import java.util.*;

/**

 @author Thomas
 */
public class RoleMapper
        implements IMapper<IRoleDto>
{
    private static RoleMapper controller;

    RoleMapper()
    {
    }

    public static IMapper<IRoleDto> getInstance()
    {
        if (controller == null)
        {
            controller = new RoleMapper();
        }

        return controller;
    }

    @Override
    public IRoleDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            IRoleDto r = PlayerMapper.getInstance().getById(id);
            return r;
        }
        catch (IdNotFoundException e)
        {
        }

        try
        {
            IRoleDto r = TrainerMapper.getInstance().getById(id);
            return r;
        }
        catch (IdNotFoundException e)
        {
        }

        try
        {
            IRoleDto r = CaretakerMapper.getInstance().getById(id);
            return r;
        }
        catch (IdNotFoundException e)
        {
        }

        try
        {
            IRoleDto r = AdminMapper.getInstance().getById(id);
            return r;
        }
        catch (IdNotFoundException e)
        {
        }

        try
        {
            IRoleDto r = DepartmentHeadMapper.getInstance().getById(id);
            return r;
        }
        catch (IdNotFoundException e)
        {
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<IRoleDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<IRoleDto> roles = new LinkedList<>();

            roles.addAll(TrainerMapper.getInstance().getAll());
            roles.addAll(PlayerMapper.getInstance().getAll());
            roles.addAll(DepartmentHeadMapper.getInstance().getAll());

            return roles;
        }
        catch (NotFoundException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IRoleDto value)
    {
        if (value instanceof ITrainerDto)
        {
            return TrainerMapper.getInstance().set((ITrainerDto) value);
        }
        else if (value instanceof IPlayerDto)
        {
            return PlayerMapper.getInstance().set((IPlayerDto) value);
        }
        else if (value instanceof IDepartmentHeadDto)
        {
            return DepartmentHeadMapper.getInstance().set((IDepartmentHeadDto) value);
        }

        return 0;
    }

    @Override
    public void delete(IRoleDto value)
    {
        if (value instanceof ITrainerDto)
        {
            TrainerMapper.getInstance().delete((ITrainerDto) value);
        }
        else if (value instanceof IPlayerDto)
        {
            PlayerMapper.getInstance().delete((IPlayerDto) value);
        }
        else if (value instanceof IDepartmentHeadDto)
        {
            DepartmentHeadMapper.getInstance().delete((IDepartmentHeadDto) value);
        }
    }

    @Override
    public IRoleDto getNew()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
