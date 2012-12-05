/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

import java.util.*;
import javamessaging.stubs.*;

/**
 @author Thomas
 */
public class MainSender
{
    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
    {
        for (int i = 0; i < 3; i++)
        {
            MatchPublisherJms match = new MatchPublisherJms();

            List<IPlayerDto> playerList = new LinkedList<IPlayerDto>();
            playerList.add(new PlayerDto(new MemberDto("Thomas")));
            playerList.add(new PlayerDto(new MemberDto("Lucia")));
            playerList.add(new PlayerDto(new MemberDto("Markus")));

            IClubTeamDto clubTeam = new ClubTeamDto("Team " + new Date());
            clubTeam.setPlayerList(playerList);

            ICompetitionDto competition = new CompetitionDto("Competition " + new Date());

            match.publish(clubTeam, competition);
        }
    }
}
