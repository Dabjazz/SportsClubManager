/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.IMemberDto;
import java.io.Serializable;

/**

 @author Thomas
 */
public interface IPermissionController
        extends Serializable
{
    IMemberDto getMember();

    void setMember(IMemberDto member);

    boolean hasPermission(String permissionName);
}
