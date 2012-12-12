/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.stubs;

import java.io.*;
import java.util.*;

/**

 @author Thomas
 */
public interface IClubTeamDto
        extends Serializable
{
    List<IPlayerDto> getPlayerList();

    void setPlayerList(List<IPlayerDto> playerList);

    String getName();
}
