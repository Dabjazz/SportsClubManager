/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.useCaseController.*;

/**

 @author Thomas
 */
public class MemberController implements IMemberController
{
           AddressController addressController = new AddressController();

    @Override
    public IAddressController getAddressController()
    {
        return addressController;
    }
}
