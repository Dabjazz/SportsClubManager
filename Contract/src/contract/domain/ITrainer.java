/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.domain;

import java.util.List;

/**

 @author Thomas
 */
public interface ITrainer
        extends IRole
{
    List<IClubTeam> getClubTeamList();

    void setClubTeamList(List<IClubTeam> clubTeamList);

    List<ITypeOfSport> getTypeOfSportList();

    void setTypeOfSportList(List<ITypeOfSport> typeOfSportList);
}
