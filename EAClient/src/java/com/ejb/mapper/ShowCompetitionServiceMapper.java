/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.*;
import contract.ejb.business.IShowCompetitionRemote;
import contract.useCaseController.IShowCompetitionController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class ShowCompetitionServiceMapper
        implements IShowCompetitionController {

    private IShowCompetitionRemote service;

//    public ShowCompetitionServiceMapper(IShowCompetitionRemote service) {
//        this.service = service;
//    }
    
    public ShowCompetitionServiceMapper()
    {
        this.service = lookupShowCompetitionBeanRemote();
    }
    
    @Override
    public List<ICompetitionDto> getCompetitions() {

        return service.getCompetitions();

    }

    @Override
    public List<IMatchDto> getMatchs(List<Integer> matches) {

        return service.getMatchs(matches);

    }

    @Override
    public List<IPlayerDto> getPlayer(IClubTeamDto team) {


        return service.getPlayer(team);

    }

    @Override
    public ITeamDto getTeam(Integer hometeam) {

        return service.getTeam(hometeam);

    }

    @Override
    public IClubTeamDto getClubTeam(Integer hometeam) {

        return service.getClubTeam(hometeam);

    }

    @Override
    public IMatchresultDto getMatchresult(Integer matchresult) {
        return service.getMatchresult(matchresult);

    }

    private IShowCompetitionRemote lookupShowCompetitionBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (IShowCompetitionRemote) c.lookup("java:comp/env/ShowCompetitionBean");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
