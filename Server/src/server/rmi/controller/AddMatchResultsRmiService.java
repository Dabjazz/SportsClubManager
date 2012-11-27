/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.IMatchDto;
import contract.dto.ICompetitionDto;
import contract.dto.ITeamDto;
import contract.dto.IMatchresultDto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import contract.rmi.services.IAddMatchResultsRmiService;
import server.useCaseController.AddMatchResults;

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
        return AddMatchResults.getInstance().getCompetitionList();
    }

    @Override
    public List<ITeamDto> getTeamList(List<Integer> team)
            throws RemoteException
    {
        return AddMatchResults.getInstance().getTeamList(team);
    }

    @Override
    public List<IMatchDto> getMatchList(List<Integer> match)
            throws RemoteException
    {
        return AddMatchResults.getInstance().getMatchList(match);
    }

    @Override
    public void setMatchResult(IMatchDto match, IMatchresultDto matchresult)
            throws RemoteException
    {
        AddMatchResults.getInstance().setMatchResult(match, matchresult);
    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
            throws RemoteException
    {
        return AddMatchResults.getInstance().getTeam(hometeam);
    }
}
