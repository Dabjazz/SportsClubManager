/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.*;
import java.util.List;
import javax.ejb.Remote;
/**

 @author Lucia
 */
@Remote
public interface INewCompetitionRemote
{
    void setCompetition(ICompetitionDto competition, IMemberDto member);

    List<ITeamDto> getTeams();
}
