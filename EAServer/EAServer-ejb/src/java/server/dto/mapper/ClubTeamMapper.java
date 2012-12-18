/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.IClubTeamDto;
import contract.dto.ITypeOfSportDto;
import contract.dto.classes.ClubTeamDto;
import contract.dto.mapper.ClubTeamNotFoundException;
import contract.dto.mapper.IClubTeamMapper;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.domain.DomainFacade;

/**

 @author Thomas
 */
public class ClubTeamMapper
        implements IClubTeamMapper
{
    private static ClubTeamMapper controller;

    ClubTeamMapper( )
    {
    }

    public static IClubTeamMapper getInstance( )
    {
        if (controller == null)
        {
            controller = new ClubTeamMapper();
        }

        return controller;
    }

    public contract.domain.IClubTeam getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IClubTeam a = DomainFacade.getInstance().getByID(contract.domain.IClubTeam.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IClubTeamDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IClubTeam a = DomainFacade.getInstance().getByID(contract.domain.IClubTeam.class, id);
            return ClubTeamDto.copy(a);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IClubTeamDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<IClubTeamDto> result = new LinkedList<IClubTeamDto>();

            for (contract.domain.IClubTeam a : DomainFacade.getInstance().getAll(contract.domain.IClubTeam.class))
            {
                result.add(ClubTeamDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IClubTeamDto value)
    {
        try
        {
            server.domain.classes.ClubTeam clubTeam = createDomain(value);

            return DomainFacade.getInstance().set(clubTeam);
        } catch (CouldNotSaveException ex)
        {
            Logger.getLogger(ClubTeamMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(ClubTeamMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IClubTeamDto value)
    {
        try
        {
            server.domain.classes.ClubTeam clubTeam = createDomain(value);

            DomainFacade.getInstance().delete(clubTeam);
        } catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(ClubTeamMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException  ex)
        {
            Logger.getLogger(ClubTeamMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.ClubTeam createDomain(IClubTeamDto value)
            throws IdNotFoundException
    {
        server.domain.classes.ClubTeam clubTeam = new server.domain.classes.ClubTeam(value.getId());
        List<contract.domain.IDepartment> departmentList = new LinkedList<IDepartment>();
        List<contract.domain.IPlayer> teamhasPlayerList = new LinkedList<IPlayer>();
        List<contract.domain.ITrainer> trainerList = new LinkedList<ITrainer>();

        for (int d : value.getDepartmentList())
        {
            departmentList.add(new DepartmentMapper().getDomainById(d));
        }

        for (int d : value.getPlayerList())
        {
            teamhasPlayerList.add(new PlayerMapper().getDomainById(d));
        }

        for (int d : value.getTrainerList())
        {
            trainerList.add(new TrainerMapper().getDomainById(d));
        }

        clubTeam.setDepartmentList(departmentList);
        clubTeam.setPlayerList(teamhasPlayerList);
        clubTeam.setTrainerList(trainerList);

        return clubTeam;
    }

    @Override
    public IClubTeamDto getNew()
    {
        return new ClubTeamDto();
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
            throws ClubTeamNotFoundException
    {
        if (sport == null)
        {
            return null;
        }
        try
        {
            List<IClubTeamDto> ret = new LinkedList<IClubTeamDto>();
            ITypeOfSport byID = DomainFacade.getInstance().getByID(contract.domain.ITypeOfSport.class, sport.getId());
            List<server.domain.classes.ClubTeam> clubTeams = DomainFacade.getInstance().getClubTeamsByTypeOfSport(byID);
            for (server.domain.classes.ClubTeam c : clubTeams)
            {
                ret.add(ClubTeamDto.copy(c));
            }
            return ret;

        }
        catch (CouldNotFetchException e)
        {
            throw new ClubTeamNotFoundException(e.getMessage());
        }

    }
}
