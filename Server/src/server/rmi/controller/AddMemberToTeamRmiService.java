/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IPlayerDto;
import contract.rmi.services.IAddMemberToTeamRmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.AddMemberToTeam;

/**
 *
 * @author Lucia
 */
public class AddMemberToTeamRmiService extends UnicastRemoteObject implements IAddMemberToTeamRmiService
{

    public AddMemberToTeamRmiService() throws RemoteException {
        super();
    }

    @Override
    public List<IClubTeamDto> getClubTeams(IMemberDto user) throws RemoteException {
        return AddMemberToTeam.getInstance().getClubTeams(user);
    }

    @Override
    public List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam) throws RemoteException {
        return AddMemberToTeam.getInstance().getPotentialPlayer(clubTeam);
    }

    @Override
    public List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam) throws RemoteException {
        return AddMemberToTeam.getInstance().getTeamPlayer(clubTeam);
    }

    @Override
    public void updateClubTeam(IClubTeamDto clubTeam) throws RemoteException {
        AddMemberToTeam.getInstance().updateClubTeam(clubTeam);
    }
    
}
