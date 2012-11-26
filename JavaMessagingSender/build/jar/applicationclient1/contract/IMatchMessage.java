/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1.contract;

import applicationclient1.stubs.*;
import java.util.Date;
import javax.jms.Message;

/**

 @author Thomas
 */
public interface IMatchMessage 
{
    IMemberDto getMember();
    
     IClubTeamDto getClubTeam();

     ICompetitionDto getCompetition();
}
