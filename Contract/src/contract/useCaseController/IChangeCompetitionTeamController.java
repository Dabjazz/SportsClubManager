/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.*;
import java.util.List;

/**

 @author Lucia
 */
public interface IChangeCompetitionTeamController
{
    List<ICompetitionDto> getCompetition();

    List<IClubTeamDto> getClubTeams(List<Integer> Teams);

    IClubTeamDto getCompetitionTeam(IClubTeamDto team);       //get team for competition from this team

    List<IPlayerDto> getPlayers(List<Integer> players);    //get single players

    void setCompetitonTeam(ICompetitionDto competition, IClubTeamDto oldTeam, IClubTeamDto newTeam);

    public List<IClubTeamDto> getClubTeams();
}
