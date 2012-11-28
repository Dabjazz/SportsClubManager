/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.IMemberDto;

/**

 @author Thomas
 */
public interface IPermissionController
{
    IMemberDto getMember();

    void setMember(IMemberDto member);

    boolean hasPermission(String permissionName);
}
