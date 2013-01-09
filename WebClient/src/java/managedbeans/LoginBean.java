/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import contract.dto.IMemberDto;
import contract.ejb.business.ILoginRemote;
import contract.ejb.business.IPermissionControllerRemote;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean
{
    @EJB private IPermissionControllerRemote permissionControllerBean;
    @EJB private ILoginRemote loginBean;
    private IMemberDto user = null;
    private String username;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean()
    {
    }

    /**
     * login a user and set permission controller for user
     * @return index
     */
    public String login()
    {
        this.user = loginBean.getMemberByUsername(username);
        permissionControllerBean.setMember(this.user);
        return "index";
    }
    
    /**
     * logs out a user by setting user property to null
     * @return "index" to return to index.xhtml
     */
    public String logout()
    {
        this.user = null;
        permissionControllerBean.setMember(null);
        return "index";
    }
    
    /**
     * if logged then user property is not null
     * @return true if logged in
     */
    public boolean isLoggedIn()
    {
        return user != null;
    }

    /**
     * check for write permission
     * @return true if user is allowed to
     */
    public boolean isPermitedToWrite()
    {
        if(user == null)
        {
            return false;
        }
        return permissionControllerBean.hasPermission("write");
    }
    
    public IMemberDto getUser()
    {
        return user;
    }

    public void setUser(IMemberDto user)
    {
        this.user = user;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
