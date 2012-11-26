/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.CompetitionDto;
import java.util.*;
import org.junit.*;
import contract.dto.ICompetitionDto;

/**

 @author Thomas
 */
public class CompetitionTest
{
    public CompetitionTest()
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
        CompetitionDto a = new CompetitionDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        CompetitionDto a = new CompetitionDto();

        Assert.assertTrue(a instanceof ICompetitionDto);
    }

    @Test
    public void dateFromTest()
    {
        CompetitionDto a = new CompetitionDto();

        Date expected = new Date();
        Date actual;

        a.setDateFrom(expected);
        actual = a.getDateFrom();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dateToTest()
    {
        CompetitionDto a = new CompetitionDto();

        Date expected = new Date();
        Date actual;

        a.setDateTo(expected);
        actual = a.getDateTo();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void paymentTest()
    {
        CompetitionDto a = new CompetitionDto();

        Double expected = new Random().nextDouble();
        Double actual;

        a.setPayment(expected);
        actual = a.getPayment();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void teamListTest()
    {
        CompetitionDto a = new CompetitionDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setTeamList(expected);
        actual = a.getTeamList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void matchListTest()
    {
        CompetitionDto a = new CompetitionDto();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setMatchList(expected);
        actual = a.getMatchList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
