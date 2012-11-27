package contract.dto.classes;

import contract.dto.*;
import contract.dto.mapper.*;
import java.io.Serializable;
import java.rmi.*;
import java.util.*;
import java.util.logging.*;

public class LeagueDto
        implements Serializable, ILeagueDto
{
    private int id;
    private String name;
    private String description;
    private List<Integer> teamList = new LinkedList<>();
    private List<Integer> competitions = new LinkedList<>();
    public static IDtoFactory dtoFactory;

    public LeagueDto()
    {
    }

    LeagueDto(int id)
    {
        this.id = id;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
    private static HashMap<contract.domain.ILeague, LeagueDto> leagues = new HashMap<>();

    public static LeagueDto copy(contract.domain.ILeague league)
    {
        LeagueDto a;

        if (leagues.containsKey(league))
        {
            a = leagues.get(league);
        }
        else
        {
            a = new LeagueDto();

            a.setName(league.getName());
            a.setDescription(league.getDescription());

            for (contract.domain.ICompetition c : league.getCompetitions())
            {
                a.competitions.add(c.getId());
            }

            for (contract.domain.ITeam d : league.getTeamList())
            {
                a.teamList.add(d.getId());
            }

            leagues.put(league, a);
        }

        return a;
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

    @Override
    public List<Integer> getTeamList()
    {
        return teamList;
    }

    @Override
    public void setTeamList(List<Integer> teamList)
    {
        this.teamList = teamList;
    }

    @Override
    public List<Integer> getCompetitions()
    {
        return competitions;
    }

    @Override
    public void setCompetitions(List<Integer> competitions)
    {
        this.competitions = competitions;
    }

    @Override
    public List<ICompetitionDto> getCompetitionsByDate(Date date)
    {
        List<ICompetitionDto> result = new LinkedList<>();

        for (int c : competitions)
        {
            try
            {
                ICompetitionDto competitionDto = dtoFactory.getCompetitionMapper().getById(c);

                if (competitionDto.getDateFrom().getDate() == date.getDate())
                {
                    result.add(competitionDto);
                }
            }
            catch (RemoteException | IdNotFoundException ex)
            {
                Logger.getLogger(LeagueDto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }
}
