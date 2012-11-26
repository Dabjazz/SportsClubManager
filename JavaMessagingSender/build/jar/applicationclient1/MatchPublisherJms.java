/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

import applicationclient1.stubs.*;
import java.io.*;
import java.util.logging.*;
import javax.jms.*;
import javax.naming.*;

/**

 @author Thomas
 */
public class MatchPublisherJms
{
    /**
     @param args the command line arguments
     */
    public void publish(IClubTeamDto clubTeam, ICompetitionDto competition)
    {
        try
        {
            // get the initial context
            InitialContext ctx = new InitialContext();

            // lookup the topic object
            Topic topic = (Topic) ctx.lookup("topic/memberAddedToClubTeamTopic");

            // lookup the topic connection factory
            TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("topic/memberAddedToClubTeamFactory");

            // create a topic connection
            TopicConnection topicConn = connFactory.createTopicConnection();

            // create a topic session
            TopicSession topicSession = topicConn.createTopicSession(false, Session.CLIENT_ACKNOWLEDGE);

            // create a topic publisher
            TopicPublisher topicPublisher = topicSession.createPublisher(topic);
            topicPublisher.setDeliveryMode(DeliveryMode.PERSISTENT);

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            for (IPlayerDto player : clubTeam.getPlayerList())
            {
                MatchMessage msg = new MatchMessage(player.getMember(), competition, clubTeam);
                // create the "Hello World" message
                ObjectMessage message = topicSession.createObjectMessage(msg);

                // publish the messages
                topicPublisher.publish(message);

                // print what we did
                System.out.println("published: " + message);
            }
            // close the topic connection
            topicConn.close();
        }
        catch (JMSException ex)
        {
            Logger.getLogger(MatchPublisherJms.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NamingException ex)
        {
            Logger.getLogger(MatchPublisherJms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
