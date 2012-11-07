/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.*;

/**
 @author Thomas
 */
public interface ICompetition extends IDomain
{
    Date getDateFrom();

    Date getDateTo();

    List<IMatch> getMatchList();

    Double getPayment();

    List<ITeam> getTeamList();

    void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setMatchList(List<IMatch> matchList);

    void setPayment(Double payment);

    void setTeamList(List<ITeam> teamList);
}
