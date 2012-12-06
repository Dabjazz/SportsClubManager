/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.*;
import contract.ejb.business.INewCompetitionRemote;
import contract.useCaseController.INewCompetitionController;
import java.util.List;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewCompetitionServiceMapper
        implements INewCompetitionController {

    private INewCompetitionRemote service;

    public NewCompetitionServiceMapper(INewCompetitionRemote service) {
        this.service = service;
    }

    @Override
    public void setCompetition(ICompetitionDto competition, IMemberDto member) {
        service.setCompetition(competition, member);
    }

    @Override
    public List<ITeamDto> getTeams() {

        return service.getTeams();

    }
}
