/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.ejb.business;

import contract.dto.IMemberDto;
import javax.ejb.Remote;


/**
 *
 * @author Thomas
 */
@Remote
public interface IPermissionControllerRemote {

    IMemberDto getMember();

    void setMember(IMemberDto member);

    boolean hasPermission(String permissionName);
}
