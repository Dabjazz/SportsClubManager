/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.IClubTeamDto;
import contract.dto.ICompetitionDto;
import contract.dto.IPlayerDto;
import contract.ejb.business.IChangeCompetitionTeamRemote;
import java.util.List;
import javax.ejb.Stateless;
import server.useCaseController.ChangeCompetitionTeamController;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
@Stateless
public class ChangeCompetitionTeamBean implements IChangeCompetitionTeamRemote
{
    public ChangeCompetitionTeamBean()
    {
        super();
    }

    @Override
    public List<ICompetitionDto> getCompetition()
    {
        return ChangeCompetitionTeamController.getInstance().getCompetition();
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> teams)
    {
        return ChangeCompetitionTeamController.getInstance().getClubTeams(teams);
    }

    @Override
    public void setCompetitonTeam(ICompetitionDto competition, IClubTeamDto oldTeam, IClubTeamDto newTeam)
    {
        ChangeCompetitionTeamController.getInstance().setCompetitonTeam(competition, oldTeam, newTeam);
    }

    @Override
    public IClubTeamDto getCompetitionTeam(IClubTeamDto team)
    {
        return ChangeCompetitionTeamController.getInstance().getCompetitionTeam(team);
    }

    @Override
    public List<IPlayerDto> getPlayers(List<Integer> players)
    {
        return ChangeCompetitionTeamController.getInstance().getPlayers(players);
    }
}
