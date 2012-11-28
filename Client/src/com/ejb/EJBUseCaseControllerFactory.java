/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.ServiceNotAvailableException;
import com.contract.IUseCaseControllerFactory;
import contract.ejb.IEJBServiceFactoryRemote;
import contract.ejb.business.IAddMatchResultsRemote;
import contract.useCaseController.*;
import javax.ejb.EJB;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class EJBUseCaseControllerFactory implements IUseCaseControllerFactory
{
    @EJB private static IEJBServiceFactoryRemote ejbFactory; // dependency injection
    

    @Override
    public IAddMatchResultsController getAddMatchResultsController() throws ServiceNotAvailableException
    {
        IAddMatchResultsRemote addMatchResultsService = ejbFactory.getAddMatchResultsService();
        
        // TODO map to client interface and return (like rmi mapper)
        return null;
        
    }

    @Override
    public IAddMemberToTeamController getAddMemberToTeamController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IChangeCompetitionTeamController getChangeCompetitionTeamController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public INewCompetitionController getNewCompetitionController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public INewMemberController getNewMemberController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ISearchChangeMemberController getSearchChangeMemberController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IShowCompetitionController getShowCompetitionController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ILogin getLoginController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IAddressController getAddressController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IMembershipController getMembershipController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IPermissionController getPermissionController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
