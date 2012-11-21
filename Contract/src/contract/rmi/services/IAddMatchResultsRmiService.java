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
    List<ICompetition> getCompetitionList()
            throws RemoteException;

    List<ITeam> getTeamList(List<Integer> team)
            throws RemoteException;

    List<IMatch> getMatchList(List<Integer> match)
            throws RemoteException;

    void setMatchResult(IMatch match, IMatchresult matchresult)
            throws RemoteException;
}
