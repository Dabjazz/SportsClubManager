/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.*;
import contract.ejb.business.IShowCompetitionRemote;
import java.util.List;
import javax.ejb.Stateful;
import server.useCaseController.ShowCompetitionController;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
@Stateful
public class ShowCompetitionBean
        implements IShowCompetitionRemote
{
    public ShowCompetitionBean()
    {
        super();
    }

    @Override
    public List<ICompetitionDto> getCompetitions()
    {
        return ShowCompetitionController.getInstance().getCompetitions();
    }

    @Override
    public List<IMatchDto> getMatchs(List<Integer> matches)
    {
        return ShowCompetitionController.getInstance().getMatchs(matches);
    }

    @Override
    public List<IPlayerDto> getPlayer(IClubTeamDto team)
    {
        return ShowCompetitionController.getInstance().getPlayer(team);
    }

    @Override
    public IMatchresultDto getMatchresult(Integer matchresult)
    {
        return ShowCompetitionController.getInstance().getMatchresult(matchresult);

    }

    @Override
    public IClubTeamDto getClubTeam(Integer hometeam)
    {
        return ShowCompetitionController.getInstance().getClubTeam(hometeam);
    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
    {
        return ShowCompetitionController.getInstance().getTeam(hometeam);
    }
}
