/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.CouldNotFetchException;
import contract.domain.IRole;
import contract.dto.*;
import contract.dto.classes.AdminDto;
import contract.dto.classes.CaretakerDto;
import contract.dto.classes.DepartmentHeadDto;
import contract.dto.classes.MemberDto;
import contract.dto.classes.PlayerDto;
import contract.dto.classes.RoleDto;
import contract.dto.classes.TrainerDto;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.domain.DomainFacade;
import server.domain.classes.Admin;
import server.domain.classes.Caretaker;
import server.domain.classes.DepartmentHead;
import server.domain.classes.Member;
import server.domain.classes.Player;
import server.domain.classes.Role;
import server.domain.classes.Trainer;

/**
 *
 * @author Thomas
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
            IRole r = DomainFacade.getInstance().getByID(Role.class, id);
            
            if(r instanceof DepartmentHead)
            {
                return DepartmentHeadDto.copy((DepartmentHead)r);
            }else if(r instanceof Admin)
            {
                return AdminDto.copy((Admin)r);
            }else if(r instanceof Caretaker)
            {
                return CaretakerDto.copy((Caretaker)r);
            }else if(r instanceof Player)
            {
                return PlayerDto.copy((Player)r);
            }else
            {
                return TrainerDto.copy((Trainer)r);
            }

        }
        catch (CouldNotFetchException ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IRoleDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<IRoleDto> roles = new LinkedList<IRoleDto>();

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
        else
        {
            if (value instanceof IPlayerDto)
            {
                return PlayerMapper.getInstance().set((IPlayerDto) value);
            }
            else
            {
                if (value instanceof IDepartmentHeadDto)
                {
                    return DepartmentHeadMapper.getInstance().set((IDepartmentHeadDto) value);
                }
            }
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
        else
        {
            if (value instanceof IPlayerDto)
            {
                PlayerMapper.getInstance().delete((IPlayerDto) value);
            }
            else
            {
                if (value instanceof IDepartmentHeadDto)
                {
                    DepartmentHeadMapper.getInstance().delete((IDepartmentHeadDto) value);
                }
            }
        }
    }

    @Override
    public IRoleDto getNew()
    {
        return RoleMapper.getInstance().getNew();
    }
}
