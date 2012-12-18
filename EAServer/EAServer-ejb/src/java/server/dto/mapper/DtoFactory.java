/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.dto.*;
import contract.dto.mapper.*;

/**
 @author Thomas
 */
public class DtoFactory
        implements IDtoFactory
{
    @Override
    public IAdminMapper getAdminMapper()
    {
        return AdminMapper.getInstance();
    }

    @Override
    public ICaretakerMapper getCaretakerMapper()
    {
        return CaretakerMapper.getInstance();
    }

    @Override
    public IMemberMapper getMemberMapper()
    {
        return MemberMapper.getInstance();
    }

    @Override
    public IMapper<IRoleDto> getRoleMapper()
    {
        return RoleMapper.getInstance();
    }

    @Override
    public IMapper<ICompetitionDto> getCompetitionMapper()
    {
        return CompetitionMapper.getInstance();
    }

    @Override
    public IMapper<IAddressDto> getAddressMapper()
    {
        return AddressMapper.getInstance();
    }

    @Override
    public IClubTeamMapper getClubTeamMapper()
    {
        return ClubTeamMapper.getInstance();
    }

    @Override
    public ICountryMapper getCountryMapper()
    {
        return CountryMapper.getInstance();
    }

    @Override
    public IMapper<IDepartmentDto> getDepartmentMapper()
    {
        return DepartmentMapper.getInstance();
    }

    @Override
    public IMapper<ITeamDto> getTeamMapper()
    {
        return TeamMapper.getInstance();
    }

    @Override
    public ITypeOfSportMapper getTypeOfSportMapper()
    {
        return TypeOfSportMapper.getInstance();
    }

    @Override
    public ITrainerMapper getTrainerMapper()
    {
        return TrainerMapper.getInstance();
    }

    @Override
    public IDepartmentHeadMapper getDepartmentHeadMapper()
    {
        return DepartmentHeadMapper.getInstance();
    }

    @Override
    public ILeagueMapper getLeagueMapper()
    {
        return LeagueMapper.getInstance();
    }

    @Override
    public IMapper<IPermissionDto> getPermissionMapper()
    {
        return PermissionMapper.getInstance();
    }

    @Override
    public IPlayerMapper getPlayerMapper()
    {
        return PlayerMapper.getInstance();
    }

    @Override
    public IMapper<IMatchresultDto> getMatchresultMapper()
    {
        return MatchresultMapper.getInstance();
    }

    @Override
    public IMapper<IMatchDto> getMatchMapper()
    {
        MatchMapper m = (MatchMapper) MatchMapper.getInstance();
        return m;
    }
}
