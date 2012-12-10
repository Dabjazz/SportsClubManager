/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient.controller;

import javamessaging.stubs.*;

/**
 @author Thomas
 */
public class DeleteMemberFromClubTeam
{
    public void deleteMemberFromClubTeam(IClubTeamDto clubTeam, IMemberDto member)
    {
        System.out.println("Member " + member.getUsername() + " removed from team " + clubTeam.getName());
    }
}
