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
public interface IShowCompetition
{
    List<ICompetitionDto> getCompetitions();

    List<IMatchDto> getMatchs(List<Integer> matches);

    List<IPlayerDto> getPlayer(IClubTeamDto team);

    IClubTeamDto getClubTeam(Integer hometeam);

    ITeamDto getTeam(Integer hometeam);

    IMatchresultDto getMatchresult(Integer matchresult);
}
