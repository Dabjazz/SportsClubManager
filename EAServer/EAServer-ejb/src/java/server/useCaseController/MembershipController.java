/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.classes.*;
import contract.dto.mapper.ClubTeamNotFoundException;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import contract.useCaseController.IMembershipController;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.dto.mapper.DtoFactory;

/**
 *
 * @author Thomas
 */
public class MembershipController
        implements IMembershipController
{

    private static IMembershipController INSTANCE;

    public static IMembershipController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new MembershipController();
        }
        return INSTANCE;
    }
    DtoFactory dtoFactory = new DtoFactory();

    @Override
    public List<IRoleDto> getRoles(Integer id)
    {
        List<IRoleDto> result = new LinkedList<IRoleDto>();

        try
        {
            for (int r : dtoFactory.getMemberMapper().getById(id).getRoleList())
            {
                result.add(dtoFactory.getRoleMapper().getById(r));
            }
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports)
    {
        List<ITypeOfSportDto> result = new LinkedList<ITypeOfSportDto>();

        for (int sport : sports)
        {
            try
            {
                result.add(dtoFactory.getTypeOfSportMapper().getById(sport));
            } catch (IdNotFoundException ex)
            {
                Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeamList)
    {
        List<IClubTeamDto> clubteams = new LinkedList<IClubTeamDto>();


        for (int player : clubTeamList)
        {
            try
            {
                clubteams.add(dtoFactory.getClubTeamMapper().getById(player));
            } catch (IdNotFoundException ex)
            {
                Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return clubteams;
    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
    {
        try
        {
            return dtoFactory.getTypeOfSportMapper().getAll();
        } catch (NotFoundException ex)
        {
            Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public IRoleDto setRole(IMemberDto member, String role, boolean selected)
    {
        //omfg ...

        if (role.equals("Admin"))
        {
            if (selected)
            {
                try
                {
                    return dtoFactory.getAdminMapper().getMemberById(member.getId());
                } catch (IdNotFoundException ex)
                {
                    AdminDto aDto = new AdminDto();
                    aDto.setName("Admin");
                    aDto.setMember(member.getId());
                    dtoFactory.getAdminMapper().set((IAdminDto) aDto);
                    return aDto;
                }
            }
        } else
        {
            if (role.equals("DepartmentHead"))
            {
                if (selected)
                {
                    try
                    {
                        return dtoFactory.getDepartmentHeadMapper().getMemberById(member.getId());
                    } catch (IdNotFoundException ex)
                    {
                        DepartmentHeadDto aDto = new DepartmentHeadDto();
                        aDto.setName("Department Head");
                        aDto.setMember(member.getId());
                        dtoFactory.getDepartmentHeadMapper().set((IDepartmentHeadDto) aDto);
                        return aDto;
                    }
                }
            } else
            {
                if (role.equals("Caretaker"))
                {
                    if (selected)
                    {
                        try
                        {
                            return dtoFactory.getCaretakerMapper().getMemberById(member.getId());
                        } catch (IdNotFoundException ex)
                        {
                            CaretakerDto aDto = new CaretakerDto();
                            aDto.setName("Caretaker");
                            aDto.setMember(member.getId());
                            dtoFactory.getCaretakerMapper().set((ICaretakerDto) aDto);
                            return aDto;
                        }
                    }
                } else
                {
                    if (role.equals("Trainer"))
                    {
                        if (selected)
                        {
                            try
                            {
                                return dtoFactory.getTrainerMapper().getMemberById(member.getId());
                            } catch (IdNotFoundException ex)
                            {
                                TrainerDto aDto = new TrainerDto();
                                aDto.setName("Trainer");
                                aDto.setMember(member.getId());
                                dtoFactory.getTrainerMapper().set((ITrainerDto) aDto);
                                return aDto;
                            }
                        }
                    } else
                    {
                        if (role.equals("Player"))
                        {
                            if (selected)
                            {
                                try
                                {
                                    if (member.getId() == null)
                                    {
                                        PlayerDto aDto = new PlayerDto();
                                        aDto.setName("Player");
                                        aDto.setMember(member.getId());
                                        dtoFactory.getPlayerMapper().set((IPlayerDto) aDto);
                                        return aDto;
                                    } else
                                    {
                                        return dtoFactory.getPlayerMapper().getMemberById(member.getId());
                                    }
                                } catch (IdNotFoundException ex)
                                {
                                    PlayerDto aDto = new PlayerDto();
                                    aDto.setName("Player");
                                    aDto.setMember(member.getId());
                                    dtoFactory.getPlayerMapper().set((IPlayerDto) aDto);
                                    return aDto;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
    {
        List<IClubTeamDto> ret = new LinkedList<IClubTeamDto>();
        try
        {
            ret = dtoFactory.getClubTeamMapper().getClubTeamsByTypeOfSport(sport);
        } 
        catch (ClubTeamNotFoundException ex)
        {
            Logger.getLogger(NewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
