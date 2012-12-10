/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.stubs;

import javamessaging.stubs.*;

/**

 @author Thomas
 */
public class PlayerDto
        implements IPlayerDto
{
    IMemberDto member;

    public PlayerDto(IMemberDto member)
    {
        this.member = member;
    }

    @Override
    public IMemberDto getMember()
    {
        return member;
    }
}
