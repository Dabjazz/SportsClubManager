/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.domain;

import java.util.*;
import javax.xml.bind.annotation.*;

/**

 @author Thomas
 */
public interface ILeague extends IDomain
{
    String getDescription();

    String getName();

    List<ITeam> getTeamList();
    
    List<ICompetition> getCompetitions();
    
    ITypeOfSport getTypeOfSport();
    
    void setTypeOfSport(ITypeOfSport sport);
    
    void setCompetitions(List<ICompetition> competitions);

    void setDescription(String description);

    void setName(String name);

    void setTeamList(List<ITeam> teamList);
}
