/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.ClubTeamNotFoundException;
import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import contract.useCaseController.ISearchChangeMemberController;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.dto.mapper.DtoFactory;

/**
 * @author EnjoX
 */
public class SearchChangeMemberController
        implements ISearchChangeMemberController
{

    private static SearchChangeMemberController INSTANCE;
    private IMemberDto member;
    private DtoFactory dtoFactory = new DtoFactory();

    private SearchChangeMemberController()
    {
    }

    public static ISearchChangeMemberController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new SearchChangeMemberController();
        }

        return INSTANCE;
    }

    @Override
    public List<IMemberDto> getMatchingMembers(String searchInput)
    {
        try
        {
            List<IMemberDto> resultIMembers = new LinkedList<IMemberDto>();
            List<IMemberDto> memberList = dtoFactory.getMemberMapper().getAll();
            for (IMemberDto m : memberList)
            {
                if (m.getLastname().toLowerCase().contains(searchInput.toLowerCase())
                        || m.getPrename().toLowerCase().contains(searchInput.toLowerCase())
                        || m.getUsername().toLowerCase().contains(searchInput.toLowerCase()))
                {
                    resultIMembers.add(m);
                }
            }
            return resultIMembers;
        } catch (NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IMemberDto getMember(Integer id)
    {
        try
        {
            return dtoFactory.getMemberMapper().getById(id);
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        //RoleMapper
        List<IRoleDto> roleList = new ArrayList<IRoleDto>();
        try
        {
            IMemberDto m = dtoFactory.getMemberMapper().getById(memberId);
            for (Integer role : m.getRoleList())
            {
                roleList.add(dtoFactory.getRoleMapper().getById(role));
            }
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleList;
    }

    @Override
    public IDepartmentDto getDepartment(Integer memberId)
    {
        try
        {
            //Auch nicht wirklich korrekt!!!!
            List<IDepartmentDto> depList = dtoFactory.getDepartmentMapper().getAll();
            for (IDepartmentDto dep : depList)
            {
                List<IClubTeamDto> clubList = new ArrayList<IClubTeamDto>();
                for (Integer club : dep.getClubTeamList())
                {
                    clubList.add(dtoFactory.getClubTeamMapper().getById(club));
                }

                for (IClubTeamDto team : clubList)
                {
                    if (team.getPlayerList().contains(memberId))
                    {
                        return dep;
                    }
                }
            }
        } catch (NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IAddressDto getAddress(Integer addressId)
    {
        try
        {
            return dtoFactory.getAddressMapper().getById(addressId);
        } 
        catch(IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ICountryDto getCountry(Integer countryID)
    {
        try
        {
            return dtoFactory.getCountryMapper().getById(countryID);
        } catch(IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IDepartmentDto> getDepartments()
    {
        try
        {
            return dtoFactory.getDepartmentMapper().getAll();
        }catch(NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
    {
        List<IClubTeamDto> teamList = new ArrayList<IClubTeamDto>();
        try
        {
            for (Integer team : clubTeams)
            {
                teamList.add(dtoFactory.getClubTeamMapper().getById(team));
            }
        }catch(IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teamList;
    }

    @Override
    public void setNewMember(IMemberDto member, IAddressDto address)
    {
        NewMemberController.getInstance().setNewMember(member, address);
    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        NewMemberController.getInstance().setNewTrainer(member, address, clubTeam);
    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeam)
    {
        NewMemberController.getInstance().setNewPlayer(member, address, clubTeam);
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sportsList)
    {
        List<ITypeOfSportDto> typeOfSportReturnList = new ArrayList<ITypeOfSportDto>();
        try
        {
            for (Integer sportID : sportsList)
            {
                typeOfSportReturnList.add(dtoFactory.getTypeOfSportMapper().getById(sportID));

            }
        } catch(IdNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeOfSportReturnList;
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports()
    {
        try
        {
            return dtoFactory.getTypeOfSportMapper().getAll();
        } catch(NotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setSelectedMember(IMemberDto member)
    {
        this.member = member;
    }

    @Override
    public IMemberDto getSelectedMember()
    {
        return member;
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
    {
        List<IClubTeamDto> cTeams = null;
        try
        {
            cTeams = dtoFactory.getClubTeamMapper().getClubTeamsByTypeOfSport(sport);
        }catch(ClubTeamNotFoundException ex)
        {
            Logger.getLogger(SearchChangeMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cTeams;
    }
}
