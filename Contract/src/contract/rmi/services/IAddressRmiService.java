/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.*;
import java.rmi.*;

/**

 @author Thomas
 */
public interface IAddressRmiService
        extends Remote
{
    public ICountryDto getCountryByName(String text)
            throws RemoteException;

    public ICountryDto getCountryById(int country)
            throws RemoteException;

    public IAddressDto getById(Integer id)
            throws RemoteException;
}
