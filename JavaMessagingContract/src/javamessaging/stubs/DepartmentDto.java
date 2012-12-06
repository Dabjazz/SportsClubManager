/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.stubs;

import java.util.List;

/*
 @author Thomas
 */
public class DepartmentDto
        implements IDepartmentDto
{
    private List<IClubTeamDto> clubTeamList;
    private String name;

    public DepartmentDto(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public List<IClubTeamDto> getClubTeamList()
    {
        return clubTeamList;
    }

    public void setClubTeamList(List<IClubTeamDto> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
    }
}
