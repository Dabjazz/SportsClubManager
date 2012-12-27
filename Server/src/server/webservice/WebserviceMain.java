/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.webservice;

import javax.xml.ws.Endpoint;

/*
 @author Thomas
 */
public class WebserviceMain
{
    public WebserviceMain()
    {
        Endpoint endpoint = Endpoint.publish("http://localhost:8080/services", new MatchService());
        System.out.println("Webservice started");
    }
}
