/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.ServiceNotAvailableException;
import com.contract.IUseCaseControllerFactory;
import com.ejb.mapper.*;
import contract.useCaseController.*;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class EJBUseCaseControllerFactory implements IUseCaseControllerFactory
{
    //@EJB private static IEJBServiceFactoryRemote ejbFactory = lookupEJBServiceClientFactoryRemote(); // dependency injection
    
    @Override
    public IAddMatchResultsController getAddMatchResultsController() throws ServiceNotAvailableException
    {
        //return new AddMatchResultsServiceMapper(ejbFactory.getAddMatchResultsService());
        return new AddMatchResultsServiceMapper();
    }

    @Override
    public IAddMemberToTeamController getAddMemberToTeamController() throws ServiceNotAvailableException
    {
        //return new AddMemberToTeamServiceMapper(ejbFactory.getAddMemberToTeamService());
        return new AddMemberToTeamServiceMapper();
    }

    @Override
    public IChangeCompetitionTeamController getChangeCompetitionTeamController() throws ServiceNotAvailableException
    {
        //return new ChangeCompetitionTeamServiceMapper(ejbFactory.getChangeCompetitionTeamService());
        return new ChangeCompetitionTeamServiceMapper();
    }

    @Override
    public INewCompetitionController getNewCompetitionController() throws ServiceNotAvailableException
    {
        //return new NewCompetitionServiceMapper(ejbFactory.getNewCompetitionService());
        return new NewCompetitionServiceMapper();
    }

    @Override
    public INewMemberController getNewMemberController() throws ServiceNotAvailableException
    {
        //return new NewMemberServiceMapper(ejbFactory.getNewMemberService());
        return new NewMemberServiceMapper();
    }

    @Override
    public ISearchChangeMemberController getSearchChangeMemberController() throws ServiceNotAvailableException
    {
        //return new SearchChangeMemberServiceMapper(ejbFactory.getSearchChangeMemberService());
        return new SearchChangeMemberServiceMapper();
    }

    @Override
    public IShowCompetitionController getShowCompetitionController() throws ServiceNotAvailableException
    {
        //return new ShowCompetitionServiceMapper(ejbFactory.getShowCompetitionService());
        return new ShowCompetitionServiceMapper();
    }

    @Override
    public ILogin getLoginController() throws ServiceNotAvailableException
    {
        //return new LoginServiceMapper(ejbFactory.getLoginService());
        return new LoginServiceMapper();
    }

    @Override
    public IAddressController getAddressController() throws ServiceNotAvailableException
    {
        //return new AddressControllerServiceMapper(ejbFactory.getAddressService());
        return new AddressControllerServiceMapper();
    }

    @Override
    public IMembershipController getMembershipController() throws ServiceNotAvailableException
    {
//        return new MembershipControllerServiceMapper(ejbFactory.getMembershipService());
        return new MembershipControllerServiceMapper();
    }

    @Override
    public IPermissionController getPermissionController() throws ServiceNotAvailableException
    {
        //return new PermissionControllerServiceMapper(ejbFactory.getPermissionController());
        return new PermissionControllerServiceMapper();
    }

//    private static IEJBServiceFactoryRemote lookupEJBServiceClientFactoryRemote()
//    {
//        try
//        {
//            Context c = new InitialContext();
//            return (IEJBServiceFactoryRemote) c.lookup("java:comp/env/EJBServiceClientFactory");
//        } catch (NamingException ne)
//        {
//            throw new RuntimeException(ne);
//        }
//    }

}
