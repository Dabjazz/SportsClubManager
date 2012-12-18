/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb;

import contract.ejb.business.*;
import contract.rmi.services.*;
import javax.ejb.Remote;

/**
 this class provides the server-side services via rmi

 @author Lins Christian (christian.lins87@gmail.com)
 */
@Remote
public interface IEJBServiceFactoryRemote
{
    //TODO change all to ejb remote
    // 6 fixed by chris (others by dominik)
    
    public IAddMatchResultsRemote getAddMatchResultsService();

    
    public IAddMemberToTeamRemote getAddMemberToTeamService();

    public IChangeCompetitionTeamRemote getChangeCompetitionTeamService();

    public INewCompetitionRemote getNewCompetitionService();

    public INewMemberRemote getNewMemberService();

    public ISearchChangeMemberRemote getSearchChangeMemberService();

    public IShowCompetitionRemote getShowCompetitionService();

    public ILoginRemote getLoginService();

    public IMembershipRemote getMembershipService();

    public IAddressRemote getAddressService();

    public IPermissionControllerRemote getPermissionController();
}
