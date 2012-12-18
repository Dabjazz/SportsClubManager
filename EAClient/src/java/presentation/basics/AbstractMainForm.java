package presentation.basics;

import contract.dto.*;
import java.util.List;

/**

 @author Lucia
 */
public class AbstractMainForm
        extends AbstractForm
{
    public AbstractMainForm()
    {
        this(null);
    }

    public AbstractMainForm(AbstractForm parent)
    {
        super(parent);
        //initControls(891, 612);
    }

    public AbstractMainForm(AbstractForm parent, int x, int y)
    {
        super(parent);
        //initControls(x, y);
    }

    private void initControls(int x, int y)
    {
        // setSize(x, y);
    }
//    public void setTxtFieldSports(List<ITypeOfSportDto> selected)
//    {
//        // handle in code
//    }
//
//    public void setPlayerClubTeams(List<IClubTeamDto> selected)
//    {
//    }
//
//    public void setTrainerClubTeams(List<IClubTeamDto> selected)
//    {
//    }
//
//    public List<IClubTeamDto> getClubTeams(ITypeOfSportDto sport)
//    {
//        return null;
//    }
}
