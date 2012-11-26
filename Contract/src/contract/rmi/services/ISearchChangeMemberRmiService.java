/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.*;
import contract.useCaseController.*;
import java.rmi.*;
import java.util.List;

/**

 @author Lucia
 */
public interface ISearchChangeMemberRmiService
        extends Remote
{
    IMemberDto getMember(int searchMember)
            throws RemoteException;

    List<IRoleDto> getRoles(Integer memberId)
            throws RemoteException;

    IDepartmentDto getDepartment(Integer memberId)
            throws RemoteException;

    IAddressDto getAddress(Integer addressId)
            throws RemoteException;

    List<IDepartmentDto> getDepartments()
            throws RemoteException;

    List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
            throws RemoteException;

    void setNewMember(IMemberDto member, IAddressDto address)
            throws RemoteException;

    void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
            throws RemoteException;

    void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
            throws RemoteException;

    List<IMemberDto> getMatchingMembers(String searchInput)
            throws RemoteException;   //find all members, matching the searched value 

    ICountryDto getCountry(Integer countryID)
            throws RemoteException;     //new added

    List<ITypeOfSportDto> getTypeOfSports(List<Integer> sportsList)
            throws RemoteException;     //new added

    IMemberDto getSelectedMember()
            throws RemoteException;     //new added

    void setSelectedMember(IMemberDto selectedMember)
            throws RemoteException;     //new added

    List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
            throws RemoteException;     //new added

    List<ITypeOfSportDto> getTypeOfSports()
            throws RemoteException;     //new added

    IMembershipController getMembershipController()
            throws RemoteException;

    IMemberController getMemberController()
            throws RemoteException;
}
