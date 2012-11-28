/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client;

import com.contract.IUseCaseControllerFactory;
import com.rmi.client.serviceMapper.PermissionControllerServiceMapper;
import com.rmi.client.serviceMapper.MembershipControllerServiceMapper;
import com.rmi.client.serviceMapper.NewCompetitionServiceMapper;
import com.rmi.client.serviceMapper.ChangeCompetitionTeamServiceMapper;
import com.rmi.client.serviceMapper.SearchChangeMemberServiceMapper;
import com.rmi.client.serviceMapper.LoginServiceMapper;
import com.rmi.client.serviceMapper.AddMemberToTeamServiceMapper;
import com.rmi.client.serviceMapper.AddMatchResultsServiceMapper;
import com.rmi.client.serviceMapper.NewMemberServiceMapper;
import com.rmi.client.serviceMapper.AddressControllerServiceMapper;
import com.rmi.client.serviceMapper.ShowCompetitionServiceMapper;
import com.*;
import contract.rmi.IRmiServiceFactory;
import contract.rmi.services.*;
import contract.useCaseController.*;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.logging.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiUseCaseControllerFactory
        implements IUseCaseControllerFactory
{
    private String host;
    private int port;
    private IRmiServiceFactory rmiServiceClient;

    public RmiUseCaseControllerFactory(String host, int port)
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
            rmiServiceClient = (IRmiServiceFactory) Naming.lookup("rmi://" + host + ":" + port + "/CommunicationFactory");
        }
        catch (NotBoundException | MalformedURLException | RemoteException ex)
        {
            ex.printStackTrace();
            throw new CommunicationProblemException(host, ex);
        }
    }

    @Override
    public IAddMatchResultsController getAddMatchResultsController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new AddMatchResultsServiceMapper(rmiServiceClient.getAddMatchResultsService());
        }
        catch (RemoteException ex)
        {
            ex.printStackTrace();
            throw new ServiceNotAvailableException("Service AddMatchResults not available", ex);
        }
    }

    @Override
    public IChangeCompetitionTeamController getChangeCompetitionTeamController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new ChangeCompetitionTeamServiceMapper(rmiServiceClient.getChangeCompetitionTeamService());
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service ChangeCompetitionTeam not available", ex);
        }
    }

    @Override
    public INewCompetitionController getNewCompetitionController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new NewCompetitionServiceMapper(rmiServiceClient.getNewCompetitionService());
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service NewCompetitionService not available", ex);
        }
    }

    @Override
    public INewMemberController getNewMemberController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new NewMemberServiceMapper(rmiServiceClient.getNewMemberService());
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service NewMemberService not available", ex);
        }
    }

    @Override
    public ISearchChangeMemberController getSearchChangeMemberController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new SearchChangeMemberServiceMapper(rmiServiceClient.getSearchChangeMemberService());
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service SearchChangeMember not available", ex);
        }
    }

    @Override
    public IShowCompetitionController getShowCompetitionController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new ShowCompetitionServiceMapper(rmiServiceClient.getShowCompetitionService());
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service ShowCompetition not available", ex);
        }
    }

    @Override
    public ILogin getLoginController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new LoginServiceMapper(rmiServiceClient.getLoginService());
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service Login not available", ex);
        }
    }

    @Override
    public IAddressController getAddressController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new AddressControllerServiceMapper(rmiServiceClient.getAddressService());
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public IMembershipController getMembershipController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new MembershipControllerServiceMapper(rmiServiceClient.getMembershipService());
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public IAddMemberToTeamController getAddMemberToTeamController()
            throws ServiceNotAvailableException
    {
        try
        {
            return new AddMemberToTeamServiceMapper(rmiServiceClient.getAddMemberToTeamRmiService());
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(RmiUseCaseControllerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IPermissionController getPermissionController()
            throws ServiceNotAvailableException
    {
        try
        {
            IPermissionControllerService s = rmiServiceClient.getPermissionController();
            return new PermissionControllerServiceMapper(s);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(RmiUseCaseControllerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
