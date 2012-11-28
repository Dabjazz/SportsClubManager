/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.service;

import contract.dto.IMemberDto;
import contract.dto.ICompetitionDto;
import contract.dto.ITeamDto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import contract.rmi.services.INewCompetitionRmiService;
import server.useCaseController.NewCompetitionController;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewCompetitionRmiService extends UnicastRemoteObject implements INewCompetitionRmiService
{

    public NewCompetitionRmiService() throws RemoteException {
        super();
    }
    
    @Override
    public void setCompetition(ICompetitionDto competition, IMemberDto member) throws RemoteException
    {
        NewCompetitionController.getInstance().setCompetition(competition, member);
    }

    @Override
    public List<ITeamDto> getTeams() throws RemoteException
    {
        return NewCompetitionController.getInstance().getTeams();
    }
    
}
