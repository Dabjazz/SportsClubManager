/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.*;
import contract.rmi.services.*;
import contract.useCaseController.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import server.useCaseController.*;

/**

 @author Thomas
 */
public class MembershipRmiService
        extends UnicastRemoteObject
        implements IMembershipRmiService
{
    public MembershipRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports)
    {
        return MembershipController.getInstance().getTypeOfSports(sports);
    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
    {
        return MembershipController.getInstance().getAllSports();
    }

    @Override
    public List<IRoleDto> getRoles(Integer id)
    {
        return MembershipController.getInstance().getRoles(id);
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> playerList)
    {
        return MembershipController.getInstance().getClubTeams(playerList);
    }
}
