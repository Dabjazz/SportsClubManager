/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.*;
import contract.rmi.services.ISearchChangeMemberRmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.SearchChangeMember;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class SearchChangeMemberRmiService
        extends UnicastRemoteObject
        implements ISearchChangeMemberRmiService
{
    public SearchChangeMemberRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        return SearchChangeMember.getInstance().getRoles(memberId);
    }

    @Override
    public IDepartmentDto getDepartment(Integer memberId)
    {
        return SearchChangeMember.getInstance().getDepartment(memberId);
    }

    @Override
    public IAddressDto getAddress(Integer addressId)
    {
        return SearchChangeMember.getInstance().getAddress(addressId);
    }

    @Override
    public List<IDepartmentDto> getDepartments()
    {
        return SearchChangeMember.getInstance().getDepartments();
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
    {
        return SearchChangeMember.getInstance().getClubTeams(clubTeams);
    }

    @Override
    public void setNewMember(IMemberDto member, IAddressDto address)
    {
        SearchChangeMember.getInstance().setNewMember(member, address);
    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        SearchChangeMember.getInstance().setNewPlayer(member, address, clubTeam);
    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        SearchChangeMember.getInstance().setNewTrainer(member, address, clubTeam);
    }

    @Override
    public IMemberDto getMember(int searchMember)
            throws RemoteException
    {
        return SearchChangeMember.getInstance().getMember(searchMember);
    }

    @Override
    public List<IMemberDto> getMatchingMembers(String searchInput)
    {
        return SearchChangeMember.getInstance().getMatchingMembers(searchInput);
    }

    @Override
    public ICountryDto getCountry(Integer countryID)
    {
        return SearchChangeMember.getInstance().getCountry(countryID);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sportsList)
            throws RemoteException
    {
        return SearchChangeMember.getInstance().getTypeOfSports(sportsList);
    }

    @Override
    public IMemberDto getSelectedMember()
    {
        return SearchChangeMember.getInstance().getSelectedMember();
    }

    @Override
    public void setSelectedMember(IMemberDto selectedMember)
    {
        SearchChangeMember.getInstance().setSelectedMember(selectedMember);
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
            throws RemoteException
    {
        return SearchChangeMember.getInstance().getClubTeamsByTypeOfSport(sport);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports()
            throws RemoteException
    {
        return SearchChangeMember.getInstance().getTypeOfSports();
    }
}
