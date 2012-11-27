/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi.client.mapper;

import contract.rmi.services.*;
import contract.useCaseController.*;

/**

 @author Thomas
 */
public class AddressServiceMapper
        implements RmiServiceToServiceMapper<IAddressRmiService, IAddressController>
{
    @Override
    public IAddressController getService(IAddressRmiService rmiService)
    {
        AddressController controller = new AddressController();

        controller.setService(rmiService);
        return controller;
    }
}
