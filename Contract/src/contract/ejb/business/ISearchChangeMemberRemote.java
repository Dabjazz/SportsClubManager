/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.*;
import contract.useCaseController.*;
import java.util.List;
import javax.ejb.Remote;

/**

 @author Lucia
 */
@Remote
public interface ISearchChangeMemberRemote
{
    IMemberDto getMember(int searchMember);

    List<IRoleDto> getRoles(Integer memberId);

    IDepartmentDto getDepartment(Integer memberId);

    IAddressDto getAddress(Integer addressId);

    List<IDepartmentDto> getDepartments();

    List<IClubTeamDto> getClubTeams(List<Integer> clubTeams);

    void setNewMember(IMemberDto member, IAddressDto address);

    void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam);

    void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam);

    List<IMemberDto> getMatchingMembers(String searchInput);   //find all members, matching the searched value 

    ICountryDto getCountry(Integer countryID);     //new added

    List<ITypeOfSportDto> getTypeOfSports(List<Integer> sportsList);     //new added

    IMemberDto getSelectedMember();     //new added

    void setSelectedMember(IMemberDto selectedMember);     //new added

    List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport);     //new added

    List<ITypeOfSportDto> getTypeOfSports();     //new added
}
