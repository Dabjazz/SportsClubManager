/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.*;
import java.rmi.RemoteException;
import server.dto.mapper.DtoFactory;

/**
 @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginController
        implements ILogin
{
    private static LoginController INSTANCE;
    private DtoFactory dtoFactory = new DtoFactory();

    private LoginController()
    {
    }

    public static ILogin getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new LoginController();
        }
        return INSTANCE;
    }

    @Override
    public IMemberDto getMemberByUserData(IUserDataDto userData)
            throws MemberNotFoundException
    {
        try
        {
            IMemberMapper m = dtoFactory.getMemberMapper();
            return m.getMemberByUsername(userData.getUsername());
        }
        catch (RemoteException | NotFoundException ex)
        {
            throw new MemberNotFoundException(ex);
        }
    }
}
