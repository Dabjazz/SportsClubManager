/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.*;
import contract.rmi.services.IAddMatchResultsRmiService;
import contract.useCaseController.IAddMatchResultsController;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class AddMatchResultsServiceMapper
        implements IAddMatchResultsController
{
    private IAddMatchResultsRmiService service;

    public AddMatchResultsServiceMapper(IAddMatchResultsRmiService service)
    {
        this.service = service;
    }

    @Override
    public List<ICompetitionDto> getCompetitionList()
    {
        try
        {
            return service.getCompetitionList();
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

        // <editor-fold defaultstate="collapsed" desc="4 Test Uses Only">
//            List<ICompetitionDto> compList = new LinkedList<>();
//            List<Integer> ids = new LinkedList<>();
//            ids.add(1);
//            ids.add(2);
//            ids.add(3);
//            Competition c = new Competition();
//            c.setDescription("Cubus");
//            c.setName("TheUltimateCompetition");
//            c.setPayment(15.00);
//            c.setMatchList(ids);
//            c.setTeamList(ids);
//            c.setAddress(1);
//            c.setSport(1);
//            Date d = new Date(2012, 01, 01);
//            c.setDateFrom(d);
//            c.setDateTo(d);
//            compList.add(c);
//            return compList;
        // </editor-fold> 
    }

    @Override
    public List<ITeamDto> getTeamList(List<Integer> team)
    {
        try
        {
            return service.getTeamList(team);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IMatchDto> getMatchList(List<Integer> match)
    {
        try
        {
            return service.getMatchList(match);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setMatchResult(IMatchDto match, IMatchresultDto matchresult)
    {
        try
        {
            service.setMatchResult(match, matchresult);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public List<IRoleDto> getRoles(Integer memberId) {
        try
        {
            return service.getRoles(memberId);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
