/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.IClubTeamDto;
import contract.dto.ICompetitionDto;
import contract.dto.IPlayerDto;
import contract.dto.IRoleDto;
import contract.ejb.business.IChangeCompetitionTeamRemote;
import contract.useCaseController.IChangeCompetitionTeamController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ChangeCompetitionTeamServiceMapper
        implements IChangeCompetitionTeamController
{
    private IChangeCompetitionTeamRemote service;

//    public ChangeCompetitionTeamServiceMapper(IChangeCompetitionTeamRemote service)
//    {
//        this.service = service;
//    }
    
    public ChangeCompetitionTeamServiceMapper()
    {
        this.service = lookupChangeCompetitionTeamBeanRemote();
    }

    @Override
    public List<ICompetitionDto> getCompetition()
    {
        return service.getCompetition();
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> Teams)
    {
        return service.getClubTeams(Teams);
    }

    @Override
    public IClubTeamDto getCompetitionTeam(IClubTeamDto team)
    {
        return service.getCompetitionTeam(team);
    }

    @Override
    public List<IPlayerDto> getPlayers(List<Integer> players)
    {
        return service.getPlayers(players);
    }

    @Override
    public void setCompetitonTeam(ICompetitionDto competition, IClubTeamDto oldTeam, IClubTeamDto newTeam)
    {
       service.setCompetitonTeam(competition, oldTeam, newTeam);
    }

    @Override
    public List<IClubTeamDto> getClubTeams()
    {
        return service.getClubTeams(null);
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        return service.getRoles(memberId);
    }

    private IChangeCompetitionTeamRemote lookupChangeCompetitionTeamBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (IChangeCompetitionTeamRemote) c.lookup("java:comp/env/ChangeCompetitionTeamBean");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
