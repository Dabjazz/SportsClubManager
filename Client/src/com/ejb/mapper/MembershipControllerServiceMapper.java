/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IRoleDto;
import contract.dto.ITypeOfSportDto;
import contract.ejb.business.IMembershipRemote;
import contract.useCaseController.IMembershipController;
import contract.useCaseController.NetworkFailureException;
import java.util.List;

/**

 @author Thomas
 */
public class MembershipControllerServiceMapper
        implements IMembershipController
{
    private IMembershipRemote service;

    public MembershipControllerServiceMapper(IMembershipRemote service)
    {
        this.service = service;
    }

    @Override
    public List<IRoleDto> getRoles(Integer id)
            throws NetworkFailureException
    {
        return service.getRoles(id);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports)
            throws NetworkFailureException
    {
       return service.getTypeOfSports(sports);
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> playerList)
            throws NetworkFailureException
    {
        return service.getClubTeams(playerList);
    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
            throws NetworkFailureException
    {
        return service.getAllSports();
    }

    @Override
    public IRoleDto setRole(IMemberDto member, String departmentHead, boolean selected)
            throws NetworkFailureException
    {
       return service.setRole(member, departmentHead, selected);
    }
}
