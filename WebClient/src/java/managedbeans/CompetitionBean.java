package managedbeans;

import contract.dto.ICompetitionDto;
import contract.dto.IMatchDto;
import contract.dto.IMatchresultDto;
import contract.dto.ITeamDto;
import contract.ejb.business.IAddMatchResultsRemote;
import contract.ejb.business.IShowCompetitionRemote;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@ManagedBean(name = "competition")
@SessionScoped
public class CompetitionBean
{
    @EJB private IAddMatchResultsRemote addMatchResultsBean;
    @EJB private IShowCompetitionRemote showCompetitionBean;
    private ICompetitionDto selectedCompetition = null;
    private List<ICompetitionDto> competitions = new LinkedList<ICompetitionDto>();
    private IMatchDto selectedMatch = null;
    private IMatchresultDto result = null;
    /**
     * Creates a new instance of CompetitionBean
     */
    public CompetitionBean()
    {
    }

    public List<ICompetitionDto> getCompetitions()
    {
        if(competitions.isEmpty())
        {
            this.competitions = showCompetitionBean.getCompetitions();
        }
        return competitions;
    }

    public ICompetitionDto getSelectedCompetition()
    {
        return this.selectedCompetition;
    }

    public String setSelectedCompetition(ICompetitionDto competition)
    {
        this.selectedCompetition = competition;
        return "match";
    }

    public List<IMatchDto> getMatchList()
    {
        return showCompetitionBean.getMatchs(selectedCompetition.getMatchList());  
    }

    public IMatchDto getSelectedMatch()
    {
        return selectedMatch;
    }

    public String setSelectedMatch(IMatchDto selectedMatch)
    {
        this.selectedMatch = selectedMatch;
        this.result = showCompetitionBean.getMatchresult(selectedMatch.getMatchresult());
        return "result";
    }

    public String getMatchName(IMatchDto match)
    {
        return match.toString();
    }
    
    public ITeamDto getHomeTeam()
    {
        return showCompetitionBean.getTeam(selectedMatch.getHometeam());
    }
    
    public ITeamDto getForeignTeam()
    {
        return showCompetitionBean.getTeam(selectedMatch.getForeignteam());
    }
    
    public IMatchresultDto getResult()
    {
        return result;
    }
    
    public String resultChanged()
    {
        this.addMatchResultsBean.setMatchResult(selectedMatch, result);
        return "match";
    }
    
    public String returnToCompetition()
    {
        return "competition";
    }
}
