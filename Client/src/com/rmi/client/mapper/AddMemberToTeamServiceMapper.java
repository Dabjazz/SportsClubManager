/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.mapper;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IPlayerDto;
import contract.rmi.services.IAddMemberToTeamRmiService;
import contract.useCaseController.IAddMemberToTeam;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucia
 */
public class AddMemberToTeamServiceMapper implements RmiServiceToServiceMapper<IAddMemberToTeamRmiService, IAddMemberToTeam> {

    @Override
    public IAddMemberToTeam getService(IAddMemberToTeamRmiService rmiService) {
        
        AddMemberToTeam n = new AddMemberToTeam();
        n.setService(rmiService);
        return n;  
    }
    
    private static class AddMemberToTeam implements IAddMemberToTeam{

        private IAddMemberToTeamRmiService service;
                
        public void setService(IAddMemberToTeamRmiService service) {
            this.service = service;
        }
        
        @Override
        public List<IClubTeamDto> getClubTeams(IMemberDto user) {
            try {
                return service.getClubTeams(user);
            } catch (RemoteException ex) {
                Logger.getLogger(AddMemberToTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;           
        }

        @Override
        public List<IPlayerDto> getPotentialPlayer(IClubTeamDto clubTeam) {
            try {
                return service.getPotentialPlayer(clubTeam);
            } catch (RemoteException ex) {
                Logger.getLogger(AddMemberToTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<IPlayerDto> getTeamPlayer(IClubTeamDto clubTeam) {
            try {
                return service.getTeamPlayer(clubTeam);
            } catch (RemoteException ex) {
                Logger.getLogger(AddMemberToTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public void updateClubTeam(IClubTeamDto clubTeam) {
            try {
                service.updateClubTeam(clubTeam);
            } catch (RemoteException ex) {
                Logger.getLogger(AddMemberToTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
