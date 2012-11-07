/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import domain.classes.League;
import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import domain.contract.*;

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
        League a = new League();
    }

    @Test
    public void implementsInterfaceTest()
    {
        League a = new League();

        Assert.assertTrue(a instanceof ILeague);
    }

    @Test
    public void hibernateContructorTest()
    {
        Integer idLeague = new Random().nextInt();

        League a = new League(idLeague);

        Assert.assertEquals(idLeague, a.getId());
    }

    @Test
    public void secondHibernateContructorTest()
    {
        Integer idLeague = new Random().nextInt();
        String name = new Random().nextInt() + "";

        League a = new League(idLeague, name);

        Assert.assertEquals(idLeague, a.getId());
    }

    @Test
    public void idLeagueTest()
    {
        League a = new League();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setId(expected);
        actual = a.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nameTest()
    {
        League a = new League();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setName(expected);
        actual = a.getName();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void descriptionTest()
    {
        League a = new League();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setDescription(expected);
        actual = a.getDescription();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void teamListTest()
    {
        League a = new League();

        List<ITeam> expected = new LinkedList<ITeam>();
        expected.add(EasyMock.createMock(ITeam.class));
        expected.add(EasyMock.createMock(ITeam.class));
        expected.add(EasyMock.createMock(ITeam.class));

        List<ITeam> actual;

        a.setTeamList(expected);
        actual = a.getTeamList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
