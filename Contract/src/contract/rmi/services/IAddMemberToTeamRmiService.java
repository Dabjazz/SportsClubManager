/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IPlayerDto;
import contract.dto.IRoleDto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface IAddMemberToTeamRmiService
        extends Remote 
{
    List<IRoleDto> getRoles(Integer memberId)
            throws RemoteException;
    
    //get all teams the department head has access to
    List<IClubTeamDto> getClubTeams(IMemberDto user)
            throws RemoteException;

    //all members/players who would potentialy be able to play in the team
    List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam)
            throws RemoteException;

    //return a list of the current player of the team
    List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam)
            throws RemoteException;

    //update team with it's changed playerlist (if needed playerlist could send as well from GUI --> check if necessary)
    void updateClubTeam(IClubTeamDto clubTeam)
            throws RemoteException;
}
