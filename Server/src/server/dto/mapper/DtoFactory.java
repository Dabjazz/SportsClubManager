/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.dto.mapper.ITypeOfSportMapper;
import contract.dto.mapper.IMemberMapper;
import contract.dto.mapper.IClubTeamMapper;
import contract.dto.mapper.IMapper;
import contract.dto.mapper.ILeagueMapper;
import contract.dto.IDepartment;
import contract.dto.ICountry;
import contract.dto.IAddress;
import contract.dto.IMatch;
import contract.dto.ICompetition;
import contract.dto.IPermission;
import contract.dto.ITeam;
import contract.dto.IMatchresult;
import contract.dto.IRole;
import contract.dto.ICaretaker;
import contract.dto.IAdmin;
import contract.dto.IPlayer;
import contract.dto.IDepartmentHead;
import contract.dto.ITrainer;
import java.rmi.RemoteException;

/**
 @author Thomas
 */
public class DtoFactory
{
    public static IMapper<IAdmin> getAdminMapper()
            throws RemoteException
    {
        return AdminMapper.getInstance();
    }

    public static IMapper<ICaretaker> getCaretakerMapper()
            throws RemoteException
    {
        return CaretakerMapper.getInstance();
    }

    public static IMemberMapper getMemberMapper()
            throws RemoteException
    {
        return MemberMapper.getInstance();
    }

    public static IMapper<IRole> getRoleMapper()
            throws RemoteException
    {
        return RoleMapper.getInstance();
    }

    public static IMapper<ICompetition> getCompetitionMapper()
            throws RemoteException
    {
        return CompetitionMapper.getInstance();
    }

    public static IMapper<IAddress> getAddressMapper()
            throws RemoteException
    {
        return AddressMapper.getInstance();
    }

    public static IClubTeamMapper getClubTeamMapper()
            throws RemoteException
    {
        return ClubTeamMapper.getInstance();
    }

    public static IMapper<ICountry> getCountryMapper()
            throws RemoteException
    {
        return CountryMapper.getInstance();
    }

    public static IMapper<IDepartment> getDepartmentMapper()
            throws RemoteException
    {
        return DepartmentMapper.getInstance();
    }

    public static IMapper<ITeam> getTeamMapper()
            throws RemoteException
    {
        return TeamMapper.getInstance();
    }

    public static ITypeOfSportMapper getTypeOfSportMapper()
            throws RemoteException
    {
        return TypeOfSportMapper.getInstance();
    }

    public static IMapper<ITrainer> getTrainerMapper()
            throws RemoteException
    {
        return TrainerMapper.getInstance();
    }

    public static IMapper<IDepartmentHead> getDepartmentHeadMapper()
            throws RemoteException
    {
        return DepartmentHeadMapper.getInstance();
    }

    public static ILeagueMapper getLeagueMapper()
            throws RemoteException
    {
        return LeagueMapper.getInstance();
    }

    public static IMapper<IPermission> getPermissionMapper()
            throws RemoteException
    {
        return PermissionMapper.getInstance();
    }

    public static IMapper<IPlayer> getPlayerMapper()
            throws RemoteException
    {
        return PlayerMapper.getInstance();
    }

    public static IMapper<IMatchresult> getMatchresultMapper()
            throws RemoteException
    {
        return MatchresultMapper.getInstance();
    }

    public static IMapper<IMatch> getMatchMapper()
            throws RemoteException
    {
        return MatchMapper.getInstance();
    }
}
