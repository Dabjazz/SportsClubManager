/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.*;
import contract.rmi.services.INewMemberRmiService;
import contract.useCaseController.INewMemberController;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewMemberServiceMapper
        implements INewMemberController
{
    private INewMemberRmiService service;

    public NewMemberServiceMapper(INewMemberRmiService service)
    {
        this.service = service;
    }

    @Override
    public void setNewMember(IMemberDto member, IAddressDto address)
    {
        try
        {
            service.setNewMember(member, address);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IDepartmentDto> getDepartments()
    {
        try
        {
            return service.getDepartments();
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
    {
        try
        {
            return service.getClubTeams(clubTeams);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList)
    {
        try
        {
            service.setNewTrainer(member, address, clubTeamList);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList)
    {
        try
        {
            service.setNewPlayer(member, address, clubTeamList);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList)
    {
        try
        {
            return service.getTypeOfSports(typOfSportsList);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
    {
        try
        {
            return service.getClubTeamsByTypeOfSport(sport);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
    {
        try
        {
            return service.getAllSports();
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId) {
        try {
            return service.getRoles(memberId);
        } catch (RemoteException ex) {
            Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
