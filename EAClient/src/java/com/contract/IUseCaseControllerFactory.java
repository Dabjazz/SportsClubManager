package com.contract;

import com.ServiceNotAvailableException;
import contract.useCaseController.*;

/**
 @author Lins Christian (christian.lins87@gmail.com)
 */
public interface IUseCaseControllerFactory
{
    IAddMatchResultsController getAddMatchResultsController()
            throws ServiceNotAvailableException;

    IAddMemberToTeamController getAddMemberToTeamController()
            throws ServiceNotAvailableException;

    IChangeCompetitionTeamController getChangeCompetitionTeamController()
            throws ServiceNotAvailableException;

    INewCompetitionController getNewCompetitionController()
            throws ServiceNotAvailableException;

    INewMemberController getNewMemberController()
            throws ServiceNotAvailableException;

    ISearchChangeMemberController getSearchChangeMemberController()
            throws ServiceNotAvailableException;

    IShowCompetitionController getShowCompetitionController()
            throws ServiceNotAvailableException;

    ILogin getLoginController()
            throws ServiceNotAvailableException;

    IAddressController getAddressController()
            throws ServiceNotAvailableException;

    IMembershipController getMembershipController()
            throws ServiceNotAvailableException;

    IPermissionController getPermissionController()
            throws ServiceNotAvailableException;
}
