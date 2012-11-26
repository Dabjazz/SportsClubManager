package contract.useCaseController;

import contract.dto.*;
import java.util.List;

/**

 @author Lucia
 */
public interface INewMember
{
    List<IDepartmentDto> getDepartments();

    List<IClubTeamDto> getClubTeams(List<Integer> clubTeams);

    List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList);

    List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport);

    void setNewMember(IMemberDto member, IAddressDto address);

    void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList);

    void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList);
    
    List<ITypeOfSportDto> getAllSports();
}
