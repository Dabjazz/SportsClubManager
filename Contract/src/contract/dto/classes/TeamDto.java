package contract.dto.classes;

import contract.domain.ILeague;
import java.io.Serializable;
import java.util.*;
import contract.dto.ITeamDto;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TeamDto
        implements Serializable, ITeamDto
{
    private int id;
    private String name;
    private String description;
    private List<Integer> competitionList = new LinkedList<>();
    private List<Integer> matchList = new LinkedList<>();
    private Integer league;
    private static HashMap<contract.domain.ITeam, TeamDto> teams = new HashMap<>();

    public TeamDto()
    {
    }

    public static TeamDto copy(contract.domain.ITeam team)
    {
        TeamDto a;

        if (teams.containsKey(team))
        {
            a = teams.get(team);
        }
        else
        {
            a = new TeamDto();

            a.setName(team.getName());
            a.setDescription(team.getDescription());
            a.setLeague(team.getLeague().getId());
            for (contract.domain.ICompetition c : team.getCompetitionList())
            {
                a.competitionList.add(c.getId());
            }

            for (contract.domain.IMatch c : team.getMatchList())
            {
                a.matchList.add(c.getId());
            }

            teams.put(team, a);
        }

        return a;
    }

    public static contract.domain.ITeam copy(ITeamDto team,
                                                               contract.domain.ILeague league,
                                                               List<contract.domain.ICompetition> competitionList,
                                                               List<contract.domain.IMatch> matchList)
    {
//        contract.domain.ITeam a = new server.domain.classes.Team(team.getId());
//
//        a.setName(team.getName());
//        a.setDescription(team.getDescription());
//        a.setLeague(league);
//
//        a.setCompetitionList(competitionList);
//
//        a.setMatchList(matchList);
//
//        return a;
        throw new NotImplementedException();
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
    public List<Integer> getCompetitionList()
    {
        return competitionList;
    }

    @Override
    public void setCompetitionList(List<Integer> competitionList)
    {
        this.competitionList = competitionList;
    }

    @Override
    public List<Integer> getMatchList()
    {
        return matchList;
    }

    @Override
    public void setMatchList(List<Integer> matchList)
    {
        this.matchList = matchList;
    }

    @Override
    public Integer getLeague()
    {
        return league;
    }

    @Override
    public void setLeague(Integer league)
    {
        this.league = league;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public void setLeague(ILeague league)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
