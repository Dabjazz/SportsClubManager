/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

import contract.*;
import dto.contract.*;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;
import rmi.contract.services.IShowCompetitionRmiService;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ShowCompetitionServiceMapper
        implements RmiServiceToServiceMapper<IShowCompetitionRmiService, IShowCompetition>
{
    @Override
    public IShowCompetition getService(IShowCompetitionRmiService rmiService)
    {
        ShowCompetition n = new ShowCompetition();
        n.setService(rmiService);
        return n;
    }

    private static class ShowCompetition
            implements IShowCompetition
    {
        private IShowCompetitionRmiService service;

        public void setService(IShowCompetitionRmiService service)
        {
            this.service = service;
        }

        @Override
        public List<ICompetition> getCompetitions()
        {
            try
            {
                return service.getCompetitions();
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ShowCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<IMatch> getMatchs(List<Integer> matches)
        {
            try
            {
                return service.getMatchs(matches);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ShowCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<ShowMatchObj> getTeams(List<Integer> matches)
        {
            try
            {
                return service.getTeams(matches);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ShowCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<IPlayer> getPlayer(IClubTeam team)
        {
            try
            {
                return service.getPlayer(team);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ShowCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
}
