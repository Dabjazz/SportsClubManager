/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.INewCompetitionController;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**
 @author EnjoX
 */
public class NewCompetitionController
        implements INewCompetitionController
{
    private static INewCompetitionController INSTANCE;
    private DtoFactory dtoFactory = new DtoFactory();

    public static INewCompetitionController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new NewCompetitionController();
        }
        return INSTANCE;
    }

    @Override
    public void setCompetition(ICompetitionDto competition, IMemberDto member)
    {
        try
        {
            List<IDepartmentDto> departmentList = dtoFactory.getDepartmentMapper().getAll();
            for (IDepartmentDto dep : departmentList)
            {
                List<Integer> sportList = dep.getTypeOfSportList();
                for (Integer sportId : sportList)
                {
                    if (sportId == competition.getSport())
                    {
                        List<Integer> userRolesIds = member.getRoleList();
                        for (Integer role : userRolesIds)
                        {
                            if (dtoFactory.getRoleMapper().getById(role).getId() == dep.getDepartmentHead())
                            {
                                dtoFactory.getCompetitionMapper().set(competition);
                            }
                        }
                    }
                }
            }
        }
        catch (RemoteException | IdNotFoundException | NotFoundException ex)
        {
            Logger.getLogger(NewCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ITeamDto> getTeams()
    {
        try
        {
            return dtoFactory.getTeamMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(NewCompetitionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
