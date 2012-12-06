/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.service;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IPlayerDto;
import contract.dto.IRoleDto;
import contract.rmi.services.IAddMemberToTeamRmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.AddMemberToTeamController;

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
        return AddMemberToTeamController.getInstance().getClubTeams(user);
    }

    @Override
    public List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam) throws RemoteException {
        return AddMemberToTeamController.getInstance().getPotentialPlayer(clubTeam);
    }

    @Override
    public List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam) throws RemoteException {
        return AddMemberToTeamController.getInstance().getTeamPlayer(clubTeam);
    }

    @Override
    public void updateClubTeam(IClubTeamDto clubTeam) throws RemoteException {
        AddMemberToTeamController.getInstance().updateClubTeam(clubTeam);
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId) throws RemoteException {
        return AddMemberToTeamController.getInstance().getRoles(memberId);
    }
    
}
