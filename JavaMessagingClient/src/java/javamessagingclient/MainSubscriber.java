/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

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
    public static void main(String[] args)
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        IMemberDto member = new MemberDto("tsc", "Thomas", "Schwarz");
                        MatchSubscriberForm frame = new MatchSubscriberForm(member);

                        frame.setVisible(true);

                        List<IDepartmentDto> departments = new LinkedList<IDepartmentDto>();
                        departments.add(new DepartmentDto("Fussball"));

                        IDepartmentHeadDto departmentHead = new DepartmentHeadDto(member);
                        departmentHead.setDepartmentList(departments);

                        MemberSubscriberForm memberForm = new MemberSubscriberForm(departmentHead);

                        memberForm.setVisible(true);
                    }
                ;
    }

);
    }
}
