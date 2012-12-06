/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.*;
import contract.ejb.business.ISearchChangeMemberRemote;
import contract.useCaseController.ISearchChangeMemberController;
import java.util.*;

/**
 * @author Thomas
 */
public class SearchChangeMemberServiceMapper
        implements ISearchChangeMemberController {

    private ISearchChangeMemberRemote service;

    public SearchChangeMemberServiceMapper(ISearchChangeMemberRemote service) {
        this.service = service;
    }

    @Override
    public List<IMemberDto> getMatchingMembers(String searchInput) {

        return service.getMatchingMembers(searchInput);

    }

    @Override
    public IMemberDto getMember(Integer id) {

        return service.getMember(id);

    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId) {

        return service.getRoles(memberId);

    }

    @Override
    public IDepartmentDto getDepartment(Integer memberId) {

        return service.getDepartment(memberId);

    }

    @Override
    public IAddressDto getAddress(Integer addressId) {

        return service.getAddress(addressId);

    }

    @Override
    public ICountryDto getCountry(Integer countryID) {

        return service.getCountry(countryID);

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
    public void setNewMember(IMemberDto member, IAddressDto address) {

        service.setNewMember(member, address);

    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam) {

        service.setNewTrainer(member, address, clubTeam);

    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam) {

        service.setNewPlayer(member, address, clubTeam);

    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sportsList) {

        return service.getTypeOfSports(sportsList);

    }

    @Override
    public IMemberDto getSelectedMember() {

        return service.getSelectedMember();

    }

    @Override
    public void setSelectedMember(IMemberDto selectedMember) {
        service.setSelectedMember(selectedMember);

    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport) {

        return service.getClubTeamsByTypeOfSport(sport);

    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports() {

        return service.getTypeOfSports();

    }
}
