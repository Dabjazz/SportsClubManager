/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.IMemberDto;
import contract.dto.IUserDataDto;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucia
 */
public interface ILoginRmiService extends Remote {
    IMemberDto  getMemberByUserData(IUserDataDto userData) throws RemoteException;
    IMemberDto getMemberByUsername(String username) throws RemoteException;
}
