package contract.dto.classes;

import contract.dto.ICompetitionDto;
import java.io.Serializable;
import java.util.*;

public class CompetitionDto
        implements Serializable, ICompetitionDto
{
    private int id;
    private Date dateFrom;
    private Date dateTo;
    private Double payment;
    private Integer league;
    private Integer sport;
    private List<Integer> teamList = new LinkedList<>();
    private List<Integer> matchList = new LinkedList<>();
    private Integer address;
    private String description;
    private String name;

    public CompetitionDto()
    {
    }

    public CompetitionDto(int id)
    {
        this.id = id;
    }
    private static HashMap<contract.domain.ICompetition, CompetitionDto> competitions = new HashMap<>();

    public static CompetitionDto copy(contract.domain.ICompetition competition)
    {
        CompetitionDto a;

        if (competitions.containsKey(competition))
        {
            a = competitions.get(competition);
        }
        else
        {
            a = new CompetitionDto(competition.getId());

            a.setDateFrom(competition.getDateFrom());
            a.setDateTo(competition.getDateTo());
            a.setPayment(competition.getPayment());
            a.setLeague(competition.getLeague().getId());
            a.setSport(competition.getSport().getId());
            a.setAddress(competition.getAddress().getId());
            a.setName(competition.getName());
            a.setDescription(competition.getDescription());

            for (contract.domain.ITeam d : competition.getTeamList())
            {
                a.teamList.add(d.getId());
            }

            for (contract.domain.IMatch d : competition.getMatchList())
            {
                a.matchList.add(d.getId());
            }
            competitions.put(competition, a);
        }

        return a;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public Date getDateFrom()
    {
        return dateFrom;
    }

    @Override
    public void setDateFrom(Date dateFrom)
    {
        this.dateFrom = dateFrom;
    }

    @Override
    public Date getDateTo()
    {
        return dateTo;
    }

    @Override
    public void setDateTo(Date dateTo)
    {
        this.dateTo = dateTo;
    }

    @Override
    public Double getPayment()
    {
        return payment;
    }

    @Override
    public void setPayment(Double payment)
    {
        this.payment = payment;
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
        return this.league;
    }

    @Override
    public Integer getSport()
    {
        return this.sport;
    }

    @Override
    public void setSport(Integer typeOfSport)
    {
        this.sport = typeOfSport;
    }

    @Override
    public void setLeague(Integer league)
    {
        this.league = league;
    }

    @Override
    public Integer getAddress()
    {
        return this.address;
    }

    @Override
    public void setAddress(Integer address)
    {
        this.address = address;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return this.description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
