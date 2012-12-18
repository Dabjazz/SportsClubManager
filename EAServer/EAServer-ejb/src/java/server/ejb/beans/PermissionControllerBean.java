/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.*;
import contract.ejb.business.IPermissionControllerRemote;
import javax.ejb.Stateful;
import server.useCaseController.*;

/**

 @author Thomas
 */
@Stateful
public class PermissionControllerBean implements IPermissionControllerRemote
{
    public PermissionControllerBean()
    {
        super();
    }

    @Override
    public IMemberDto getMember()
    {
        return PermissionController.getInstance().getMember();
    }

    @Override
    public void setMember(IMemberDto member)
    {
        PermissionController.getInstance().setMember(member);
    }

    @Override
    public boolean hasPermission(String permissionName)
    {
        return PermissionController.getInstance().hasPermission(permissionName);
    }
}
