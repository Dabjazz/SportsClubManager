/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.TeamDto;
import contract.dto.classes.ClubTeamDto;
import contract.dto.IClubTeamDto;
import java.util.*;
import org.junit.*;

/**

 @author Thomas
 */
public class ClubTeamTest
{
    public ClubTeamTest()
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
        ClubTeamDto a = new ClubTeamDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        ClubTeamDto a = new ClubTeamDto();

        Assert.assertTrue(a instanceof IClubTeamDto);
    }

    @Test
    public void implementsSuperclassTest()
    {
        ClubTeamDto a = new ClubTeamDto();

        Assert.assertTrue(a instanceof TeamDto);
    }

    @Test
    public void departmentListTest()
    {
        ClubTeamDto a = new ClubTeamDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setDepartmentList(expected);
        actual = a.getDepartmentList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void trainerListTest()
    {
        ClubTeamDto a = new ClubTeamDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setTrainerList(expected);
        actual = a.getTrainerList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void playerListTest()
    {
        ClubTeamDto a = new ClubTeamDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setPlayerList(expected);
        actual = a.getPlayerList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
