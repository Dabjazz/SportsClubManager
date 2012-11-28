/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.IMemberDto;
import java.rmi.RemoteException;

/**

 @author Thomas
 */
public interface IPermissionControllerService
{
    IMemberDto getMember()
            throws RemoteException;

    void setMember(IMemberDto member)
            throws RemoteException;

    boolean hasPermission(String permissionName)
            throws RemoteException;
}
