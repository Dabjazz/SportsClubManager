/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi;

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
import contract.rmi.IRmiServiceFactory;
import contract.rmi.services.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClientFactory
        extends UnicastRemoteObject
        implements IRmiServiceFactory
{
    public RmiServiceClientFactory()
            throws RemoteException
    {
        super();
    }

    @Override
    public contract.rmi.services.IAddMatchResultsRmiService getAddMatchResultsService()
            throws RemoteException
    {
        return new AddMatchResultsRmiService();
    }

    @Override
    public IChangeCompetitionTeamRmiService getChangeCompetitionTeamService()
            throws RemoteException
    {
        return new ChangeCompetitionTeamRmiService();
    }

    @Override
    public INewCompetitionRmiService getNewCompetitionService()
            throws RemoteException
    {
        return new NewCompetitionRmiService();
    }

    @Override
    public INewMemberRmiService getNewMemberService()
            throws RemoteException
    {
        return new NewMemberRmiService();
    }

    @Override
    public ISearchChangeMemberRmiService getSearchChangeMemberService()
            throws RemoteException
    {
        return new SearchChangeMemberRmiService();
    }

    @Override
    public IShowCompetitionRmiService getShowCompetitionService()
            throws RemoteException
    {
        return new ShowCompetitionRmiService();
    }

    @Override
    public ILoginRmiService getLoginService()
            throws RemoteException
    {
        return new LoginRmiService();
    }

    @Override
    public IMembershipRmiService getMembershipService()
            throws RemoteException
    {
        return new MembershipRmiService();
    }

    @Override
    public IAddressRmiService getAddressService()
            throws RemoteException
    {
        return new AddressRmiService();
    }

    @Override
    public IAddMemberToTeamRmiService getAddMemberToTeamRmiService()
            throws RemoteException
    {
        return new AddMemberToTeamRmiService();
    }

    @Override
    public IPermissionControllerService getPermissionController()
            throws RemoteException
    {
        return new PermissionControllerRmiService();
    }
}
