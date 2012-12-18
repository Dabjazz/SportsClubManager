/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IPlayerDto;
import contract.dto.IRoleDto;
import contract.ejb.business.IAddMemberToTeamRemote;
import contract.useCaseController.IAddMemberToTeamController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Lucia
 */
public class AddMemberToTeamServiceMapper
        implements IAddMemberToTeamController
{

    private IAddMemberToTeamRemote service;

//    public AddMemberToTeamServiceMapper(IAddMemberToTeamRemote service)
//    {
//        this.service = service;
//    }
    
    public AddMemberToTeamServiceMapper()
    {
        this.service = lookupAddMemberToTeamBeanRemote();
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

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        return service.getRoles(memberId);
    }

    private IAddMemberToTeamRemote lookupAddMemberToTeamBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (IAddMemberToTeamRemote) c.lookup("java:comp/env/AddMemberToTeamBean");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
