/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IPlayerDto;
import contract.dto.IRoleDto;
import contract.ejb.business.IAddMemberToTeamRemote;
import java.util.List;
import javax.ejb.Stateful;
import server.useCaseController.AddMemberToTeamController;

@Stateful
public class AddMemberToTeamBean implements IAddMemberToTeamRemote
{

    public AddMemberToTeamBean() {
        super();
    }

    @Override
    public List<IClubTeamDto> getClubTeams(IMemberDto user) {
        return AddMemberToTeamController.getInstance().getClubTeams(user);
    }

    @Override
    public List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam) {
        return AddMemberToTeamController.getInstance().getPotentialPlayer(clubTeam);
    }

    @Override
    public List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam) {
        return AddMemberToTeamController.getInstance().getTeamPlayer(clubTeam);
    }

    @Override
    public void updateClubTeam(IClubTeamDto clubTeam) {
        AddMemberToTeamController.getInstance().updateClubTeam(clubTeam);
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        return AddMemberToTeamController.getInstance().getRoles(memberId);
    }
    
}
