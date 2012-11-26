/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.PlayerDto;
import java.util.*;
import org.junit.*;
import contract.dto.IPlayerDto;

/**

 @author Thomas
 */
public class PlayerTest
{
    public PlayerTest()
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
        PlayerDto a = new PlayerDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        PlayerDto a = new PlayerDto();

        Assert.assertTrue(a instanceof IPlayerDto);
    }

    @Test
    public void typeOfSportListTest()
    {
        PlayerDto a = new PlayerDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setTypeOfSportList(expected);
        actual = a.getTypeOfSportList();

        Assert.assertEquals(expected.size(), actual.size());

        Assert.assertEquals(expected, actual);
    }
}
