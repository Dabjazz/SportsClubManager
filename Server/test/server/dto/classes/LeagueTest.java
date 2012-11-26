/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.LeagueDto;
import java.util.*;
import org.junit.*;
import contract.dto.ILeagueDto;

/**

 @author Thomas
 */
public class LeagueTest
{
    public LeagueTest()
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
        LeagueDto a = new LeagueDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        LeagueDto a = new LeagueDto();

        Assert.assertTrue(a instanceof ILeagueDto);
    }

    @Test
    public void nameTest()
    {
        LeagueDto a = new LeagueDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setName(expected);
        actual = a.getName();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void descriptionTest()
    {
        LeagueDto a = new LeagueDto();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setDescription(expected);
        actual = a.getDescription();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void teamListTest()
    {
        LeagueDto a = new LeagueDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setTeamList(expected);
        actual = a.getTeamList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
