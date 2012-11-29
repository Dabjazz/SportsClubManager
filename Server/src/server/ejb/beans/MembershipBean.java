/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.IClubTeamDto;
import contract.dto.IMemberDto;
import contract.dto.IRoleDto;
import contract.dto.ITypeOfSportDto;
import contract.ejb.business.IMembershipRemote;
import contract.useCaseController.NetworkFailureException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import server.useCaseController.MembershipController;

@Stateless
public class MembershipBean implements IMembershipRemote
{
    public MembershipBean()
    {
        super();
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(List<Integer> sports)
    {
        List<ITypeOfSportDto> list = new LinkedList<>();
       
        try {
            list = MembershipController.getInstance().getTypeOfSports(sports);
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    @Override
    public List<ITypeOfSportDto> getAllSports()
    {
        List<ITypeOfSportDto> list = new LinkedList<>();
        try {
            list =  MembershipController.getInstance().getAllSports();
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<IRoleDto> getRoles(Integer id)
    {
        List<IRoleDto> list = new LinkedList<>();
        try {
            list = MembershipController.getInstance().getRoles(id);
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<IClubTeamDto> getClubTeams(List<Integer> playerList)
    {
        List<IClubTeamDto> list = new LinkedList<>();
        try {
            list =  MembershipController.getInstance().getClubTeams(playerList);
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public IRoleDto setRole(IMemberDto member, String departmentHead, boolean selected)
    {
        IRoleDto setRole = null;
        try {
            setRole = MembershipController.getInstance().setRole(member, departmentHead, selected);
        } catch (NetworkFailureException ex) {
            Logger.getLogger(MembershipBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return setRole;
    }
}
