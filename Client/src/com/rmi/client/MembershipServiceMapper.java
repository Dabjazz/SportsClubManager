/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client;

import com.rmi.client.mapper.*;
import contract.rmi.services.*;
import contract.useCaseController.*;

/**

 @author Thomas
 */
public class MembershipServiceMapper
        implements RmiServiceToServiceMapper<IMembershipRmiService, IMembershipController>
{
    @Override
    public IMembershipController getService(IMembershipRmiService rmiService)
    {
        MembershipController n = new MembershipController();
        n.setService(rmiService);
        return n;
    }
}
