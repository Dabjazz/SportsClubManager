/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.ITrainerDto;
import contract.dto.classes.TrainerDto;
import contract.dto.mapper.ITrainerMapper;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.domain.DomainFacade;
import server.domain.classes.Role;

/**

 @author Thomas
 */
public class TrainerMapper
        implements ITrainerMapper
{
    private static TrainerMapper controller;

    TrainerMapper()
    {
    }

    public static ITrainerMapper getInstance()
    {
        if (controller == null)
        {
            controller = new TrainerMapper();
        }

        return controller;
    }

    public contract.domain.ITrainer getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ITrainer a = DomainFacade.getInstance().getByID(contract.domain.ITrainer.class, id);
            return a;
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public ITrainerDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ITrainer a = DomainFacade.getInstance().getByID(contract.domain.ITrainer.class, id);
            return TrainerDto.copy(a);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ITrainerDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<ITrainerDto> result = new LinkedList<ITrainerDto>();

            for (contract.domain.ITrainer a : DomainFacade.getInstance().getAll(contract.domain.ITrainer.class))
            {
                result.add(TrainerDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(ITrainerDto value)
    {
        Integer returnv = 0;
        try
        {
            server.domain.classes.Trainer trainer = new server.domain.classes.Trainer(value.getId());

            List<contract.domain.IClubTeam> clubTeamList = new LinkedList<IClubTeam>();
            for (int i : value.getClubTeamList())
            {
                clubTeamList.add(new ClubTeamMapper().getDomainById(i));
            }
            trainer.setClubTeamList(clubTeamList);

            returnv = DomainFacade.getInstance().set(trainer);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return returnv;
        }
    }

    @Override
    public void delete(ITrainerDto value)
    {
        try
        {
            server.domain.classes.Trainer typeofsport = createDomain(value);

            DomainFacade.getInstance().delete(typeofsport);
        } catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(TrainerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Trainer createDomain(ITrainerDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Trainer trainer = new server.domain.classes.Trainer(value.getId());

        List<Integer> clubTeams = value.getClubTeamList();
        List<Integer> permisssions = value.getPermisssionList();

        LinkedList<contract.domain.IClubTeam> teams = new LinkedList<IClubTeam>();
        for (int id : clubTeams)
        {
            teams.add(new ClubTeamMapper().getDomainById(id));
        }
        trainer.setClubTeamList(teams);

        LinkedList<contract.domain.IPermission> p = new LinkedList<IPermission>();

        for (int id : permisssions)
        {
            p.add(new PermissionMapper().getDomainById(id));
        }
        trainer.setPermissionList(p);

        return trainer;
    }

    @Override
    public ITrainerDto getNew()
    {
        return new TrainerDto();
    }

    @Override
    public ITrainerDto getMemberById(Integer id) throws IdNotFoundException {
        ITrainerDto dto = null;
        try
        {
            List<Role> all = DomainFacade.getInstance().getAll(server.domain.classes.Role.class);
            for(Role r : all)
            {
                IMember member = r.getMember();
                if(member.getId().equals(id))
                {
                    if(r instanceof server.domain.classes.Trainer)
                    {
                        dto=TrainerDto.copy((server.domain.classes.Trainer)r);
                    }
                }
            }

            return dto;
        }
        catch (CouldNotFetchException ex)
        {
            throw new IdNotFoundException();
        }
    }
}