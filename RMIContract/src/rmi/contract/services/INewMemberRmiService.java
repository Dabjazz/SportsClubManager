package rmi.contract.services;

import java.util.List;
import dto.contract.*;

/**
 *
 * @author Lucia
 */
public interface INewMemberRmiServices extends INewMember implements Remote{
    
    void setNewMember(IMember member, IAddress address);

    List<IDepartment> getDepartments();  
    List<IClubTeam> getClubTeams(List<Integer> clubTeams);
    
    void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role);
    
}
