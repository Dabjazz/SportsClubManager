/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.IMemberDto;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import contract.dto.classes.MemberDto;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class MemberMapper
        implements IMemberMapper
{
    private static MemberMapper controller;

    public MemberMapper()
    {
    }

    public static IMemberMapper getInstance()
    {
        if (controller == null)
        {
            controller = new MemberMapper();
        }

        return controller;
    }

    public contract.domain.IMember getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IMember a = DomainFacade.getInstance().getByID(contract.domain.IMember.class, id);
            return a;

        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IMemberDto getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IMember a = DomainFacade.getInstance().getByID(contract.domain.IMember.class, id);
            return MemberDto.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    public IMemberDto getMemberByUsername(String username)
            throws NotFoundException
    {
        try
        {
            contract.domain.IMember a = DomainFacade.getInstance().getMemberByUsername(username);
            System.out.println(a);
            return MemberDto.copy(a);
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public List<IMemberDto> getAll()
            throws NotFoundException
    {
        try
        {
            List<IMemberDto> result = new LinkedList<>();

            for (contract.domain.IMember a : DomainFacade.getInstance().getAll(contract.domain.IMember.class))
            {
                result.add(MemberDto.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IMemberDto value)
    {
        try
        {
            server.domain.classes.Member member = createDomain(value);

            return DomainFacade.getInstance().set(member);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IMemberDto value)
    {
        try
        {
            server.domain.classes.Member member = createDomain(value);

            DomainFacade.getInstance().delete(member);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Member createDomain(IMemberDto value)
            throws IdNotFoundException
    {
        server.domain.classes.Member member = new server.domain.classes.Member(value.getId());


        member.setDateOfBirth(value.getDateOfBirth());
        member.setEmailAddress(value.getEmailAddress());
        member.setGender(value.getGender());
        member.setLastname(value.getLastname());
        member.setMemberFrom(value.getMemberFrom());
        member.setMemberTo(value.getMemberTo());
        member.setPrename(value.getPrename());
        member.setTelephonenumber(value.getTelephonenumber());

        member.setAddress(new AddressMapper().getDomainById(value.getAddress()));
        member.setNationality(new CountryMapper().getDomainById(value.getNationality()));

        List< contract.domain.IRole> roleList = new LinkedList<>();

        for (int i : value.getRoleList())
        {
            //TODO 
        }

        member.setRoleList(roleList);

        return member;
    }

    @Override
    public IMemberDto getNew()
    {
        return new MemberDto();
    }
}
