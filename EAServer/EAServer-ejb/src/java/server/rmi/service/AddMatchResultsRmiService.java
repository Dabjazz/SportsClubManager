/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.service;

import contract.dto.*;
import contract.rmi.services.IAddMatchResultsRmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.AddMatchResultsController;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class AddMatchResultsRmiService
        extends UnicastRemoteObject
        implements IAddMatchResultsRmiService
{
    public AddMatchResultsRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public List<ICompetitionDto> getCompetitionList()
            throws RemoteException
    {
        return AddMatchResultsController.getInstance().getCompetitionList();
    }

    @Override
    public List<ITeamDto> getTeamList(List<Integer> team)
            throws RemoteException
    {
        return AddMatchResultsController.getInstance().getTeamList(team);
    }

    @Override
    public List<IMatchDto> getMatchList(List<Integer> match)
            throws RemoteException
    {
        return AddMatchResultsController.getInstance().getMatchList(match);
    }

    @Override
    public void setMatchResult(IMatchDto match, IMatchresultDto matchresult)
            throws RemoteException
    {
        AddMatchResultsController.getInstance().setMatchResult(match, matchresult);
    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
            throws RemoteException
    {
        return AddMatchResultsController.getInstance().getTeam(hometeam);
    }
}
