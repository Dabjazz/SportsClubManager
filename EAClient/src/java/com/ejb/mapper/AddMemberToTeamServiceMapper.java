/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.*;
import contract.ejb.business.IAddMemberToTeamRemote;
import contract.rmi.services.IAddMemberToTeamRmiService;
import contract.useCaseController.IAddMemberToTeamController;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;

/**

 @author Lucia
 */
public class AddMemberToTeamServiceMapper
        implements IAddMemberToTeamController
{
    private IAddMemberToTeamRemote service;

    public AddMemberToTeamServiceMapper(IAddMemberToTeamRemote service)
    {
        this.service = service;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(IMemberDto user)
    {
        return service.getClubTeams(user);
    }

    @Override
    public List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam)
    {
        return service.getPotentialPlayer(clubTeam);
    }

    @Override
    public List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam)
    {
        return service.getTeamPlayer(clubTeam);
    }

    @Override
    public void updateClubTeam(IClubTeamDto clubTeam)
    {
        service.updateClubTeam(clubTeam);
    }
}
