/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.service;

import contract.dto.*;
import contract.rmi.services.ISearchChangeMemberRmiService;
import contract.useCaseController.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.SearchChangeMemberController;

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
        return SearchChangeMemberController.getInstance().getRoles(memberId);
    }

    @Override
    public IDepartmentDto getDepartment(Integer memberId)
    {
        return SearchChangeMemberController.getInstance().getDepartment(memberId);
    }

    @Override
    public IAddressDto getAddress(Integer addressId)
    {
        return SearchChangeMemberController.getInstance().getAddress(addressId);
    }

    @Override
    public List<IDepartmentDto> getDepartments()
    {
        return SearchChangeMemberController.getInstance().getDepartments();
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
    {
        return SearchChangeMemberController.getInstance().getClubTeams(clubTeams);
    }

    @Override
    public void setNewMember(IMemberDto member, IAddressDto address)
    {
        SearchChangeMemberController.getInstance().setNewMember(member, address);
    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        SearchChangeMemberController.getInstance().setNewPlayer(member, address, clubTeam);
    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        SearchChangeMemberController.getInstance().setNewTrainer(member, address, clubTeam);
    }

    @Override
    public IMemberDto getMember(int searchMember)
            throws RemoteException
    {
        return SearchChangeMemberController.getInstance().getMember(searchMember);
    }

    @Override
    public List<IMemberDto> getMatchingMembers(String searchInput)
    {
        return SearchChangeMemberController.getInstance().getMatchingMembers(searchInput);
    }

    @Override
    public ICountryDto getCountry(Integer countryID)
    {
        return SearchChangeMemberController.getInstance().getCountry(countryID);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sportsList)
            throws RemoteException
    {
        return SearchChangeMemberController.getInstance().getTypeOfSports(sportsList);
    }

    @Override
    public IMemberDto getSelectedMember()
    {
        return SearchChangeMemberController.getInstance().getSelectedMember();
    }

    @Override
    public void setSelectedMember(IMemberDto selectedMember)
    {
        SearchChangeMemberController.getInstance().setSelectedMember(selectedMember);
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
            throws RemoteException
    {
        return SearchChangeMemberController.getInstance().getClubTeamsByTypeOfSport(sport);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports()
            throws RemoteException
    {
        return SearchChangeMemberController.getInstance().getTypeOfSports();
    }
}
