package contract.useCaseController;

import contract.dto.*;
import java.util.List;

/**

 @author Lucia
 */
public interface INewMember
{
    void setNewMember(IMemberDto member, IAddressDto address);

    List<IDepartmentDto> getDepartments();

    List<IClubTeamDto> getClubTeams(List<Integer> clubTeams);

    List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList);
    
    List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport);

    void setNewMember(IMemberDto member, IAddressDto address, IDepartmentDto department, IClubTeamDto clubTeam, IRoleDto role);
}
