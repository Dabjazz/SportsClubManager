/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.*;
import contract.rmi.services.IChangeCompetitionTeamRmiService;
import contract.useCaseController.IChangeCompetitionTeamController;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ChangeCompetitionTeamServiceMapper
        implements IChangeCompetitionTeamController
{
    private IChangeCompetitionTeamRmiService service;

    public ChangeCompetitionTeamServiceMapper(IChangeCompetitionTeamRmiService service)
    {
        this.service = service;
    }

    @Override
    public List<ICompetitionDto> getCompetition()
    {
        try
        {
            return service.getCompetition();
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> Teams)
    {
        try
        {
            return service.getClubTeams(Teams);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IClubTeamDto getCompetitionTeam(IClubTeamDto team)
    {
        try
        {
            return service.getCompetitionTeam(team);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IPlayerDto> getPlayers(List<Integer> players)
    {
        try
        {
            return service.getPlayers(players);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setCompetitonTeam(ICompetitionDto competition, IClubTeamDto oldTeam, IClubTeamDto newTeam)
    {
        try
        {
            service.setCompetitonTeam(competition, oldTeam, newTeam);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IClubTeamDto> getClubTeams()
    {
        try
        {
            return service.getClubTeams(null);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
