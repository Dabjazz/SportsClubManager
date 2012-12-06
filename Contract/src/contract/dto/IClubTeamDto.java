/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.List;

/**

 @author Thomas
 */
public interface IClubTeamDto
        extends ITeamDto
{
    Integer getParentClubTeam();

    void setParentClubTeam(Integer parentClubTeam);

    List<Integer> getDepartmentList();

    List<Integer> getPlayerList();

    List<Integer> getTrainerList();

    void setDepartmentList(List<Integer> departmentList);

    void setPlayerList(List<Integer> teamhasPlayerList);

    void setTrainerList(List<Integer> trainerList);
}
