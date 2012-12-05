/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.IChangeCompetitionTeamController;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**

 @author EnjoX
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
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> Teams)
    {
        List<IClubTeamDto> clubTeamList = new ArrayList<>();

        try
        {
            IClubTeamMapper ctMapper = dtoFactory.getClubTeamMapper();
            for (Integer teamId : Teams)
            {
                try
                {
                    IClubTeamDto ct = ctMapper.getById(teamId);
                    clubTeamList.add(ct);
                }
                catch (IdNotFoundException ex)
                {
                }
            }
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamController.class.getName()).log(Level.SEVERE, null, ex);
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
        try
        {
            dtoFactory.getCompetitionMapper().set(competition);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IClubTeamDto> getClubTeams()
    {
        try
        {
            return dtoFactory.getClubTeamMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
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
        List<IPlayerDto> playerList = new ArrayList<>();

        try
        {
            for (Integer player : players)
            {
                playerList.add(dtoFactory.getPlayerMapper().getById(player));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playerList;
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId) {
        //RoleMapper
        List<IRoleDto> roleList = new ArrayList<>();
        try
        {
            IMemberDto member = dtoFactory.getMemberMapper().getById(memberId);
            for (Integer role : member.getRoleList())
            {
                roleList.add(dtoFactory.getRoleMapper().getById(role));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleList;
    }
}
