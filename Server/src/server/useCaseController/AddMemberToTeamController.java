/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.IAddMemberToTeamController;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**

 @author Lucia
 */
public class AddMemberToTeamController
        implements IAddMemberToTeamController
{
    private static AddMemberToTeamController singleton = null;
    DtoFactory dtoFactory = new DtoFactory();

    public static AddMemberToTeamController getInstance()
    {
        if (singleton == null)
        {
            singleton = new AddMemberToTeamController();
        }
        return singleton;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(IMemberDto user)
    {
        IDepartmentHeadDto departmentHead = (IDepartmentHeadDto) user;
        List<IClubTeamDto> clubTeamList = new LinkedList<>();

        try
        {
            IMapper<IDepartmentDto> departmentMapper = dtoFactory.getDepartmentMapper();
            IMapper<IClubTeamDto> clubTeamMapper = dtoFactory.getClubTeamMapper();

            for (Integer departmentId : departmentHead.getDepartmentList())
            {
                IDepartmentDto tmp = departmentMapper.getById(departmentId);

                for (Integer clubTeamId : tmp.getClubTeamList())
                {
                    IClubTeamDto clubTeam = clubTeamMapper.getById(clubTeamId);

                    if (clubTeamList.contains(clubTeam))
                    {
                        continue;
                    }

                    clubTeamList.add(clubTeam);
                }
            }
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clubTeamList;
    }

    @Override
    public List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam)
    {
        List<IPlayerDto> currentPlayerList = this.getTeamPlayer(clubTeam);
        List<IPlayerDto> potentialPlayerList = new LinkedList<>();
        try
        {
            IClubTeamDto parentClubTeam = dtoFactory.getClubTeamMapper().getById(clubTeam.getParentClubTeam());

            if (parentClubTeam == null)
            {
                return currentPlayerList;
            }

            for (IPlayerDto playerDto : this.getTeamPlayer(parentClubTeam))
            {
                if(currentPlayerList.contains(playerDto))
                {
                    continue;
                }
                
                potentialPlayerList.add(playerDto);
            }
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return potentialPlayerList;
    }

    @Override
    public List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam)
    {
        List<IPlayerDto> playerList = new ArrayList<>();
        List<Integer> playerIDs = clubTeam.getPlayerList();

        for (Integer id : playerIDs)
        {
            try
            {
                playerList.add(dtoFactory.getPlayerMapper().getById(id));
            }
            catch (IdNotFoundException ex)
            {
                Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return playerList;
    }

    @Override
    public void updateClubTeam(IClubTeamDto clubTeam)
    {
        try
        {
            IClubTeamDto ctDto = dtoFactory.getClubTeamMapper().getById(clubTeam.getId());
            ctDto.setPlayerList(clubTeam.getPlayerList());
            dtoFactory.getClubTeamMapper().set(ctDto);

        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
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
