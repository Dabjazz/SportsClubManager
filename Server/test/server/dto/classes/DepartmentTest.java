/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.DepartmentDto;
import java.util.*;
import org.junit.*;
import contract.dto.IDepartmentDto;

/**

 @author Thomas
 */
public class DepartmentTest
{
    public DepartmentTest()
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
        DepartmentDto a = new DepartmentDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        DepartmentDto a = new DepartmentDto();

        Assert.assertTrue(a instanceof IDepartmentDto);
    }

    @Test
    public void nameTest()
    {
        DepartmentDto a = new DepartmentDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setName(expected);
        actual = a.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void descriptionTest()
    {
        DepartmentDto a = new DepartmentDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setDescription(expected);
        actual = a.getDescription();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void departmentHeadTest()
    {
        DepartmentDto a = new DepartmentDto();

        Integer expected = 2;
        Integer actual;

        a.setDepartmentHead(expected);
        actual = a.getDepartmentHead();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clubTeamListTest()
    {
        DepartmentDto a = new DepartmentDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setClubTeamList(expected);
        actual = a.getClubTeamList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void typeOfSportListTest()
    {
        DepartmentDto a = new DepartmentDto();
        
        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setTypeOfSportList(expected);
        actual = a.getTypeOfSportList();

        Assert.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < actual.size(); i++)
        {
            Assert.assertEquals(expected, actual);
        }
    }
}
