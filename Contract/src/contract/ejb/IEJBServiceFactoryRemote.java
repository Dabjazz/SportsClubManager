/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb;

import contract.ejb.business.IAddMatchResultsRemote;
import contract.rmi.services.*;
import javax.ejb.Remote;

/**
 this class provides the server-side services via rmi

 @author Lins Christian (christian.lins87@gmail.com)
 */
@Remote
public interface IEJBServiceFactoryRemote
{
    public IAddMatchResultsRemote getAddMatchResultsService();

    //TODO change all to ejb remote
    public IAddMemberToTeamRmiService getAddMemberToTeamRmiService();

    public IChangeCompetitionTeamRmiService getChangeCompetitionTeamService();

    public INewCompetitionRmiService getNewCompetitionService();

    public INewMemberRmiService getNewMemberService();

    public ISearchChangeMemberRmiService getSearchChangeMemberService();

    public IShowCompetitionRmiService getShowCompetitionService();

    ILoginRmiService getLoginService();

    IMembershipRmiService getMembershipService();

    IAddressRmiService getAddressService();

     IPermissionControllerService getPermissionController();
}
