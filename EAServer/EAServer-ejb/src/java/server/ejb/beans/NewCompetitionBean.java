/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.*;
import contract.ejb.business.INewCompetitionRemote;
import java.util.List;
import javax.ejb.Stateful;
import server.useCaseController.NewCompetitionController;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
@Stateful
public class NewCompetitionBean implements INewCompetitionRemote
{

    public NewCompetitionBean(){
        super();
    }

    @Override
    public List<IRoleDto> getRoles(Integer memberId)
    {
        List<IRoleDto> roles = NewCompetitionController.getInstance().getRoles(memberId);
        return roles;
    }

    @Override
    public List<ITypeOfSportDto> getTypeOfSports(Integer memberId)
    {
        return NewCompetitionController.getInstance().getTypeOfSports(memberId);
    }

    @Override
    public List<ITeamDto> getTeams(ITypeOfSportDto sport)
    {
        return NewCompetitionController.getInstance().getTeams(sport);
    }

    @Override
    public void setCompetition(ICompetitionDto competition, IAddressDto address, ICountryDto country, List<IMatchDto> matchList)
    {
        NewCompetitionController.getInstance().setCompetition(competition, address, country, matchList);
    }
    

    
}
