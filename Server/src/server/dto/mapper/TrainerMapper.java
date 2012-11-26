/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.ITrainerDto;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import contract.dto.classes.TrainerDto;

/**

 @author Thomas
 */
public class TrainerMapper
        implements IMapper<ITrainerDto>
{
    private static TrainerMapper controller;

    TrainerMapper()
    {
    }

    public static IMapper<ITrainerDto> getInstance()
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
            List<ITrainerDto> result = new LinkedList<>();

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

            List<contract.domain.IClubTeam> clubTeamList = new LinkedList<>();
            for (int i : value.getClubTeamList())
            {
                clubTeamList.add(new ClubTeamMapper().getDomainById(i));
            }
            trainer.setClubTeamList(clubTeamList);

            returnv = DomainFacade.getInstance().set(trainer);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
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
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
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

        LinkedList<contract.domain.IClubTeam> teams = new LinkedList<>();
        for (int id : clubTeams)
        {
            teams.add(new ClubTeamMapper().getDomainById(id));
        }
        trainer.setClubTeamList(teams);

        LinkedList<contract.domain.IPermission> p = new LinkedList<>();

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
}