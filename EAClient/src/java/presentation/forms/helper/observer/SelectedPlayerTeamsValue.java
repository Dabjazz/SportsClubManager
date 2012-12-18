/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.helper.observer;

import contract.dto.IClubTeamDto;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface SelectedPlayerTeamsValue {
    
    void playerTeamsSelected(List<IClubTeamDto> selectedTeams);
}
