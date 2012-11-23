/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.List;

/**

 @author Thomas
 */
public interface IDepartmentDto
        extends IDto
{
    List<Integer> getClubTeamList();

    Integer getDepartmentHead();

    List<Integer> getTypeOfSportList();

    String getDescription();

    String getName();

    void setClubTeamList(List<Integer> clubTeamList);

    void setDepartmentHead(Integer departmentHead);

    void setTypeOfSportList(List<Integer> departmenthasTypeOfSportList);

    void setDescription(String description);

    void setName(String name);
}
