<<<<<<< HEAD
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import java.rmi.RemoteException;
import dto.controller.contract.IController;
import dto.contract.*;

/**
 this class provides the server-side services via rmi

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClient implements SeviceClient
{
    private IRmiServiceFactory factory;

    public RmiServiceClient(IRmiServiceFactory factory)
            throws CommunicationProblemException
    {
            this.factory = factory;
    }

    public RmiServiceClient()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public IController<IAddress> getAddressManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getAddressManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<IClubTeam> getClubTeamManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getClubTeamManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<ICountry> getCountryManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getCountryManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<IDepartment> getDepartmentManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getDepartmentManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<IDepartmentHead> getDepartmentHeadManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getDepartmentHeadManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<ILeague> getLeagueManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getLeagueManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<IMatch> getMatchManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getMatchManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<IMatchresult> getMatchresultManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getMatchresultManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<IMember> getMemberManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getMemberManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<IPermission> getPermissionManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getPermissionManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<IPlayer> getPlayerManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getPlayerManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<ITeam> getTeamManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getTeamManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<ITrainer> getTrainerManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getTrainerManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<ITypeOfSport> getTypeOfSportManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getTypeOfSportManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IController<ICompetition> getCompetitionManager()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
=======
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import java.rmi.RemoteException;
import rmi.contract.IRmiServiceFactory;
import dto.mapper.contract.IMapper;
import dto.contract.*;

/**
 this class provides the server-side services via rmi

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClient implements SeviceClient
{
    private IRmiServiceFactory factory;

    public RmiServiceClient(IRmiServiceFactory factory)
            throws CommunicationProblemException
    {
            this.factory = factory;
    }

    public RmiServiceClient()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public IMapper<IAddress> getAddressManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getAddressManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IClubTeam> getClubTeamManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getClubTeamManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ICountry> getCountryManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getCountryManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IDepartment> getDepartmentManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getDepartmentManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IDepartmentHead> getDepartmentHeadManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getDepartmentHeadManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ILeague> getLeagueManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getLeagueManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IMatch> getMatchManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getMatchManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IMatchresult> getMatchresultManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getMatchresultManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IMember> getMemberManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getMemberManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IPermission> getPermissionManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getPermissionManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IPlayer> getPlayerManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getPlayerManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ITeam> getTeamManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getTeamManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ITrainer> getTrainerManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getTrainerManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ITypeOfSport> getTypeOfSportManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getTypeOfSportManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ICompetition> getCompetitionManager()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
>>>>>>> 9bddcdca290ba3efe935fd6ee45cd90b352a873f
