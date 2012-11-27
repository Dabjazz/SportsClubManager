/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.dto.*;
import contract.dto.classes.*;
import contract.dto.mapper.*;
import java.rmi.RemoteException;

/**
 @author Thomas
 */
public class DtoFactory
        implements IDtoFactory
{
    @Override
    public IAdminMapper getAdminMapper()
            throws RemoteException
    {
        return AdminMapper.getInstance();
    }

    @Override
    public ICaretakerMapper getCaretakerMapper()
            throws RemoteException
    {
        return CaretakerMapper.getInstance();
    }

    @Override
    public IMemberMapper getMemberMapper()
            throws RemoteException
    {
        return MemberMapper.getInstance();
    }

    @Override
    public IMapper<IRoleDto> getRoleMapper()
            throws RemoteException
    {
        return RoleMapper.getInstance();
    }

    @Override
    public IMapper<ICompetitionDto> getCompetitionMapper()
            throws RemoteException
    {
        return CompetitionMapper.getInstance();
    }

    @Override
    public IMapper<IAddressDto> getAddressMapper()
            throws RemoteException
    {
        return AddressMapper.getInstance();
    }

    @Override
    public IClubTeamMapper getClubTeamMapper()
            throws RemoteException
    {
        return ClubTeamMapper.getInstance();
    }

    @Override
    public ICountryMapper getCountryMapper()
            throws RemoteException
    {
        return CountryMapper.getInstance();
    }

    @Override
    public IMapper<IDepartmentDto> getDepartmentMapper()
            throws RemoteException
    {
        return DepartmentMapper.getInstance();
    }

    @Override
    public IMapper<ITeamDto> getTeamMapper()
            throws RemoteException
    {
        return TeamMapper.getInstance();
    }

    @Override
    public ITypeOfSportMapper getTypeOfSportMapper()
            throws RemoteException
    {
        return TypeOfSportMapper.getInstance();
    }

    @Override
    public ITrainerMapper getTrainerMapper()
            throws RemoteException
    {
        return TrainerMapper.getInstance();
    }

    @Override
    public IDepartmentHeadMapper getDepartmentHeadMapper()
            throws RemoteException
    {
        return DepartmentHeadMapper.getInstance();
    }

    @Override
    public ILeagueMapper getLeagueMapper()
            throws RemoteException
    {
        return LeagueMapper.getInstance();
    }

    @Override
    public IMapper<IPermissionDto> getPermissionMapper()
            throws RemoteException
    {
        return PermissionMapper.getInstance();
    }

    @Override
    public IPlayerMapper getPlayerMapper()
            throws RemoteException
    {
        return PlayerMapper.getInstance();
    }

    @Override
    public IMapper<IMatchresultDto> getMatchresultMapper()
            throws RemoteException
    {
        return MatchresultMapper.getInstance();
    }

    @Override
    public IMapper<IMatchDto> getMatchMapper()
            throws RemoteException
    {
        MatchMapper m = (MatchMapper) MatchMapper.getInstance();

        return m;
    }
}
