/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.ICompetitionDto;
import contract.dto.IMatchDto;
import contract.dto.IMatchresultDto;
import contract.dto.ITeamDto;
import contract.ejb.business.IAddMatchResultsRemote;
import contract.useCaseController.IAddMatchResultsController;
import java.util.List;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class AddMatchResultsServiceMapper
        implements IAddMatchResultsController
{
    private IAddMatchResultsRemote service;

    public AddMatchResultsServiceMapper(IAddMatchResultsRemote service)
    {
        this.service = service;
    }

    @Override
    public List<ICompetitionDto> getCompetitionList()
    {
        return service.getCompetitionList();
    }

    @Override
    public List<ITeamDto> getTeamList(List<Integer> team)
    {
        return service.getTeamList(team);
    }

    @Override
    public List<IMatchDto> getMatchList(List<Integer> match)
    {
       return service.getMatchList(match);
    }

    @Override
    public void setMatchResult(IMatchDto match, IMatchresultDto matchresult)
    {
        service.setMatchResult(match, matchresult);
    }

    @Override
    public ITeamDto getTeam(Integer hometeam)
    {
       return service.getTeam(hometeam);
    }
}
