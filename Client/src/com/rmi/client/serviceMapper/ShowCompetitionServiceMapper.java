/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.*;
import contract.rmi.services.IShowCompetitionRmiService;
import contract.useCaseController.IShowCompetitionController;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ShowCompetitionServiceMapper
        implements IShowCompetitionController
{
    private IShowCompetitionRmiService service;

    public ShowCompetitionServiceMapper(IShowCompetitionRmiService service)
    {
        this.service = service;
    }

    @Override
    public List<ICompetitionDto> getCompetitions()
    {
        try
        {
            return service.getCompetitions();
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ShowCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IMatchDto> getMatchs(List<Integer> matches)
    {
        try
        {
            return service.getMatchs(matches);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ShowCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IPlayerDto> getPlayer(IClubTeamDto team)
    {
        try
        {
            return service.getPlayer(team);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ShowCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
    {
        try
        {
            return service.getTeam(hometeam);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public IClubTeamDto getClubTeam(Integer hometeam)
    {
        try
        {
            return service.getClubTeam(hometeam);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public IMatchresultDto getMatchresult(Integer matchresult)
    {
        try
        {
            return service.getMatchresult(matchresult);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
