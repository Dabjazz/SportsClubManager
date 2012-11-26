/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.DepartmentHeadDto;
import java.util.*;
import org.junit.*;
import contract.dto.IDepartmentHeadDto;

/**

 @author Thomas
 */
public class DepartmentHeadTest
{
    public DepartmentHeadTest()
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
        DepartmentHeadDto a = new DepartmentHeadDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        DepartmentHeadDto a = new DepartmentHeadDto();

        Assert.assertTrue(a instanceof IDepartmentHeadDto);
    }

    @Test
    public void departmentListTest()
    {
        DepartmentHeadDto a = new DepartmentHeadDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setDepartmentList(expected);
        actual = a.getDepartmentList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
