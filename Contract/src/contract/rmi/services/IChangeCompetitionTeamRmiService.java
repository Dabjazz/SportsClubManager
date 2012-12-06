/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.*;
import java.rmi.*;
import java.util.List;

/**

 @author Lucia
 */
public interface IChangeCompetitionTeamRmiService
        extends Remote
{
    List<IRoleDto> getRoles(Integer memberId)
            throws RemoteException;
    
    List<ICompetitionDto> getCompetition()
            throws RemoteException;

    List<IClubTeamDto> getClubTeams(List<Integer> Teams)
            throws RemoteException;

    void setCompetitonTeam(ICompetitionDto competition, IClubTeamDto oldTeam, IClubTeamDto newTeam)
            throws RemoteException;

    IClubTeamDto getCompetitionTeam(IClubTeamDto team)
            throws RemoteException;       //get team for competition from this team

    List<IPlayerDto> getPlayers(List<Integer> players)
            throws RemoteException;    //get single players
}
