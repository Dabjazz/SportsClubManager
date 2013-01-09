/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.*;
import contract.dto.classes.LeagueDto;
import contract.dto.mapper.*;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;

/**

 @author Thomas
 */
public class LeagueMapper
        implements ILeagueMapper
{
    private static LeagueMapper controller;

    LeagueMapper()
    {
    }

    public static LeagueMapper getInstance()
    {
        if (controller == null)
        {
            controller = new LeagueMapper();
        }

        return controller;
    }

    public contract.domain.ILeague getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ILeague a = DomainFacade.getInstance().getByID(contract.domain.ILeague.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public ILeagueDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ILeague a = DomainFacade.getInstance().getByID(contract.domain.ILeague.class, id);
            return LeagueDto.copy(a);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ILeagueDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<ILeagueDto> result = new LinkedList<ILeagueDto>();

            for (contract.domain.ILeague a : DomainFacade.getInstance().getAll(contract.domain.ILeague.class))
            {
                result.add(LeagueDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(ILeagueDto value)
    {
        try
        {
            server.domain.classes.League league = createDomain(value);

            return DomainFacade.getInstance().set(league);
        } catch (CouldNotSaveException ex)
        {
            Logger.getLogger(LeagueMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException  ex)
        {
            Logger.getLogger(LeagueMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ILeagueDto value)
    {
        try
        {
            server.domain.classes.League league = createDomain(value);

            DomainFacade.getInstance().delete(league);
        } catch (CouldNotDeleteException ex)
        {
            Logger.getLogger(LeagueMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(LeagueMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.League createDomain(ILeagueDto value)
            throws IdNotFoundException
    {
        server.domain.classes.League league = new server.domain.classes.League(value.getId());

        league.setDescription(value.getDescription());
        league.setName(value.getName());

        List<contract.domain.ITeam> teamList = new LinkedList<ITeam>();

        for (int i : value.getTeamList())
        {
            teamList.add(new TeamMapper().getDomainById(i));
        }

        league.setTeamList(teamList);

        return league;
    }

    @Override
    public ILeagueDto getByName(String league, ITypeOfSportDto typeOfSport)
            throws NotFoundException
    {
        try
        {
            ITypeOfSport sport = TypeOfSportMapper.getInstance().getDomainById(typeOfSport.getId());
            ILeague l = DomainFacade.getInstance().getLeageByNameAndTypeOfSport(sport, league);
            return LeagueDto.copy(l);
        } catch (IdNotFoundException ex)
        {
            throw new NotFoundException(ex);
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public ILeagueDto getNew()
    {
        return new LeagueDto();
    }
    
      @Override
    public List<ICompetitionDto> getCompetitionsByDate(ILeagueDto leagueDto, Date date)
    {
        List<ICompetitionDto> result = new LinkedList<ICompetitionDto>();

        for (int c : leagueDto.getCompetitions())
        {
            try
            {
                DtoFactory dtoFactory = new DtoFactory();
                System.out.println("dtofactory is null " + ( dtoFactory == null));
                IMapper<ICompetitionDto> cMapper = dtoFactory.getCompetitionMapper();
                ICompetitionDto competitionDto = cMapper.getById(c);

                System.out.println("competitiondate == " +competitionDto.getDateFrom().getTime() +" equals " +date.getTime());
                if (competitionDto.getDateFrom().getTime() == date.getTime())
                {
                    result.add(competitionDto);
                }
            }
               catch (  IdNotFoundException ex                    )
            {
                Logger.getLogger(LeagueDto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }
}
