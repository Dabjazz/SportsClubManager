/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.*;
import contract.rmi.services.IShowCompetitionRmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.ShowCompetition;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ShowCompetitionRmiService
        extends UnicastRemoteObject
        implements IShowCompetitionRmiService
{
    public ShowCompetitionRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public List<ICompetitionDto> getCompetitions()
            throws RemoteException
    {
        return ShowCompetition.getInstance().getCompetitions();
    }

    @Override
    public List<IMatchDto> getMatchs(List<Integer> matches)
            throws RemoteException
    {
        return ShowCompetition.getInstance().getMatchs(matches);
    }

    @Override
    public List<IPlayerDto> getPlayer(IClubTeamDto team)
            throws RemoteException
    {
        return ShowCompetition.getInstance().getPlayer(team);
    }

    @Override
    public IMatchresultDto getMatchresult(Integer matchresult)
            throws RemoteException
    {
        return ShowCompetition.getInstance().getMatchresult(matchresult);

    }

    @Override
    public IClubTeamDto getClubTeam(Integer hometeam)
            throws RemoteException
    {
        return ShowCompetition.getInstance().getClubTeam(hometeam);
    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
            throws RemoteException
    {
        return ShowCompetition.getInstance().getTeam(hometeam);
    }
}
