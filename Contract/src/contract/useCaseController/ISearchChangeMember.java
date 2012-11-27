/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.*;
import java.util.List;

/**
 @author Lucia
 */
public interface ISearchChangeMember
{
    List<IMemberDto> getMatchingMembers(String searchInput);   //find all members, matching the searched value 

    IMemberDto getMember(/*old :String searchMember*/Integer id); //best if MemberID could be used!?

    List<IRoleDto> getRoles(Integer memberId);

    IDepartmentDto getDepartment(Integer memberId);

    IAddressDto getAddress(Integer addressId);

    ICountryDto getCountry(Integer countryID);     //new added

    List<IDepartmentDto> getDepartments();

    List<IClubTeamDto> getClubTeams(List<Integer> clubTeams);

    List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport);

    List<ITypeOfSportDto> getTypeOfSports(List<Integer> sportsList);

    void setNewMember(IMemberDto member, IAddressDto address);

    void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam);

    void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam);

    void setSelectedMember(IMemberDto get);

    IMemberDto getSelectedMember();

    List<ITypeOfSportDto> getTypeOfSports();

    IMemberController getMemberController();

    IMembershipController getMembershipController();
}
