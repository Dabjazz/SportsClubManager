/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.classes.AdminDto;
import contract.dto.classes.CaretakerDto;
import contract.dto.classes.DepartmentHeadDto;
import contract.dto.classes.PlayerDto;
import contract.dto.classes.TrainerDto;
import contract.dto.mapper.*;
import contract.useCaseController.*;
import java.rmi.*;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.*;

/**
 *
 * @author Thomas
 */
public class MembershipController
        implements IMembershipController {

    private static IMembershipController INSTANCE;

    public static IMembershipController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MembershipController();
        }
        return INSTANCE;
    }
    DtoFactory dtoFactory = new DtoFactory();

    @Override
    public List<IRoleDto> getRoles(Integer id) {
        List<IRoleDto> result = new LinkedList<>();

        try {
            for (int r : dtoFactory.getMemberMapper().getById(id).getRoleList()) {
                result.add(dtoFactory.getRoleMapper().getById(r));
            }
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports) {
        List<ITypeOfSportDto> result = new LinkedList<>();

        for (int sport : sports) {
            try {
                result.add(dtoFactory.getTypeOfSportMapper().getById(sport));
            } catch (RemoteException ex) {
                Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IdNotFoundException ex) {
                Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeamList) {
        List<IClubTeamDto> clubteams = new LinkedList<>();


        for (int player : clubTeamList) {
            try {
                clubteams.add(dtoFactory.getClubTeamMapper().getById(player));
            } catch (RemoteException ex) {
                Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IdNotFoundException ex) {
                Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return clubteams;
    }

    @Override
    public List<ITypeOfSportDto> getAllSports() {
        try {
            return dtoFactory.getTypeOfSportMapper().getAll();
        } catch (RemoteException ex) {
            Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public IRoleDto setRole(IMemberDto member, String role, boolean selected) {
        IRoleDto aDto = null;
        try {

            switch (role) {
                case "Admin":
                    if (selected) {
                        try {
                            return dtoFactory.getAdminMapper().getMemberById(member.getId());
                        } catch (IdNotFoundException ex) {
                            aDto = new AdminDto();
                            aDto.setName("Admin");
                            aDto.setMember(member.getId());
                            dtoFactory.getAdminMapper().set((IAdminDto) aDto);

                        }
                    }
                    break;

                case "DepartmentHead":
                    if (selected) {
                        try {
                            return dtoFactory.getDepartmentHeadMapper().getMemberById(member.getId());
                        } catch (IdNotFoundException ex) {
                            aDto = new DepartmentHeadDto();
                            aDto.setName("Department Head");
                            aDto.setMember(member.getId());
                            dtoFactory.getDepartmentHeadMapper().set((IDepartmentHeadDto) aDto);
                        }
                    }
                    break;

                case "Caretaker":
                    if (selected) {
                        try {
                            return dtoFactory.getCaretakerMapper().getMemberById(member.getId());
                        } catch (IdNotFoundException ex) {
                            aDto = new CaretakerDto();
                            aDto.setName("Caretaker");
                            aDto.setMember(member.getId());
                            dtoFactory.getCaretakerMapper().set((ICaretakerDto) aDto);
                        }
                    }
                    break;

                case "Trainer":
                    if (selected) {
                        try {
                            return dtoFactory.getTrainerMapper().getMemberById(member.getId());
                        } catch (IdNotFoundException ex) {
                            aDto = new TrainerDto();
                            aDto.setName("Trainer");
                            aDto.setMember(member.getId());
                            dtoFactory.getTrainerMapper().set((ITrainerDto) aDto);
                        }
                    }
                    break;

                case "Player":
                    if (selected) {
                        try {
                            return dtoFactory.getPlayerMapper().getMemberById(member.getId());
                        } catch (IdNotFoundException ex) {
                            aDto = new PlayerDto();
                            aDto.setName("Player");
                            aDto.setMember(member.getId());
                            dtoFactory.getPlayerMapper().set((IPlayerDto) aDto);
                        }
                    }
                    break;

            }
        } catch (RemoteException ex1) {
            Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return aDto;
    }
}
