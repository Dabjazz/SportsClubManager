/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.*;
import java.rmi.*;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.*;

/**

 @author Thomas
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
        List<IRoleDto> result = new LinkedList<>();

        try
        {
            for (int r : dtoFactory.getMemberMapper().getById(id).getRoleList())
            {
                result.add(dtoFactory.getRoleMapper().getById(r));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports)
    {
        List<ITypeOfSportDto> result = new LinkedList<>();

        for (int sport : sports)
        {
            try
            {
                result.add(dtoFactory.getTypeOfSportMapper().getById(sport));
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IdNotFoundException ex)
            {
                Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> clubTeamList)
    {
        List<IClubTeamDto> clubteams = new LinkedList<>();


        for (int player : clubTeamList)
        {
            try
            {
                clubteams.add(dtoFactory.getClubTeamMapper().getById(player));
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IdNotFoundException ex)
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
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NotFoundException ex)
        {
            Logger.getLogger(MembershipController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
