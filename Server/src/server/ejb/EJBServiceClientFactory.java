/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb;

import contract.ejb.IEJBServiceFactoryRemote;
import server.rmi.service.AddMatchResultsRmiService;
import server.rmi.service.AddMemberToTeamRmiService;
import server.rmi.service.SearchChangeMemberRmiService;
import server.rmi.service.NewMemberRmiService;
import server.rmi.service.ShowCompetitionRmiService;
import server.rmi.service.LoginRmiService;
import server.rmi.service.MembershipRmiService;
import server.rmi.service.AddressRmiService;
import server.rmi.service.PermissionControllerRmiService;
import server.rmi.service.ChangeCompetitionTeamRmiService;
import server.rmi.service.NewCompetitionRmiService;
import contract.rmi.services.*;
import javax.ejb.Singleton;
import server.ejb.beans.AddMatchResultsBean;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
@Singleton
public class EJBServiceClientFactory implements IEJBServiceFactoryRemote
{
    public EJBServiceClientFactory()
    {
        super();
    }

    @Override
    public contract.ejb.business.IAddMatchResultsRemote getAddMatchResultsService()
    {
        return new AddMatchResultsBean();
    }

//    @Override
//    public IChangeCompetitionTeamRmiService getChangeCompetitionTeamService()
//    {
//        return new ChangeCompetitionTeamRmiService();
//    }
//
//    @Override
//    public INewCompetitionRmiService getNewCompetitionService()
//    {
//        return new NewCompetitionRmiService();
//    }
//
//    @Override
//    public INewMemberRmiService getNewMemberService
//    {
//        return new NewMemberRmiService();
//    }
//
//    @Override
//    public ISearchChangeMemberRmiService getSearchChangeMemberService()
//    {
//        return new SearchChangeMemberRmiService();
//    }
//
//    @Override
//    public IShowCompetitionRmiService getShowCompetitionService()
//    {
//        return new ShowCompetitionRmiService();
//    }
//
//    @Override
//    public ILoginRmiService getLoginService()
//    {
//        return new LoginRmiService();
//    }
//
//    @Override
//    public IMembershipRmiService getMembershipService()
//    {
//        return new MembershipRmiService();
//    }
//
//    @Override
//    public IAddressRmiService getAddressService()
//    {
//        return new AddressRmiService();
//    }
//
//    @Override
//    public IAddMemberToTeamRmiService getAddMemberToTeamRmiService()
//    {
//        return new AddMemberToTeamRmiService();
//    }
//
//    @Override
//    public IPermissionControllerService getPermissionController()
//    {
//        return new PermissionControllerRmiService();
//    }

    @Override
    public IAddMemberToTeamRmiService getAddMemberToTeamRmiService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IChangeCompetitionTeamRmiService getChangeCompetitionTeamService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public INewCompetitionRmiService getNewCompetitionService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public INewMemberRmiService getNewMemberService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ISearchChangeMemberRmiService getSearchChangeMemberService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IShowCompetitionRmiService getShowCompetitionService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ILoginRmiService getLoginService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IMembershipRmiService getMembershipService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IAddressRmiService getAddressService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IPermissionControllerService getPermissionController()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
