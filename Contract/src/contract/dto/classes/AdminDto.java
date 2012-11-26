/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.classes;

import java.util.HashMap;
import contract.dto.IAdminDto;

/**
 @author Thomas
 */
public class AdminDto
        extends RoleDto
        implements IAdminDto
{
    public AdminDto()
    {
        super();

        this.setName("Admin");
        this.setDescription("Admin");
    }
    private static HashMap<contract.domain.IAdmin, AdminDto> admins = new HashMap<>();

    public static AdminDto copy(contract.domain.IAdmin admin)
    {
        AdminDto a;

        if (admins.containsKey(admin))
        {
            a = admins.get(admin);
        }
        else
        {
            a = copy(admin, new AdminDto());

            admins.put(admin, a);
        }

        return a;
    }
}
