/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.stubs;

import java.util.List;
import javamessaging.stubs.*;

/**

 @author Thomas
 */
public class ClubTeamDto
        implements IClubTeamDto
{
    private List<IPlayerDto> playerList;
    private String name;

    public ClubTeamDto(String name)
    {
        this.name = name;
    }

    @Override
    public List<IPlayerDto> getPlayerList()
    {
        return playerList;
    }

    @Override
    public void setPlayerList(List<IPlayerDto> playerList)
    {
        this.playerList = playerList;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
