/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;
import contract.dto.*;
import contract.dto.mapper.NotFoundException;
import contract.useCaseController.INewCompetition;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;
/**
 *
 * @author EnjoX
 */
public class NewCompetition implements INewCompetition{
    private static INewCompetition INSTANCE;
    
    public static INewCompetition getInstance() {
        if(INSTANCE == null)
        {
            INSTANCE = new NewCompetition();
        }
        return INSTANCE;
    }

    @Override
    public void setCompetition(ICompetitionDto competition, IMemberDto member) {
        try { 
            DtoFactory.getCompetitionMapper().set(competition);
        } catch (RemoteException ex) {
            Logger.getLogger(NewCompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ITeamDto> getTeams() {
        try {
            return DtoFactory.getTeamMapper().getAll();
        } catch (RemoteException | NotFoundException ex) {
            Logger.getLogger(NewCompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
