/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.mapper;

import contract.dto.IMemberDto;
import contract.ejb.business.IPermissionControllerRemote;
import contract.useCaseController.IPermissionController;

/**
 *
 * @author Thomas
 */
public class PermissionControllerServiceMapper
        implements IPermissionController {

    private IPermissionControllerRemote service;

    public PermissionControllerServiceMapper(IPermissionControllerRemote service) {
        this.service = service;
    }

    @Override
    public IMemberDto getMember() {

        return service.getMember();

    }

    @Override
    public void setMember(IMemberDto member) {

        service.setMember(member);

    }

    @Override
    public boolean hasPermission(String permissionName) {

        return service.hasPermission(permissionName);

    }
}
