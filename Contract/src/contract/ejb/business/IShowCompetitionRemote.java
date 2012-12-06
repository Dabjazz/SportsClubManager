/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.*;
import java.util.List;
import javax.ejb.Remote;

/**
 @author Lucia
 */
@Remote
public interface IShowCompetitionRemote
{
    List<ICompetitionDto> getCompetitions();

    List<IMatchDto> getMatchs(List<Integer> matches);

    List<IPlayerDto> getPlayer(IClubTeamDto team);

    IMatchresultDto getMatchresult(Integer matchresult);

    IClubTeamDto getClubTeam(Integer hometeam);

    ITeamDto getTeam(Integer hometeam);
}
