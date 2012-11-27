/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import com.sun.org.apache.bcel.internal.generic.*;
import contract.domain.*;
import contract.dto.*;
import contract.dto.ICompetitionDto;
import contract.dto.classes.CompetitionDto;
import contract.dto.mapper.*;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class CompetitionMapper
        implements IMapper<ICompetitionDto>
{
    private static CompetitionMapper controller;

    CompetitionMapper()
    {
    }

    public static IMapper<ICompetitionDto> getInstance()
    {
        if (controller == null)
        {
            controller = new CompetitionMapper();
        }

        return controller;
    }

    public ICompetition getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            ICompetition a = DomainFacade.getInstance().getByID(ICompetition.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public ICompetitionDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            ICompetition a = DomainFacade.getInstance().getByID(ICompetition.class, id);
            return CompetitionDto.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ICompetitionDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<ICompetitionDto> result = new LinkedList<>();

            for (ICompetition a : DomainFacade.getInstance().getAll(ICompetition.class))
            {
                result.add(CompetitionDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(ICompetitionDto value)
    {
        try
        {
            server.domain.classes.Competition competition = createDomain(value);

            return DomainFacade.getInstance().set(competition);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(CompetitionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ICompetitionDto value)
    {
        try
        {
            server.domain.classes.Competition competition = createDomain(value);

            DomainFacade.getInstance().delete(competition);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(CompetitionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Competition createDomain(ICompetitionDto value)
            throws IdNotFoundException
    {
        try
        {
            server.domain.classes.Competition competition = new server.domain.classes.Competition(value.getId());

            competition.setName(value.getName());
            competition.setDescription(value.getDescription());
            AddressMapper am = (AddressMapper) new DtoFactory().getAddressMapper();
            competition.setAddress(am.getDomainById(value.getAddress()));

            LeagueMapper lm = (LeagueMapper) new DtoFactory().getLeagueMapper();
            competition.setLeague(lm.getDomainById(value.getLeague()));

            competition.setDateFrom(value.getDateFrom());
            competition.setDateTo(value.getDateTo());
            competition.setPayment(value.getPayment());

            List< IMatch> matchList = new LinkedList<>();
            List< ITeam> teamList = new LinkedList<>();

            MatchMapper m = (MatchMapper) new DtoFactory().getMatchMapper();

            for (int i : value.getMatchList())
            {
                matchList.add(m.getDomainById(i));
            }

            for (int i : value.getTeamList())
            {
                teamList.add(new TeamMapper().getDomainById(i));
            }

            competition.setMatchList(matchList);

            competition.setTeamList(teamList);

            return competition;
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(CompetitionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ICompetitionDto getNew()
    {
        return new CompetitionDto();
    }
}
