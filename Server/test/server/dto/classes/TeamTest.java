/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.TeamDto;
import contract.dto.ITeamDto;
import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;

/**

 @author Thomas
 */
public class TeamTest
{
    public TeamTest()
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
        TeamDto a = new TeamDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        TeamDto a = new TeamDto();

        Assert.assertTrue(a instanceof ITeamDto);
    }

    @Test
    public void nameTest()
    {
        TeamDto a = new TeamDto();

        String expected = new Random().nextInt() + "";
        String actual;

        a.setName(expected);
        actual = a.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void descriptionTest()
    {
        TeamDto a = new TeamDto();

        String expected = new Random().nextInt() + "";
        String actual;

        a.setDescription(expected);
        actual = a.getDescription();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void competitionListTest()
    {
        TeamDto a = new TeamDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setCompetitionList(expected);
        actual = a.getCompetitionList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void matchListTest()
    {
        TeamDto a = new TeamDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setMatchList(expected);
        actual = a.getMatchList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void leagueTest()
    {
        TeamDto a = new TeamDto();

        Integer expected =3;
        Integer actual;

        a.setLeague(expected);
        actual = a.getLeague();

        Assert.assertEquals(expected, actual);
    }
}
