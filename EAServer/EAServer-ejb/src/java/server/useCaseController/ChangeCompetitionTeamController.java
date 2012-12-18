/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.IClubTeamMapper;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import contract.useCaseController.IChangeCompetitionTeamController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.dto.mapper.DtoFactory;

/**
 *
 * @author EnjoX
 */
public class ChangeCompetitionTeamController
        implements IChangeCompetitionTeamController
{

    private static IChangeCompetitionTeamController INSTANCE;
    private DtoFactory dtoFactory = new DtoFactory();

    private ChangeCompetitionTeamController()
    {
    }

    public static IChangeCompetitionTeamController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new ChangeCompetitionTeamController();
        }
        return INSTANCE;
    }

    @Override
    public List<ICompetitionDto> getCompetition()
    {
        try
        {

            return dtoFactory.getCompetitionMapper().getAll();
        } catch (NotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> Teams)
    {
        List<IClubTeamDto> clubTeamList = new ArrayList<IClubTeamDto>();

        IClubTeamMapper ctMapper = dtoFactory.getClubTeamMapper();
        for (Integer teamId : Teams)
        {
            try
            {
                IClubTeamDto ct = ctMapper.getById(teamId);
                clubTeamList.add(ct);
            } catch (IdNotFoundException ex)
            {
            }
        }

        return clubTeamList;
    }

    @Override
    public void setCompetitonTeam(ICompetitionDto competition, IClubTeamDto oldTeam, IClubTeamDto newTeam)
    {
        List<Integer> teamList = competition.getTeamList();

        for (Integer team : teamList)
        {
            if (team == oldTeam.getId())
            {
                team = newTeam.getId();
            }
        }
        dtoFactory.getCompetitionMapper().set(competition);
    }

    @Override
    public List<IClubTeamDto> getClubTeams()
    {
        try
        {

            return dtoFactory.getClubTeamMapper().getAll();
        } catch (NotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IClubTeamDto getCompetitionTeam(IClubTeamDto team)
    {
        //Sry han kA meh was i do tu muss ^^
        return team;
    }

    @Override
    public List<IPlayerDto> getPlayers(List<Integer> players)
    {
        List<IPlayerDto> playerList = new ArrayList<IPlayerDto>();

        try
        {
            for (Integer player : players)
            {

                playerList.add(dtoFactory.getPlayerMapper().getById(player));

            }
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playerList;
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        //RoleMapper
        List<IRoleDto> roleList = new ArrayList<IRoleDto>();
        try
        {
            IMemberDto member = dtoFactory.getMemberMapper().getById(memberId);
            for (Integer role : member.getRoleList())
            {
                roleList.add(dtoFactory.getRoleMapper().getById(role));
            }
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleList;
    }
}
