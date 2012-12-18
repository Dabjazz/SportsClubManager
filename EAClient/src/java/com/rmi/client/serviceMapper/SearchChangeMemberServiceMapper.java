/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.*;
import contract.rmi.services.ISearchChangeMemberRmiService;
import contract.useCaseController.ISearchChangeMemberController;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;

/**
 @author Thomas
 */
public class SearchChangeMemberServiceMapper
        implements ISearchChangeMemberController
{
    private ISearchChangeMemberRmiService service;

    public SearchChangeMemberServiceMapper(ISearchChangeMemberRmiService service)
    {
        this.service = service;
    }

    @Override
    public List<IMemberDto> getMatchingMembers(String searchInput)
    {
        try
        {
            return service.getMatchingMembers(searchInput);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IMemberDto getMember(Integer id)
    {
        try
        {
            return service.getMember(id);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        try
        {
            return service.getRoles(memberId);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IDepartmentDto getDepartment(Integer memberId)
    {
        try
        {
            return service.getDepartment(memberId);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IAddressDto getAddress(Integer addressId)
    {
        try
        {
            return service.getAddress(addressId);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ICountryDto getCountry(Integer countryID)
    {
        try
        {
            return service.getCountry(countryID);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        try
        {
            service.setNewTrainer(member, address, clubTeam);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        try
        {
            service.setNewPlayer(member, address, clubTeam);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sportsList)
    {
        try
        {
            return service.getTypeOfSports(sportsList);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new LinkedList<ITypeOfSportDto>();
    }

    @Override
    public IMemberDto getSelectedMember()
    {
        IMemberDto m = null;
        try
        {
            m = service.getSelectedMember();
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    @Override
    public void setSelectedMember(IMemberDto selectedMember)
    {
        try
        {
            service.setSelectedMember(selectedMember);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports()
    {
        try
        {
            return service.getTypeOfSports();
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
