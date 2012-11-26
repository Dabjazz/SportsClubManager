/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.classes.MatchDto;
import java.util.Date;
import org.easymock.EasyMock;
import org.junit.*;
import contract.dto.IMatchDto;

/**

 @author Thomas
 */
public class MatchTest
{
    public MatchTest()
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
        MatchDto a = new MatchDto();
    }

    @Test
    public void implementsInterfaceTest()
    {
        MatchDto a = new MatchDto();

        Assert.assertTrue(a instanceof IMatchDto);
    }

    @Test
    public void copyTest()
    {
        Date dateFrom = new Date();
        Date dateTo = new Date();

        contract.domain.ITeam hteam = EasyMock.createMock(contract.domain.ITeam.class);
        EasyMock.expect(hteam.getId()).andReturn(1).anyTimes();
        EasyMock.replay(hteam);

        contract.domain.ITeam fteam = EasyMock.createMock(contract.domain.ITeam.class);
        EasyMock.expect(fteam.getId()).andReturn(3).anyTimes();
        EasyMock.replay(fteam);

        contract.domain.IMatchresult result = EasyMock.createMock(contract.domain.IMatchresult.class);
        EasyMock.expect(result.getId()).andReturn(2).anyTimes();
        EasyMock.replay(result);

        contract.domain.ICompetition competition = EasyMock.createMock(contract.domain.ICompetition.class);
        EasyMock.expect(competition.getId()).andReturn(2).anyTimes();
        EasyMock.replay(competition);

        contract.domain.IMatch expected = EasyMock.createMock(contract.domain.IMatch.class);
        EasyMock.expect(expected.getId()).andReturn(2).anyTimes();
        EasyMock.expect(expected.getDateFrom()).andReturn(dateFrom).anyTimes();
        EasyMock.expect(expected.getDateTo()).andReturn(dateTo).anyTimes();
        EasyMock.expect(expected.getForeignteam()).andReturn(fteam).anyTimes();
        EasyMock.expect(expected.getHometeam()).andReturn(hteam).anyTimes();
        EasyMock.expect(expected.getMatchresult()).andReturn(result).anyTimes();
        EasyMock.expect(expected.getCompetition()).andReturn(competition).anyTimes();

        EasyMock.replay(expected);

        MatchDto a = MatchDto.copy(expected);

        Assert.assertTrue(a instanceof IMatchDto);
    }

    @Test
    public void dateFromTest()
    {
        MatchDto a = new MatchDto();

        Date expected = new Date();
        Date actual;

        a.setDateFrom(expected);
        actual = a.getDateFrom();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dateToTest()
    {
        MatchDto a = new MatchDto();

        Date expected = new Date();
        Date actual;

        a.setDateTo(expected);
        actual = a.getDateTo();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void competitionTest()
    {
        MatchDto a = new MatchDto();

        Integer expected = 1;
        Integer actual;

        a.setCompetition(expected);
        actual = a.getCompetition();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void matchresultTest()
    {
        Assert.fail();
//        MatchDto a = new MatchDto();
//
//        Integer expected = 2;
//        Integer actual;
//
//        a.setMatchresult(expected);
//        actual = a.getMatchresult();
//
//        Assert.assertSame(expected, actual);
    }

    @Test
    public void foreignteamTest()
    {
        Assert.fail();
//     MatchDto a = new MatchDto();
//
//        Integer expected = 1;
//        Integer actual;
//
//        a.setForeignteam(expected);
//        actual = a.getForeignteam();
//
//        Assert.assertSame(expected, actual);
    }

    @Test
    public void hometeamTest()
    {
        Assert.fail();
//        MatchDto a = new MatchDto();
//
//        Integer expected = 1;
//        Integer actual;
//
//        a.setHometeam(expected);
//        actual = a.getHometeam();
//
//        Assert.assertSame(expected, actual);
    }
}
