/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.ICompetitionDto;
import contract.dto.IMatchDto;
import contract.dto.IMatchresultDto;
import contract.dto.ITeamDto;
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
}
