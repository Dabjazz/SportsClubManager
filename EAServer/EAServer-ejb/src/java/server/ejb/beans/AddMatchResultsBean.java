/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.*;
import contract.ejb.business.IAddMatchResultsRemote;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import server.useCaseController.AddMatchResultsController;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
@Stateful
public class AddMatchResultsBean implements IAddMatchResultsRemote
{
    public AddMatchResultsBean()
    {
        super();
    }

    @Override
    public List<ICompetitionDto> getCompetitionList()
    {
        return AddMatchResultsController.getInstance().getCompetitionList();
    }

    @Override
    public List<ITeamDto> getTeamList(List<Integer> team)
    {
        return AddMatchResultsController.getInstance().getTeamList(team);
    }

    @Override
    public List<IMatchDto> getMatchList(List<Integer> match)
    {
        return AddMatchResultsController.getInstance().getMatchList(match);
    }

    @Override
    public void setMatchResult(IMatchDto match, IMatchresultDto matchresult)
    {
        AddMatchResultsController.getInstance().setMatchResult(match, matchresult);
    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
    {
        return AddMatchResultsController.getInstance().getTeam(hometeam);
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        return AddMatchResultsController.getInstance().getRoles(memberId);
    }
}
