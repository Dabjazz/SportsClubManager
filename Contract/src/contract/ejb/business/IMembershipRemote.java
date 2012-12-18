/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IRoleDto;
import contract.dto.ITypeOfSportDto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface IMembershipRemote
{
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports);

    public List<ITypeOfSportDto> getAllSports();

    public List<IRoleDto> getRoles(Integer id);

    public List<IClubTeamDto> getClubTeams(List<Integer> playerList);
    
    public IRoleDto setRole(IMemberDto member, String departmentHead, boolean selected);
    
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport);
}
