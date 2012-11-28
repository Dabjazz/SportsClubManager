/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.Date;

/**

 @author Thomas
 */
public interface IMatchDto
        extends IDto
{
    Integer getCompetition();

    Date getDateFrom();

    Date getDateTo();

    Integer getForeignteam();

    Integer getHometeam();

    Integer getMatchresult();

    void setCompetition(Integer competition);

    void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setForeignteam(Integer foreignteam);

    void setHometeam(Integer hometeam);

    void setMatchresult(Integer matchresult);
}
