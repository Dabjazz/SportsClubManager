/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi;

import contract.rmi.services.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 this class provides the server-side services via rmi

 @author Lins Christian (christian.lins87@gmail.com)
 */
public interface RmiServiceClient
        extends Remote
{
    public IAddMatchResultsRmiService getAddMatchResultsService()
            throws RemoteException;

    public IChangeCompetitionTeamRmiService getChangeCompetitionTeamService()
            throws RemoteException;

    public INewCompetitionRmiService getNewCompetitionService()
            throws RemoteException;

    public INewMemberRmiService getNewMemberService()
            throws RemoteException;

    public ISearchChangeMemberRmiService getSearchChangeMemberService()
            throws RemoteException;

    public IShowCompetitionRmiService getShowCompetitionService()
            throws RemoteException;

    ILoginRmiService getLoginService()
            throws RemoteException;

    IMembershipRmiService getMembershipService()
            throws RemoteException;

    IAddressRmiService getAddressService()
            throws RemoteException;
}
