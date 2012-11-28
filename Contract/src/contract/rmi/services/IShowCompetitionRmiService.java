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
public interface IShowCompetitionRmiService
        extends Remote
{
    List<ICompetitionDto> getCompetitions()
            throws RemoteException;

    List<IMatchDto> getMatchs(List<Integer> matches)
            throws RemoteException;

    List<IPlayerDto> getPlayer(IClubTeamDto team)
            throws RemoteException;

    IMatchresultDto getMatchresult(Integer matchresult)
            throws RemoteException;

    IClubTeamDto getClubTeam(Integer hometeam)
            throws RemoteException;

    ITeamDto getTeam(Integer hometeam)
            throws RemoteException;
}
