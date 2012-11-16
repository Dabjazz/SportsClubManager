/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface ITypeOfSport extends IDomain
{
    List<ICompetition> getCompetitions();
    
    void setCompetitions(List<ICompetition> competitions);
    
    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<IPlayer> getPlayerList();

    void setPlayerList(List<IPlayer> playerList);
}
