/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.*;
import contract.rmi.services.IChangeCompetitionTeamRmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.ChangeCompetitionTeam;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ChangeCompetitionTeamRmiService
        extends UnicastRemoteObject
        implements IChangeCompetitionTeamRmiService
{
    public ChangeCompetitionTeamRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public List<ICompetitionDto> getCompetition()
    {
        return ChangeCompetitionTeam.getInstance().getCompetition();
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> teams)
    {
        return ChangeCompetitionTeam.getInstance().getClubTeams(teams);
    }

    @Override
    public void setCompetitonTeam(ICompetitionDto competition, IClubTeamDto oldTeam, IClubTeamDto newTeam)
    {
        ChangeCompetitionTeam.getInstance().setCompetitonTeam(competition, oldTeam, newTeam);
    }

    @Override
    public IClubTeamDto getCompetitionTeam(IClubTeamDto team)
            throws RemoteException
    {
        return ChangeCompetitionTeam.getInstance().getCompetitionTeam(team);
    }

    @Override
    public List<IPlayerDto> getPlayers(List<Integer> players)
            throws RemoteException
    {
        return ChangeCompetitionTeam.getInstance().getPlayers(players);
    }
}
