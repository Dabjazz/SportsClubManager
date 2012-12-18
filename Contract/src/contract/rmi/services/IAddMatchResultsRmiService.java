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
public interface IAddMatchResultsRmiService
        extends Remote
{

    List<IRoleDto> getRoles(Integer memberId)
            throws RemoteException;
    
    List<ICompetitionDto> getCompetitionList()
            throws RemoteException;

    List<IMatchDto> getMatchList(List<Integer> match) throws RemoteException;

    ITeamDto getTeam(Integer hometeam) throws RemoteException;

    List<ITeamDto> getTeamList(List<Integer> team) throws RemoteException;

    void setMatchResult(IMatchDto match, IMatchresultDto matchresult) throws RemoteException;
}
