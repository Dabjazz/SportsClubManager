/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb;

import contract.ejb.IEJBServiceFactoryRemote;
import contract.ejb.business.*;
import contract.rmi.services.*;
import javax.ejb.Singleton;
import server.ejb.beans.*;

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

    @Override
    public IChangeCompetitionTeamRemote getChangeCompetitionTeamService()
    {
        return new ChangeCompetitionTeamBean();
    }

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

//    @Override
//    public ISearchChangeMemberRmiService getSearchChangeMemberService()
//    {
//        return new SearchChangeMemberRmiService();
//    }

//    @Override
//    public IShowCompetitionRmiService getShowCompetitionService()
//    {
//        return new ShowCompetitionRmiService();
//    }

    @Override
    public ILoginRemote getLoginService()
    {
        return new LoginBean();
    }

    @Override
    public IMembershipRemote getMembershipService()
    {
        return new MembershipBean();
    }

    @Override
    public IAddressRemote getAddressService()
    {
        return new AddressBean();
    }

    @Override
    public IAddMemberToTeamRemote getAddMemberToTeamService()
    {
        return new AddMemberToTeamBean();
    }

//    @Override
//    public IPermissionControllerService getPermissionController()
//    {
//        return new PermissionControllerRmiService();
//    }

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
    public IPermissionControllerService getPermissionController()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
