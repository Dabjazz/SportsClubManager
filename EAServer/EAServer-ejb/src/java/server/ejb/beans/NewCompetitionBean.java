/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.IMemberDto;
import contract.dto.ICompetitionDto;
import contract.dto.ITeamDto;
import contract.ejb.business.INewCompetitionRemote;
import java.rmi.RemoteException;
import java.util.List;
import server.useCaseController.NewCompetitionController;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewCompetitionBean implements INewCompetitionRemote
{

    public NewCompetitionBean(){
        super();
    }
    
    @Override
    public void setCompetition(ICompetitionDto competition, IMemberDto member)
    {
        NewCompetitionController.getInstance().setCompetition(competition, member);
    }

    @Override
    public List<ITeamDto> getTeams()
    {
        return NewCompetitionController.getInstance().getTeams();
    }
    
}
