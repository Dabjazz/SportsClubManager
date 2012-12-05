package contract.dto.classes;

import contract.domain.IMatch;
import contract.dto.*;
import java.io.Serializable;
import java.util.*;

public class MatchDto
        implements Serializable, IMatchDto
{
    private int id;
    private Date dateFrom;
    private Date dateTo;
    private Integer competition;
    private Integer matchresult;
    private Integer foreignteam;
    private Integer hometeam;

    public MatchDto()
    {
    }

    MatchDto(int id)
    {
        this.id = id;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
    private static HashMap<IMatch, MatchDto> matchs = new HashMap<>();

    public static MatchDto copy(IMatch match)
    {
        MatchDto a;

        if (matchs.containsKey(match))
        {
            a = matchs.get(match);
        }
        else
        {
            a = new MatchDto();

            a.setDateFrom(match.getDateFrom());
            a.setDateTo(match.getDateTo());
            a.competition = match.getCompetition().getId();
            a.matchresult = match.getMatchresult().getId();
            a.foreignteam = match.getForeignteam().getId();
            a.hometeam = match.getHometeam().getId();

            matchs.put(match, a);
        }

        return a;
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
    public Integer getCompetition()
    {
        return competition;
    }

    @Override
    public void setCompetition(Integer competition)
    {
        this.competition = competition;
    }

    @Override
    public Integer getMatchresult()
    {
        return matchresult;
    }

    @Override
    public void setMatchresult(Integer matchresult)
    {
        this.matchresult = matchresult;
    }

    @Override
    public Integer getForeignteam()
    {
        return foreignteam;
    }

    @Override
    public void setForeignteam(Integer foreignteam)
    {
        this.foreignteam = foreignteam;
    }

    @Override
    public Integer getHometeam()
    {
        return hometeam;
    }

    @Override
    public void setHometeam(Integer hometeam)
    {
        this.hometeam = hometeam;
    }

    @Override
    public String toString() {        
        StringBuilder sb = new StringBuilder();
        sb.append(getHometeam().toString());
        sb.append(" : ");
        sb.append(getForeignteam().toString());

        return sb.toString();
    }
}
