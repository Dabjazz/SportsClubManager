/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.*;
import java.util.List;
import javax.ejb.Remote;

/**

 @author Lucia
 */
@Remote
public interface IAddMatchResultsRemote
{
    List<ICompetitionDto> getCompetitionList();
    
    List<ITeamDto> getTeamList(List<Integer> team);

    List<IMatchDto> getMatchList(List<Integer> match);

    void setMatchResult(IMatchDto match, IMatchresultDto matchresult);

    public ITeamDto getTeam(Integer hometeam);
    
    List<IRoleDto> getRoles(Integer memberId);
}
