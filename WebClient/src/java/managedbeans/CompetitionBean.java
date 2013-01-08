package managedbeans;

import contract.domain.IMatchresult;
import contract.dto.ICompetitionDto;
import contract.dto.IMatchDto;
import contract.dto.IMatchresultDto;
import contract.dto.ITeamDto;
import contract.ejb.business.IShowCompetitionRemote;
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
    @EJB private IShowCompetitionRemote showCompetitionBean;
    private String competition;
    private ICompetitionDto selectedCompetition;
    private List<ICompetitionDto> competitions;
    private IMatchDto selectedMatch;
    private IMatchresultDto result;
    /**
     * Creates a new instance of CompetitionBean
     */
    public CompetitionBean()
    {
    }

    public List<ICompetitionDto> getCompetitions()
    {
        if(competitions == null)
        {
            this.competitions = showCompetitionBean.getCompetitions();
        }
        return competitions;
    }

    public String getSelectedCompetition()
    {
        return competition;
    }

    public void setSelectedCompetition(String competition)
    {
        this.competition = competition;
        for(ICompetitionDto c : competitions)
        {
            if(c.getName().equals(competition))
            {
                this.selectedCompetition = c;
                break;
            }
        }
    }

    public List<IMatchDto> getMatchList()
    {
        return showCompetitionBean.getMatchs(selectedCompetition.getMatchList());  
    }

    public IMatchDto getSelectedMatch()
    {
        return selectedMatch;
    }

    public void setSelectedMatch(IMatchDto selectedMatch)
    {
        this.selectedMatch = selectedMatch;
        this.result = showCompetitionBean.getMatchresult(selectedMatch.getMatchresult());
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
        return "match";
    }
    
    public String returnToCompetition()
    {
        return "competition";
    }
}
