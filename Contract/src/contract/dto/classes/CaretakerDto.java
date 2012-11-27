/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.classes;

import contract.domain.ICaretaker;
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
    private static HashMap<ICaretaker, CaretakerDto> admins = new HashMap<>();

    public static CaretakerDto copy(ICaretaker admin)
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
