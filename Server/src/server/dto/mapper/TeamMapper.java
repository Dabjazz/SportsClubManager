/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.ITeamDto;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import contract.dto.classes.TeamDto;

/**

 @author Thomas
 */
public class TeamMapper
        implements IMapper<ITeamDto>
{
    private static TeamMapper controller;

    TeamMapper()
    {
    }

    public static IMapper<ITeamDto> getInstance()
    {
        if (controller == null)
        {
            controller = new TeamMapper();
        }

        return controller;
    }

    public contract.domain.ITeam getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ITeam a = DomainFacade.getInstance().getByID(contract.domain.ITeam.class, id);
            return a;
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public ITeamDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ITeam a = DomainFacade.getInstance().getByID(contract.domain.ITeam.class, id);
            return TeamDto.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ITeamDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<ITeamDto> result = new LinkedList<>();

            for (contract.domain.ITeam a : DomainFacade.getInstance().getAll(contract.domain.ITeam.class))
            {
                result.add(TeamDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(ITeamDto value)
    {
        Integer rv = 0;
        try
        {
            server.domain.classes.Team team = createDomain(value);

            rv = DomainFacade.getInstance().set(team);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return rv;
        }
    }

    @Override
    public void delete(ITeamDto value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private server.domain.classes.Team createDomain(ITeamDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Team team = new server.domain.classes.Team(value.getId());

        List<Integer> competitions = value.getCompetitionList();
        List<Integer> matches = value.getMatchList();

        team.setDescription(value.getDescription());
        team.setName(value.getName());
        team.setLeague(new LeagueMapper().getDomainById(value.getLeague()));

        LinkedList<contract.domain.ICompetition> c = new LinkedList<>();
        for (int id : competitions)
        {
            c.add(new CompetitionMapper().getDomainById(id));
        }
        team.setCompetitionList(c);

        LinkedList<contract.domain.IMatch> m = new LinkedList<>();
        for (int id : matches)
        {
            m.add(new MatchMapper().getDomainById(id));
        }
        team.setMatchList(m);
        return team;
    }

    @Override
    public ITeamDto getNew()
    {
        return new TeamDto();
    }
}
