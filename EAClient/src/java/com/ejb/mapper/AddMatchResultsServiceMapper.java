/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.*;
import contract.ejb.business.IAddMatchResultsRemote;
import contract.useCaseController.IAddMatchResultsController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class AddMatchResultsServiceMapper
        implements IAddMatchResultsController
{

    private IAddMatchResultsRemote service;

//    public AddMatchResultsServiceMapper(IAddMatchResultsRemote service)
//    {
//        this.service = service;
//    }

    public AddMatchResultsServiceMapper()
    {
        this.service = lookupAddMatchResultsBeanRemote();
    }
    
    @Override
    public List<ICompetitionDto> getCompetitionList()
    {
        return service.getCompetitionList();
    }

    @Override
    public List<ITeamDto> getTeamList(List<Integer> team)
    {
        return service.getTeamList(team);
    }

    @Override
    public List<IMatchDto> getMatchList(List<Integer> match)
    {
        return service.getMatchList(match);
    }

    @Override
    public void setMatchResult(IMatchDto match, IMatchresultDto matchresult)
    {
        service.setMatchResult(match, matchresult);
    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
    {
        return service.getTeam(hometeam);
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        return service.getRoles(memberId);
    }

    private IAddMatchResultsRemote lookupAddMatchResultsBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (IAddMatchResultsRemote) c.lookup("java:comp/env/AddMatchResultsBean");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}