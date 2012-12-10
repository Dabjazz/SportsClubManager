/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient.controller;

import javamessaging.stubs.*;

/**
 @author Thomas
 */
public class AddPlayerToClubTeamController
{
    public void addPlayerToClubTeam(IClubTeamDto clubTeam, IPlayerDto player)
    {
              System.out.println("Added " + player + " to " + clubTeam);
}     
}
