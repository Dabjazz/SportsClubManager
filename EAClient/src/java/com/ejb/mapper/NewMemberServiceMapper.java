/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.*;
import contract.ejb.business.INewMemberRemote;
import contract.useCaseController.INewMemberController;
import java.util.List;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewMemberServiceMapper
        implements INewMemberController {

    private INewMemberRemote service;

    public NewMemberServiceMapper(INewMemberRemote service) {
        this.service = service;
    }

    @Override
    public void setNewMember(IMemberDto member, IAddressDto address) {

        service.setNewMember(member, address);

    }

    @Override
    public List<IDepartmentDto> getDepartments() {

        return service.getDepartments();

    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams) {

        return service.getClubTeams(clubTeams);

    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList) {

        service.setNewTrainer(member, address, clubTeamList);

    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList) {

        service.setNewPlayer(member, address, clubTeamList);

    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList) {
        return service.getTypeOfSports(typOfSportsList);

    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport) {

        return service.getClubTeamsByTypeOfSport(sport);

    }

    @Override
    public List<ITypeOfSportDto> getAllSports() {

        return service.getAllSports();

    }
}
