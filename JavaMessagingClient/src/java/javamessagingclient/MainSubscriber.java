/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

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
                        IMemberDto member = new MemberDto("Thomas");
                        MatchSubscriberForm frame = new MatchSubscriberForm(member);

                        frame.setVisible(true);
                    }
                ;
    }

);
    }
}
