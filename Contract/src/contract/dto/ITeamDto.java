/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import contract.domain.ILeague;
import java.util.List;

/**

 @author Thomas
 */
public interface ITeamDto
        extends IDto
{
    List<Integer> getCompetitionList();

    String getDescription();

    Integer getLeague();

    List<Integer> getMatchList();

    String getName();

    void setCompetitionList(List<Integer> competitionList);

    void setDescription(String description);

    void setLeague(Integer league);

    void setMatchList(List<Integer> matchList);

    void setName(String name);

    public void setLeague(ILeague league);
}
