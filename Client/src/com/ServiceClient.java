package com;

import contract.useCaseController.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public interface ServiceClient
{
    IAddMatchResults getAddMatchResultsService()
            throws ServiceNotAvailableException;
    
    IAddMemberToTeam getAddMemberToTeamService()
            throws ServiceNotAvailableException;

    IChangeCompetitionTeam getChangeCompetitionTeamService()
            throws ServiceNotAvailableException;

    INewCompetition getNewCompetitionService()
            throws ServiceNotAvailableException;

    INewMember getNewMemberService()
            throws ServiceNotAvailableException;

    ISearchChangeMember getSearchChangeMemberService()
            throws ServiceNotAvailableException;

    IShowCompetition getShowCompetitionService()
            throws ServiceNotAvailableException;

    ILogin getLoginService()
            throws ServiceNotAvailableException;

    IAddressController getAddressService()
            throws ServiceNotAvailableException;

    IMembershipController getMembershipService()
            throws ServiceNotAvailableException;
}
