/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi;

import contract.rmi.RmiServiceClient;
import contract.rmi.services.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import server.rmi.controller.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClientFactory
        extends UnicastRemoteObject
        implements RmiServiceClient
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
}
