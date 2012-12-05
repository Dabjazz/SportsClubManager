/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessagingclient;

import java.util.logging.*;
import javamessaging.stubs.IDepartmentHeadDto;
import javax.jms.*;
import javax.naming.*;

/**
 @author Thomas
 */
public class MemberSubscriberJms
{
    IDepartmentHeadDto departmentHead;

    public IDepartmentHeadDto getDepartmentHead()
    {
        return departmentHead;
    }

    public void setDepartmentHead(IDepartmentHeadDto departmentHead)
    {
        this.departmentHead = departmentHead;
    }

    public MemberSubscriberJms(IDepartmentHeadDto departmentHead)
    {
        this.departmentHead = departmentHead;
    }

    public void read(MessageListener messageListener, ExceptionListener exceptionListener)
    {
        try
        {
            // get the initial context
            InitialContext ctx = new InitialContext();

            // lookup the topic object
            Topic topic = (Topic) ctx.lookup("topic/memberAddedToDepartmentTopic");

            // lookup the topic connection factory
            TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("topic/memberAddedToDepartmentFactory");

            // create a topic connection
            TopicConnection topicConn = connFactory.createTopicConnection();
            topicConn.setClientID(departmentHead.getMember().getUsername());
            // create a topic session
            TopicSession topicSession = topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            // create a topic subscriber
            TopicSubscriber topicSubscriber = topicSession.createDurableSubscriber(topic, departmentHead.getMember().getUsername());

            // set an asynchronous message listener
            topicSubscriber.setMessageListener(messageListener);

            // set an asynchronous exception listener on the connection
            topicConn.setExceptionListener(exceptionListener);

            // start the connection
            topicConn.start();

            // wait for messages
            System.out.println("waiting for messages");
            for (int i = 0; i < 10; i++)
            {
                Thread.sleep(1000);
                System.out.print(".");
            }
            System.out.println();

            // close the topic connection
            topicConn.close();
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(MemberSubscriberJms.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (JMSException ex)
        {
            Logger.getLogger(MemberSubscriberJms.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NamingException ex)
        {
            Logger.getLogger(MemberSubscriberJms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
