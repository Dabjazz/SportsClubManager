/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.*;
import contract.ejb.business.INewMemberRemote;
import contract.useCaseController.INewMemberController;
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
public class NewMemberServiceMapper
        implements INewMemberController
{

    private INewMemberRemote service;

//    public NewMemberServiceMapper(INewMemberRemote service) {
//        this.service = service;
//    }
    public NewMemberServiceMapper()
    {
        this.service = lookupNewMemberBeanRemote();
    }

    @Override
    public void setNewMember(IMemberDto member, IAddressDto address)
    {

        service.setNewMember(member, address);

    }

    @Override
    public List<IDepartmentDto> getDepartments()
    {

        return service.getDepartments();

    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
    {

        return service.getClubTeams(clubTeams);

    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList)
    {

        service.setNewTrainer(member, address, clubTeamList);

    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList)
    {

        service.setNewPlayer(member, address, clubTeamList);

    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList)
    {
        return service.getTypeOfSports(typOfSportsList);

    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
    {

        return service.getClubTeamsByTypeOfSport(sport);

    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
    {

        return service.getAllSports();

    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        return service.getRoles(memberId);
    }

    private INewMemberRemote lookupNewMemberBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (INewMemberRemote) c.lookup("java:comp/env/NewMemberBean");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
