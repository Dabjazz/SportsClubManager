package contract.dto.classes;

import contract.domain.IMatch;
import contract.dto.*;
import contract.dto.mapper.IdNotFoundException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;

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
    public static IDtoFactory dtoFactory;

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
    public IMatchresultDto getMatchresult()
    {
        try
        {
            return dtoFactory.getMatchresultMapper().getById(matchresult);
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(MatchDto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void setMatchresult(Integer matchresult)
    {
        this.matchresult = matchresult;
    }

    @Override
    public ITeamDto getForeignteam()
    {
        try
        {
            return dtoFactory.getTeamMapper().getById(foreignteam);
        }
        catch (IdNotFoundException | RemoteException ex)
        {
            Logger.getLogger(MatchDto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void setForeignteam(Integer foreignteam)
    {
        this.foreignteam = foreignteam;
    }

    @Override
    public ITeamDto getHometeam()
    {
        try
        {
            return dtoFactory.getTeamMapper().getById(hometeam);
        }
        catch (IdNotFoundException | RemoteException ex)
        {
            Logger.getLogger(MatchDto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void setHometeam(Integer hometeam)
    {
        this.hometeam = hometeam;
    }
}
