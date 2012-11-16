/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

import java.io.Serializable;
import java.util.*;

/**

 @author Thomas
 */
public interface ICompetition
        extends Serializable, IDto
{
    Date getDateFrom();

    Date getDateTo();

    List<Integer> getMatchList();

    Double getPayment();

    List<Integer> getTeamList();
    
    Integer getLeague();
    
    Integer getSport();
    
    void setSport(Integer typeOfSport);
    
    void setLeague(Integer league);

    void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setMatchList(List<Integer> matchList);

    void setPayment(Double payment);

    void setTeamList(List<Integer> teamList);
}
