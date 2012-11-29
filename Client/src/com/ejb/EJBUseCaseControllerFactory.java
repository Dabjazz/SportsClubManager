/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.ServiceNotAvailableException;
import com.contract.IUseCaseControllerFactory;
import com.ejb.mapper.*;
import contract.ejb.IEJBServiceFactoryRemote;
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
        return new AddMatchResultsServiceMapper(ejbFactory.getAddMatchResultsService());
    }

    @Override
    public IAddMemberToTeamController getAddMemberToTeamController() throws ServiceNotAvailableException
    {
        return new AddMemberToTeamServiceMapper(ejbFactory.getAddMemberToTeamService());
    }

    @Override
    public IChangeCompetitionTeamController getChangeCompetitionTeamController() throws ServiceNotAvailableException
    {
        return new ChangeCompetitionTeamServiceMapper(ejbFactory.getChangeCompetitionTeamService());
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
        return new LoginServiceMapper(ejbFactory.getLoginService());
    }

    @Override
    public IAddressController getAddressController() throws ServiceNotAvailableException
    {
        return new AddressControllerServiceMapper(ejbFactory.getAddressService());
    }

    @Override
    public IMembershipController getMembershipController() throws ServiceNotAvailableException
    {
        return new MembershipControllerServiceMapper(ejbFactory.getMembershipService());
    }

    @Override
    public IPermissionController getPermissionController() throws ServiceNotAvailableException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
