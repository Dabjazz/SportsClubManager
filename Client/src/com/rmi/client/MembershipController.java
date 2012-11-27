/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client;

import contract.dto.*;
import contract.rmi.services.*;
import contract.useCaseController.IMembershipController;
import contract.useCaseController.NetworkFailureException;
import java.rmi.RemoteException;
import java.util.*;

/**

 @author Thomas
 */
public class MembershipController
        implements IMembershipController
{
    private IMembershipRmiService service;

    public void setService(IMembershipRmiService service)
    {
        this.service = service;
    }

    @Override
    public List<IRoleDto> getRoles(Integer id) throws NetworkFailureException 
    {
        try {
            return service.getRoles(id);
        } catch (RemoteException ex) {
            throw new NetworkFailureException(ex.getMessage());
        }
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports) throws NetworkFailureException
    {
        try {
            return service.getTypeOfSports(sports);
        } catch (RemoteException ex) {
            throw new NetworkFailureException(ex.getMessage());
        }
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> playerList) throws NetworkFailureException
    {
        try {
            return service.getClubTeams(playerList);
        } catch (RemoteException ex) {
            throw new NetworkFailureException(ex.getMessage());
        }
    }

    @Override
    public List<ITypeOfSportDto> getAllSports() throws NetworkFailureException
    {
        try {
            return service.getAllSports();
        } catch (RemoteException ex) {
            throw new NetworkFailureException(ex.getMessage());
        }
    }

    @Override
    public IRoleDto setRole(IMemberDto member, String departmentHead, boolean selected) throws NetworkFailureException {
        try {
            return service.setRole(member, departmentHead, selected);
        } catch (RemoteException ex) {
            throw new NetworkFailureException(ex.getMessage());
        }
    }

    
}
