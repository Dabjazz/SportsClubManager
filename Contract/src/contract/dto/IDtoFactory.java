/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import contract.dto.mapper.*;
import java.io.*;
import java.rmi.RemoteException;

/**

 @author Thomas
 */
public interface IDtoFactory
        extends Serializable
{
    IMapper<IAddressDto> getAddressMapper()
            throws RemoteException;

    IMapper<IAdminDto> getAdminMapper()
            throws RemoteException;

    IMapper<ICaretakerDto> getCaretakerMapper()
            throws RemoteException;

    IClubTeamMapper getClubTeamMapper()
            throws RemoteException;

    IMapper<ICompetitionDto> getCompetitionMapper()
            throws RemoteException;

    IMapper<ICountryDto> getCountryMapper()
            throws RemoteException;

    IMapper<IDepartmentHeadDto> getDepartmentHeadMapper()
            throws RemoteException;

    IMapper<IDepartmentDto> getDepartmentMapper()
            throws RemoteException;

    ILeagueMapper getLeagueMapper()
            throws RemoteException;

    IMapper<IMatchDto> getMatchMapper()
            throws RemoteException;

    IMapper<IMatchresultDto> getMatchresultMapper()
            throws RemoteException;

    IMemberMapper getMemberMapper()
            throws RemoteException;

    IMapper<IPermissionDto> getPermissionMapper()
            throws RemoteException;

    IMapper<IPlayerDto> getPlayerMapper()
            throws RemoteException;

    IMapper<IRoleDto> getRoleMapper()
            throws RemoteException;

    IMapper<ITeamDto> getTeamMapper()
            throws RemoteException;

    IMapper<ITrainerDto> getTrainerMapper()
            throws RemoteException;

    ITypeOfSportMapper getTypeOfSportMapper()
            throws RemoteException;
}
