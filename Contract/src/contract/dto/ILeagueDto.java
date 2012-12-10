/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.*;

/**

 @author Thomas
 */
public interface ILeagueDto
        extends IDto
{
    String getDescription();

    String getName();

    List<Integer> getTeamList();

    List<Integer> getCompetitions();
    
    ITypeOfSportDto getTypeOfSport();
    
    void setTypeOfSport(ITypeOfSportDto typeOfSport);

    void setCompetitions(List<Integer> competitions);

    void setDescription(String description);

    void setName(String name);

    void setTeamList(List<Integer> teamList);

    List<ICompetitionDto> getCompetitionsByDate(Date date);
}
