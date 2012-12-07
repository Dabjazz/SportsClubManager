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
        return new NewCompetitionServiceMapper(ejbFactory.getNewCompetitionService());
    }

    @Override
    public INewMemberController getNewMemberController() throws ServiceNotAvailableException
    {
        return new NewMemberServiceMapper(ejbFactory.getNewMemberService());
    }

    @Override
    public ISearchChangeMemberController getSearchChangeMemberController() throws ServiceNotAvailableException
    {
        return new SearchChangeMemberServiceMapper(ejbFactory.getSearchChangeMemberService());
    }

    @Override
    public IShowCompetitionController getShowCompetitionController() throws ServiceNotAvailableException
    {
        return new ShowCompetitionServiceMapper(ejbFactory.getShowCompetitionService());
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
        return new PermissionControllerServiceMapper(ejbFactory.getPermissionController());
    }

    
}
