/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.*;
import contract.ejb.business.INewCompetitionRemote;
import contract.useCaseController.INewCompetitionController;
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
public class NewCompetitionServiceMapper
        implements INewCompetitionController {

    private INewCompetitionRemote service;

//    public NewCompetitionServiceMapper(INewCompetitionRemote service) {
//        this.service = service;
//    }

    public NewCompetitionServiceMapper() {
        this.service = lookupNewCompetitionBeanRemote();
    }
    
    @Override
    public void setCompetition(ICompetitionDto competition, IAddressDto address, ICountryDto country, List<IMatchDto> matchList)
    {
        service.setCompetition(competition, address, country, matchList);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(Integer memberId)
    {
        return service.getTypeOfSports(memberId);
    }

    @Override
    public List<ITeamDto> getTeams(ITypeOfSportDto sport)
    {
        return service.getTeams(sport);
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        return service.getRoles(memberId);
    }

    private INewCompetitionRemote lookupNewCompetitionBeanRemote()
    {
        try
        {
            Context c = new InitialContext();
            return (INewCompetitionRemote) c.lookup("java:comp/env/NewCompetitionBean");
        } catch (NamingException ne)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
