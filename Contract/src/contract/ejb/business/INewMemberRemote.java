package contract.ejb.business;

import contract.dto.*;
import java.util.List;
import javax.ejb.Remote;

/**

 @author Lucia
 */
@Remote
public interface INewMemberRemote
{
    List<IDepartmentDto> getDepartments();

    List<IClubTeamDto> getClubTeams(List<Integer> clubTeams);

    void setNewMember(IMemberDto member, IAddressDto address);

    void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList);

    void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList);

    List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList);

    List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport);
    
    List<ITypeOfSportDto> getAllSports();
    
    List<IRoleDto> getRoles(Integer memberId);
}
