/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IPlayerDto;
import java.util.List;

/**
 * UseCase: Vereinsmitglieder den Mannschaften (ausschließlich) aus ihrer
 * Abteilung zuordnen
 *
 * @author Lucia
 */
public interface IAddMemberToTeamController {
    
    //get all teams the department head has access to
    List<IClubTeamDto> getClubTeams(IMemberDto user);

    //all members/players who would potentialy be able to play in the team
    List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam);

    //return a list of the current player of the team
    List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam);
    
    //update team with it's changed playerlist (if needed playerlist could send as well from GUI --> check if necessary)
    void updateClubTeam(IClubTeamDto clubTeam);
}
