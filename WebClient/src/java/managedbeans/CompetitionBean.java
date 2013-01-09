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

    /**
     * gets all competitions
     * @return returns a list of competitions
     */
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

    /**
     * sets the selected competition
     * @param competition the competition choosen by the user
     * @return "match" to go to "match.xhtml"
     */
    public String setSelectedCompetition(ICompetitionDto competition)
    {
        this.selectedCompetition = competition;
        return "match";
    }

    /**
     * gets a list of matches from the server
     * @return a list of matches
     */
    public List<IMatchDto> getMatchList()
    {
        return showCompetitionBean.getMatchs(selectedCompetition.getMatchList());  
    }

    public IMatchDto getSelectedMatch()
    {
        return selectedMatch;
    }

    /**
     * sets the match selected by the user
     * @param selectedMatch the selected match
     * @return "result" to go to "result.xhtml"
     */
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
    
    public ITeamDto getHomeTeam(IMatchDto match)
    {
        return showCompetitionBean.getTeam(match.getHometeam());
    }
    
    public ITeamDto getForeignTeam(IMatchDto match)
    {
        return showCompetitionBean.getTeam(match.getForeignteam());
    }
    
    public ITeamDto getSelectedHomeTeam()
    {
        return showCompetitionBean.getTeam(selectedMatch.getHometeam());
    }
    
    public ITeamDto getSelectedForeignTeam()
    {
        return showCompetitionBean.getTeam(selectedMatch.getForeignteam());
    }
    
    public IMatchresultDto getResult()
    {
        return result;
    }
    
    /**
     * save the changed result
     * @return "match" to return to the "match.xhtml"
     */
    public String resultChanged()
    {
        this.addMatchResultsBean.setMatchResult(selectedMatch, result);
        return "match";
    }
    
    /**
     * to return to the competition
     * @return "competition" to go to "competition.xhtml"
     */
    public String returnToCompetition()
    {
        return "competition";
    }
}
