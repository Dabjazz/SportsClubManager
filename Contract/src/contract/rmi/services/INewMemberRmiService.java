package contract.rmi.services;

import contract.dto.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**

 @author Lucia
 */
public interface INewMemberRmiService
        extends Remote
{
    List<IDepartmentDto> getDepartments()
            throws RemoteException;

    List<IClubTeamDto> getClubTeams(List<Integer> clubTeams)
            throws RemoteException;

    void setNewMember(IMemberDto member, IAddressDto address)
            throws RemoteException;

    void setNewTrainer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList)
            throws RemoteException;

    void setNewPlayer(IMemberDto member, IAddressDto address, List<IClubTeamDto> clubTeamList)
            throws RemoteException;

    List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList)
            throws RemoteException;

    List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport)
            throws RemoteException;
    
    List<ITypeOfSportDto> getAllSports() throws RemoteException;
}
