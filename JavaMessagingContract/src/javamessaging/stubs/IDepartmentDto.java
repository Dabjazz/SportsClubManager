/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.stubs;

import java.io.*;
import java.util.List;

/**
 @author Thomas
 */
public interface IDepartmentDto extends Serializable
{
    String getName();
    
    List<IClubTeamDto> getClubTeamList();
}
