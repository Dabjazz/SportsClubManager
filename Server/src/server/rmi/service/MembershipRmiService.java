/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.service;

import contract.dto.*;
import contract.rmi.services.*;
import contract.useCaseController.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        List<ITypeOfSportDto> list = new LinkedList<>();
       
        try {
            list = MembershipController.getInstance().getTypeOfSports(sports);
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipRmiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
    {
        List<ITypeOfSportDto> list = new LinkedList<>();
        try {
            list =  MembershipController.getInstance().getAllSports();
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipRmiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<IRoleDto> getRoles(Integer id)
    {
        List<IRoleDto> list = new LinkedList<>();
        try {
            list = MembershipController.getInstance().getRoles(id);
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipRmiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> playerList)
    {
        List<IClubTeamDto> list = new LinkedList<>();
        try {
            list =  MembershipController.getInstance().getClubTeams(playerList);
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipRmiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public IRoleDto setRole(IMemberDto member, String departmentHead, boolean selected)
    {
        IRoleDto setRole = null;
        try {
            setRole = MembershipController.getInstance().setRole(member, departmentHead, selected);
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipRmiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return setRole;
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport) throws RemoteException {
        try {
            return MembershipController.getInstance().getClubTeamsByTypeOfSport(sport);
            
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipRmiService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
