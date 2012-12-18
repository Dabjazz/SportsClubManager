/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.IClubTeamDto;
import contract.dto.ICompetitionDto;
import contract.dto.IPlayerDto;
import contract.dto.IRoleDto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface IChangeCompetitionTeamRemote
{
    List<ICompetitionDto> getCompetition();

    List<IClubTeamDto> getClubTeams(List<Integer> Teams);

    void setCompetitonTeam(ICompetitionDto competition, IClubTeamDto oldTeam, IClubTeamDto newTeam);

    IClubTeamDto getCompetitionTeam(IClubTeamDto team);       //get team for competition from this team

    List<IPlayerDto> getPlayers(List<Integer> players);    //get single players
    
    List<IRoleDto> getRoles(Integer memberId);
}
