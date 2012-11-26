/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.MemberDto;
import java.util.*;
import org.junit.*;
import contract.dto.IMemberDto;

/**

 @author Thomas
 */
public class MemberTest
{
    public MemberTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void emptyConstructorTest()
    {
        MemberDto a = new MemberDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        MemberDto a = new MemberDto();

        Assert.assertTrue(a instanceof IMemberDto);
    }

    @Test
    public void idMemberTest()
    {
        MemberDto a = new MemberDto();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setId(expected);
        actual = a.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void prenameTest()
    {
        MemberDto a = new MemberDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setPrename(expected);
        actual = a.getPrename();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void lastnameTest()
    {
        MemberDto a = new MemberDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setLastname(expected);
        actual = a.getLastname();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void dateOfBirthTest()
    {
        MemberDto a = new MemberDto();

        Date expected = new Date();
        Date actual;

        a.setDateOfBirth(expected);
        actual = a.getDateOfBirth();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void mmemberFromTest()
    {
        MemberDto a = new MemberDto();

        Date expected = new Date();
        Date actual;

        a.setMemberFrom(expected);
        actual = a.getMemberFrom();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void mmemberToTest()
    {
        MemberDto a = new MemberDto();

        Date expected = new Date();
        Date actual;

        a.setMemberTo(expected);
        actual = a.getMemberTo();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void telephonenumberTest()
    {
        MemberDto a = new MemberDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setTelephonenumber(expected);
        actual = a.getTelephonenumber();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void emailAddressTest()
    {
        MemberDto a = new MemberDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setEmailAddress(expected);
        actual = a.getEmailAddress();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void genderTest()
    {
        MemberDto a = new MemberDto();

        boolean expected = true;
        boolean actual = false;

        a.setGender(expected);
        actual = a.getGender();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void nationalityTest()
    {
        MemberDto a = new MemberDto();

        Integer actual;
        Integer country = 4;

        a.setNationality(country);
        actual = a.getNationality();

        Assert.assertEquals(country, actual);
    }

    @Test
    public void addressTest()
    {
        MemberDto a = new MemberDto();

        Integer expected = 2;
        Integer actual;

        a.setAddress(expected);
        actual = a.getAddress();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void roleListTest()
    {
        MemberDto a = new MemberDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setRoleList(expected);
        actual = a.getRoleList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
