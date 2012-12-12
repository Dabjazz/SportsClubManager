/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.domain;

import java.util.List;

/**

 @author Thomas
 */
public interface IClubTeam
        extends ITeam
{
//    IClubTeam getParentClubTeam();
//
//    void setParentClubTeam(IClubTeam parentClubTeam);

    List<IDepartment> getDepartmentList();

    List<IPlayer> getPlayerList();

    List<ITrainer> getTrainerList();

    void setDepartmentList(List<IDepartment> departmentList);

    void setPlayerList(List<IPlayer> teamhasPlayerList);

    void setTrainerList(List<ITrainer> trainerList);
}
