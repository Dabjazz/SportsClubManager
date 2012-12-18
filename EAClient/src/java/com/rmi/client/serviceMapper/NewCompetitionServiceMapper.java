/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.serviceMapper;

import contract.dto.*;
import contract.rmi.services.INewCompetitionRmiService;
import contract.useCaseController.INewCompetitionController;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewCompetitionServiceMapper
        implements INewCompetitionController
{
    private INewCompetitionRmiService service;

    public NewCompetitionServiceMapper(INewCompetitionRmiService service)
    {
        this.service = service;
    }

    @Override
    public void setCompetition(ICompetitionDto competition, IMemberDto member)
    {
        try
        {
            service.setCompetition(competition, member);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ITeamDto> getTeams()
    {
        try
        {
            return service.getTeams();
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
