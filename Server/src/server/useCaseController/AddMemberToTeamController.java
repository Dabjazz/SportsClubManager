/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.IdNotFoundException;
import contract.useCaseController.IAddMemberToTeamController;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.dto.mapper.DtoFactory;

/**
 *
 * @author Lucia
 */
public class AddMemberToTeamController
        implements IAddMemberToTeamController {

    private static AddMemberToTeamController singleton = null;
    DtoFactory dtoFactory = new DtoFactory();

    public static AddMemberToTeamController getInstance() {
        if (singleton == null) {
            singleton = new AddMemberToTeamController();
        }
        return singleton;
    }

    //TODO implement those methodes - too brainfu... right now
    @Override
    public List<IClubTeamDto> getClubTeams(IMemberDto user) {
        IDepartmentHeadDto departmentHead = (IDepartmentHeadDto) user;
        List<IClubTeamDto> clubTeamList = new LinkedList<>();

        try {
            for (Integer id : departmentHead.getDepartmentList()) {
                IDepartmentDto tmp = dtoFactory.getDepartmentMapper().getById(id);

                for (Integer i : tmp.getClubTeamList()) {
                    if (!clubTeamList.contains(dtoFactory.getClubTeamMapper().getById(i))) {
                        clubTeamList.add(dtoFactory.getClubTeamMapper().getById(i));
                    }
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
    public List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam) {
        List<IPlayerDto> playerList = new ArrayList<>();
        List<Integer> playerIDs = clubTeam.getPlayerList();

        for (Integer id : playerIDs) {
            try {
                playerList.add(dtoFactory.getPlayerMapper().getById(id));
            } catch (IdNotFoundException ex) {
                Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return playerList;
    }

    @Override
    public void updateClubTeam(IClubTeamDto clubTeam) {
        try {
            IClubTeamDto ctDto = dtoFactory.getClubTeamMapper().getById(clubTeam.getId());
            ctDto.setPlayerList(clubTeam.getPlayerList());
            dtoFactory.getClubTeamMapper().set(ctDto);

        } catch (IdNotFoundException ex) {
            Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AddMemberToTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
