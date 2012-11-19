package domain.classes;

import domain.contract.ICaretaker;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Caretaker")
public class Caretaker extends Role
implements ICaretaker, Serializable {
    private static final long serialVersionUID = 1L;

    public Caretaker()
    {
    }

    public Caretaker(Integer id)
    {
        super(id);
    }

}
