/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.IMapper;
import contract.dto.mapper.NotFoundException;
import contract.domain.CouldNotSaveException;
import contract.domain.CouldNotDeleteException;
import contract.domain.CouldNotFetchException;
import java.util.*;
import java.util.logging.*;
import contract.dto.classes.CompetitionDto;
import contract.dto.ICompetitionDto;
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

    public contract.domain.ICompetition getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ICompetition a = DomainFacade.getInstance().getByID(contract.domain.ICompetition.class, id);
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
            contract.domain.ICompetition a = DomainFacade.getInstance().getByID(contract.domain.ICompetition.class, id);
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

            for (contract.domain.ICompetition a : DomainFacade.getInstance().getAll(contract.domain.ICompetition.class))
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
        server.domain.classes.Competition competition = new server.domain.classes.Competition(value.getId());

        competition.setDateFrom(value.getDateFrom());
        competition.setDateTo(value.getDateTo());
        competition.setPayment(value.getPayment());

        List< contract.domain.IMatch> matchList = new LinkedList<>();
        List< contract.domain.ITeam> teamList = new LinkedList<>();

        for (int i : value.getMatchList())
        {
            matchList.add(new MatchMapper().getDomainById(i));
        }

        for (int i : value.getTeamList())
        {
            teamList.add(new TeamMapper().getDomainById(i));
        }

        competition.setMatchList(matchList);

        competition.setTeamList(teamList);

        return competition;
    }

    @Override
    public ICompetitionDto getNew()
    {
        return new CompetitionDto();
    }
}
