/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.*;
import java.rmi.*;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**

 @author Thomas
 */
public class PermissionController
        implements IPermissionController
{
    private IMemberDto member;
    private DtoFactory dtoFactory = new DtoFactory();
    private static IPermissionController INSTANCE;

    public static IPermissionController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new PermissionController();
        }
        return INSTANCE;
    }

    @Override
    public IMemberDto getMember()
    {
        return member;
    }

    @Override
    public void setMember(IMemberDto member)
    {
        this.member = member;
    }

    @Override
    public boolean hasPermission(String permissionName)
    {
        try
        {
            IMapper<IRoleDto> roleMapper = dtoFactory.getRoleMapper();
            IMapper<IPermissionDto> permissionMapper = dtoFactory.getPermissionMapper();

            for (int rI : member.getRoleList())
            {
                try
                {
                    IRoleDto role = roleMapper.getById(rI);

                    for (int perm : role.getPermisssionList())
                    {
                        String tmp = permissionMapper.getById(perm).getName();
                        if (permissionMapper.getById(perm).getName().equals(permissionName))
                        {
                            return true;
                        }
                    }
                }
                catch (IdNotFoundException ex)
                {
                    Logger.getLogger(PermissionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(PermissionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
