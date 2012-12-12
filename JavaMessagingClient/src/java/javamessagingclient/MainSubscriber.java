/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import com.sun.tracing.dtrace.*;
import java.util.*;
import javamessaging.stubs.*;

/**

 @author Thomas
 */
public class MainSubscriber
{
    /**
     @param args the command line arguments
     */
    public static void main(final String[] args)
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (args.length == 0)
                        {
                            System.out.println("There is no mode selected");
                        }

                        IMemberDto member = new MemberDto("tsc", "Thomas", "Schwarz");
                        if (args[0].equals("Member"))
                        {
                            MatchSubscriberForm frame = new MatchSubscriberForm(member);

                            frame.setVisible(true);
                        }
                        else if (args[0].equals("Team"))
                        {
                            List<IClubTeamDto> clubTeams = new LinkedList<IClubTeamDto>();
                            clubTeams.add(new ClubTeamDto("team 1"));
                            clubTeams.add(new ClubTeamDto("team 2"));
                            clubTeams.add(new ClubTeamDto("team 3"));

                            IDepartmentDto department = new DepartmentDto("Fussball");
                            department.setClubTeamList(clubTeams);
                            List<IDepartmentDto> departments = new LinkedList<IDepartmentDto>();
                            departments.add(department);

                            IDepartmentHeadDto departmentHead = new DepartmentHeadDto(member);
                            departmentHead.setDepartmentList(departments);

                            MemberSubscriberForm memberForm = new MemberSubscriberForm(departmentHead);

                            memberForm.setVisible(true);
                        }
                    }
                ;
    }

);
    }
}
