/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client;

import com.ServiceClient;
import com.ServiceNotAvailableException;
import com.CommunicationProblemException;
import com.rmi.client.mapper.*;
import contract.rmi.RmiServiceClient;
import contract.rmi.services.*;
import contract.useCaseController.*;
import java.net.MalformedURLException;
import java.rmi.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClientImpl
        implements ServiceClient
{
    private String host;
    private int port;
    private RmiServiceClient rmiServiceClient;

    public RmiServiceClientImpl(String host, int port)
            throws CommunicationProblemException
    {
        this.host = host;
        this.port = port;
        init();
    }

    private void init()
            throws CommunicationProblemException
    {
        try
        {
            rmiServiceClient = (RmiServiceClient) Naming.lookup("rmi://" + host + ":" + port + "/CommunicationFactory");
            System.out.println("RMI service client fetched");
        }
        catch (NotBoundException | MalformedURLException | RemoteException ex)
        {
            ex.printStackTrace();
            throw new CommunicationProblemException(host, ex);
        }
    }

    @Override
    public IAddMatchResults getAddMatchResultsService()
            throws ServiceNotAvailableException
    {
        try
        {
            IAddMatchResultsRmiService rmiService = rmiServiceClient.getAddMatchResultsService();
            AddMatchResultsServiceMapper map = new AddMatchResultsServiceMapper();
            return map.getService(rmiService);
        }
        catch (RemoteException ex)
        {
            ex.printStackTrace();
            throw new ServiceNotAvailableException("Service AddMatchResults not available", ex);
        }
    }

    @Override
    public IChangeCompetitionTeam getChangeCompetitionTeamService()
            throws ServiceNotAvailableException
    {
        try
        {
            IChangeCompetitionTeamRmiService rmiService = rmiServiceClient.getChangeCompetitionTeamService();
            ChangeCompetitionTeamServiceMapper map = new ChangeCompetitionTeamServiceMapper();
            return map.getService(rmiService);
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service ChangeCompetitionTeam not available", ex);
        }
    }

    @Override
    public INewCompetition getNewCompetitionService()
            throws ServiceNotAvailableException
    {
        try
        {
            INewCompetitionRmiService rmiService = rmiServiceClient.getNewCompetitionService();
            NewCompetitionServiceMapper map = new NewCompetitionServiceMapper();
            return map.getService(rmiService);
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service NewCompetitionService not available", ex);
        }
    }

    @Override
    public INewMember getNewMemberService()
            throws ServiceNotAvailableException
    {
        try
        {
            INewMemberRmiService rmiService = rmiServiceClient.getNewMemberService();
            NewMemberServiceMapper map = new NewMemberServiceMapper();
            return map.getService(rmiService);
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service NewMemberService not available", ex);
        }
    }

    @Override
    public ISearchChangeMember getSearchChangeMemberService()
            throws ServiceNotAvailableException
    {
        try
        {
            ISearchChangeMemberRmiService rmiService = rmiServiceClient.getSearchChangeMemberService();
            SearchChangeMemberServiceMapper map = new SearchChangeMemberServiceMapper();
            return map.getService(rmiService);
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service SearchChangeMember not available", ex);
        }
    }

    @Override
    public IShowCompetition getShowCompetitionService()
            throws ServiceNotAvailableException
    {
        try
        {
            IShowCompetitionRmiService rmiService = rmiServiceClient.getShowCompetitionService();
            ShowCompetitionServiceMapper map = new ShowCompetitionServiceMapper();
            return map.getService(rmiService);
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service ShowCompetition not available", ex);
        }
    }

    @Override
    public ILogin getLoginService()
            throws ServiceNotAvailableException
    {
        try
        {
            ILoginRmiService rmiService = rmiServiceClient.getLoginService();
            LoginServiceMapper map = new LoginServiceMapper();
            return map.getService(rmiService);
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service Login not available", ex);
        }
    }
}
