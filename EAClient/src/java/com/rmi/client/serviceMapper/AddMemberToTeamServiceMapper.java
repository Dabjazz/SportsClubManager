/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.*;
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
    private IAddMemberToTeamRmiService service;

    public AddMemberToTeamServiceMapper(IAddMemberToTeamRmiService service)
    {
        this.service = service;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(IMemberDto user)
    {
        try
        {
            return service.getClubTeams(user);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMemberToTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam)
    {
        try
        {
            return service.getPotentialPlayer(clubTeam);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMemberToTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam)
    {
        try
        {
            return service.getTeamPlayer(clubTeam);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMemberToTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void updateClubTeam(IClubTeamDto clubTeam)
    {
        try
        {
            service.updateClubTeam(clubTeam);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMemberToTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
