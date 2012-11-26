/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.classes;

import contract.dto.ICaretakerDto;
import java.util.HashMap;

/**
 @author Thomas
 */
public class CaretakerDto
        extends RoleDto
        implements ICaretakerDto
{
    public CaretakerDto()
    {
        super();

        this.setName("Caretaker");
        this.setDescription("Caretaker");
    }
    private static HashMap<contract.domain.ICaretaker, CaretakerDto> admins = new HashMap<>();

    public static CaretakerDto copy(contract.domain.ICaretaker admin)
    {
        CaretakerDto a;

        if (admins.containsKey(admin))
        {
            a = admins.get(admin);
        }
        else
        {
            a = copy(admin, new CaretakerDto());

            admins.put(admin, a);
        }

        return a;
    }
}
