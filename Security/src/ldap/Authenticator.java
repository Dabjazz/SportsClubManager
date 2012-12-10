/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap;

import contract.dto.IUserDataDto;
import java.util.*;
import javax.naming.*;
import ldap.contract.IAuthenticator;

/**

 @author Thomas
 */
public class Authenticator
        implements IAuthenticator
{
    private HashMap<Integer, Date> currentConnections = new HashMap<>();

    public Authenticator()
    {
    }

    @Override
    public boolean auth(IUserDataDto userData)
    {
        return true;
//        
//        int hash = (userData.getUsername() + "@@@@" + userData.getPassword()).hashCode();
//
//        Date now = new Date();
//
//        if (currentConnections.containsKey(hash) && currentConnections.get(hash).compareTo(now) > 0)
//        {
//            return true;
//        }
//
//        // Additional properties are taken from jndi.properties
//        Properties env = new Properties();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//        env.put(Context.PROVIDER_URL, "ldaps://ldap.fhv.at:636/dc=uclv,dc=net");
//        env.put(Context.SECURITY_AUTHENTICATION, "simple");
//        env.put(Context.SECURITY_PRINCIPAL, "uid=" + userData.getUsername() + ",ou=fhv,ou=People,dc=uclv,dc=net"); // specify the username
//        env.put(Context.SECURITY_CREDENTIALS, userData.getPassword());
//
//        try
//        {
//            Context ctx = new InitialContext(env);
//            Date availableUntil = new Date();
//            availableUntil.setTime(availableUntil.getTime() + 15 * 60 * 1000);
//            currentConnections.put(hash, availableUntil);
//            ctx.close();
//            return true;
//        }
//        catch (NamingException ex)
//        {
//            // Additional properties are taken from jndi.properties
//            Properties env2 = new Properties();
//            env2.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//            env2.put(Context.PROVIDER_URL, "ldaps://ldap.fhv.at:636/dc=uclv,dc=net");
//            env2.put(Context.SECURITY_AUTHENTICATION, "simple");
//            env2.put(Context.SECURITY_PRINCIPAL, "uid=" + userData.getUsername() + ",ou=apps,dc=uclv,dc=net"); // specify the username
//            env2.put(Context.SECURITY_CREDENTIALS, userData.getPassword());
//
//            try
//            {
//                Context ctx2 = new InitialContext(env2);
//                Date availableUntil2 = new Date();
//                availableUntil2.setTime(availableUntil2.getTime() + 15 * 60 * 1000);
//                currentConnections.put(hash, availableUntil2);
//                ctx2.close();
//                return true;
//            }
//            catch (NamingException ex2)
//            {
//            }
//
//            return false;
      //  }
    }
}
