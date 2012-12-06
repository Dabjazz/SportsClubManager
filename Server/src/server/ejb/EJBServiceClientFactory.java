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
    public INewCompetitionRemote getNewCompetitionService() {
        return new NewCompetitionBean();
    }

    @Override
    public INewMemberRemote getNewMemberService() {
        return new NewMemberBean();
    }

    @Override
    public ISearchChangeMemberRemote getSearchChangeMemberService() {
        return new SearchChangeMemberBean();
    }

    @Override
    public IShowCompetitionRemote getShowCompetitionService() {
        return new ShowCompetitionBean();
    }

    @Override
    public IPermissionControllerRemote getPermissionController() {
        return new PermissionControllerBean();
    }



    
}
