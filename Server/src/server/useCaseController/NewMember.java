/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.INewMember;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**

 @author EnjoX
 */
public class NewMember
        implements INewMember
{
    private static INewMember INSTANCE;
    private DtoFactory dtoFactory = new DtoFactory();

    private NewMember()
    {
    }

    public static INewMember getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new NewMember();
        }
        return INSTANCE;
    }

    /**

     @param member
     @param address
     @return
     */
    @Override
    public void setNewMember(IMemberDto member, IAddressDto address)
    {
        addMember(member, address);
    }

    private IMemberDto addMember(IMemberDto member, IAddressDto address)
    {
        try
        {
            Integer adressId = dtoFactory.getAddressMapper().set(address);
            member.setAddress(adressId);
            dtoFactory.getMemberMapper().set(member);
            return member;
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IDepartmentDto> getDepartments()
    {
        try
        {
            return dtoFactory.getDepartmentMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
    {
        List<IClubTeamDto> clubTeamList = new ArrayList<>();
        try
        {
            for (Integer team : clubTeams)
            {
                clubTeamList.add(dtoFactory.getClubTeamMapper().getById(team));
            }

        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clubTeamList;
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList)
    {
        List<ITypeOfSportDto> typeOfSportReturnList = new ArrayList<>();
        try
        {
            for (Integer sportID : typOfSportsList)
            {
                typeOfSportReturnList.add(dtoFactory.getTypeOfSportMapper().getById(sportID));

            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeOfSportReturnList;
    }

    @Override
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
    {
        List<IClubTeamDto> ret = new LinkedList<>();
        try
        {
            ret = dtoFactory.getClubTeamMapper().getClubTeamsByTypeOfSport(sport);

        }
        catch (ClubTeamNotFoundException | RemoteException ex)
        {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList)
    {
        IMemberDto m = addMember(member, address);


        if (m == null)
        {
            return;
        }

        for (IClubTeamDto clubTeamDto : clubTeamList)
        {
            List<Integer> players = clubTeamDto.getPlayerList();
            players.add(m.getId());
            clubTeamDto.setPlayerList(players);
        }
    }

    @Override
    public void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList)
    {
        IMemberDto m = addMember(member, address);

        if (m == null)
        {
            return;
        }

        for (IClubTeamDto clubTeamDto : clubTeamList)
        {
            List<Integer> players = clubTeamDto.getTrainerList();
            players.add(m.getId());
            clubTeamDto.setTrainerList(players);
        }
    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
    {
        try
        {
            try
            {
                return dtoFactory.getTypeOfSportMapper().getAll();
            }
            catch (NotFoundException ex)
            {
                Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
