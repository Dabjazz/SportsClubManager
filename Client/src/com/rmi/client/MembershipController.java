/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client;

import contract.dto.*;
import contract.rmi.services.*;
import contract.useCaseController.IMembershipController;
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
    public List<IRoleDto> getRoles(Integer id)
    {
        return service.getRoles(id);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports)
    {
        return service.getTypeOfSports(sports);
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> playerList)
    {
        return service.getClubTeams(playerList);
    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
    {
        return service.getAllSports();
    }
}
