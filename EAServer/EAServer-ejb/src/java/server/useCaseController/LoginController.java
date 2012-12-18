/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.IMemberDto;
import contract.dto.IUserDataDto;
import contract.dto.mapper.IMemberMapper;
import contract.dto.mapper.NotFoundException;
import contract.useCaseController.ILogin;
import contract.useCaseController.MemberNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.dto.mapper.DtoFactory;

/**
 * @author Lins Christian (christian.lins87@gmail.com)
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
        } catch (NotFoundException ex)
        {
            throw new MemberNotFoundException(ex);
        }
    }

    @Override
    public IMemberDto getMemberByUsername(String username) throws MemberNotFoundException
    {
        try
        {
            IMemberMapper m = dtoFactory.getMemberMapper();
            return m.getMemberByUsername(username);
        } catch (NotFoundException ex)
        {
            throw new MemberNotFoundException(ex);
        }
    }
}
