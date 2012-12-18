/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IPlayerDto;
import contract.dto.IRoleDto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface IAddMemberToTeamRemote
{
    //get all teams the department head has access to
    List<IClubTeamDto> getClubTeams(IMemberDto user);

    //all members/players who would potentialy be able to play in the team
    List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam);

    //return a list of the current player of the team
    List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam);

    //update team with it's changed playerlist (if needed playerlist could send as well from GUI --> check if necessary)
    void updateClubTeam(IClubTeamDto clubTeam);
    
    List<IRoleDto> getRoles(Integer memberId);
}
