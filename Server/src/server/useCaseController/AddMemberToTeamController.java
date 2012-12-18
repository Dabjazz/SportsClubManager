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
 *
 * @author Lucia
 */
public class AddMemberToTeamController
        implements IAddMemberToTeamController
{
    private static AddMemberToTeamController singleton = null;
    DtoFactory dtoFactory = new DtoFactory();


    private AddMemberToTeamController() {
        
    }
    
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

        IAdminDto admin = null;

        for (Integer role : user.getRoleList()) {
            try {
                IRoleDto r = dtoFactory.getRoleMapper().getById(role);

                if (r instanceof IDepartmentHeadDto) {
                    return findClubTeams((IDepartmentHeadDto) r);
                } 
                else if (r instanceof IAdminDto) {
                    admin = (IAdminDto) r;
                }

                if (admin != null) {
                    return dtoFactory.getClubTeamMapper().getAll();
                }
            } catch (RemoteException | IdNotFoundException | NotFoundException ex) {
                Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new LinkedList<>();
    }

    List<IClubTeamDto> findClubTeams(IDepartmentHeadDto depHead) {
        List<IClubTeamDto> clubTeamList = new LinkedList<>();

        try {
            for (Integer depID : depHead.getDepartmentList()) {
                IDepartmentDto department = dtoFactory.getDepartmentMapper().getById(depID);
				
                for (Integer clubTeamId : department.getClubTeamList()) {
                    IClubTeamDto clubTeam = dtoFactory.getClubTeamMapper().getById(clubTeamId);

                    if (clubTeamList.contains(clubTeam)) {
                        continue;
                    }

                    clubTeamList.add(clubTeam);
                }
            }
        } catch (IdNotFoundException ex) {
            Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
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
            if (clubTeam.getParentClubTeam() == null) {
                return new LinkedList<>();
            }
            
            IClubTeamDto parentClubTeam = dtoFactory.getClubTeamMapper().getById(clubTeam.getParentClubTeam());

            for (IPlayerDto playerDto : this.getTeamPlayer(parentClubTeam))
            {
                if (currentPlayerList.contains(playerDto))
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
