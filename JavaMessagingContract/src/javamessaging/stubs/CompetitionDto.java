/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javamessaging.stubs;

import javamessaging.stubs.*;

/**

 @author Thomas
 */
public class CompetitionDto
        implements ICompetitionDto
{
    String name;

    public CompetitionDto(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
