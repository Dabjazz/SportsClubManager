/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

import applicationclient1.contract.IMatchMessage;
import applicationclient1.stubs.*;
import java.io.Serializable;
import javax.jms.Message;

/**

 @author Thomas
 */
public class MatchMessage
        implements Serializable, IMatchMessage
{
    private IMemberDto member;
    private ICompetitionDto competition;
    private IClubTeamDto clubTeam;

    MatchMessage(IMemberDto member, ICompetitionDto competition, IClubTeamDto clubTeam)
    {
        this.member = member;
        this.competition = competition;
        this.clubTeam = clubTeam;
    }

    @Override
    public IMemberDto getMember()
    {
        return member;
    }

    @Override
    public IClubTeamDto getClubTeam()
    {
        return clubTeam;
    }

    @Override
    public ICompetitionDto getCompetition()
    {
        return competition;
    }
}
