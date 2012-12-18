/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ejb.beans;

import contract.dto.IMemberDto;
import contract.dto.IUserDataDto;
import contract.ejb.business.ILoginRemote;
import contract.useCaseController.MemberNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import server.useCaseController.LoginController;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
@Stateful
public class LoginBean implements ILoginRemote
{
    
    public LoginBean() {
        super();
    }

    @Override
    public IMemberDto getMemberByUserData(IUserDataDto userData)
    {
        try
        {
            return LoginController.getInstance().getMemberByUserData(userData );
        }
        catch (MemberNotFoundException ex)
        {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IMemberDto getMemberByUsername(String username)
    {
        try
        {
            return LoginController.getInstance().getMemberByUsername(username);
        } catch (MemberNotFoundException ex)
        {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
