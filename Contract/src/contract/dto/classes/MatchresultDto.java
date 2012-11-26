package contract.dto.classes;

import java.io.Serializable;
import java.util.HashMap;
import contract.dto.IMatchresultDto;

public class MatchresultDto
        implements Serializable, IMatchresultDto
{
    private int id;
    private boolean fin;
    private double pointsHometeam;
    private double pointsForeignteam;

    public MatchresultDto()
    {
    }

    MatchresultDto(int id)
    {
        this.id = id;
    }
    private static HashMap<contract.domain.IMatchresult, MatchresultDto> matchresults = new HashMap<>();

    public static MatchresultDto copy(contract.domain.IMatchresult matchresult)
    {
        MatchresultDto a;

        if (matchresults.containsKey(matchresult))
        {
            a = matchresults.get(matchresult);
        }
        else
        {
            a = new MatchresultDto(matchresult.getId());

            a.setPointsHometeam(matchresult.getPointsHometeam());
            a.setPointsForeignteam(matchresult.getPointsForeignteam());

            matchresults.put(matchresult, a);
        }

        return a;
    }

    @Override
    public double getPointsHometeam()
    {
        return pointsHometeam;
    }

    @Override
    public void setPointsHometeam(double pointsHometeam)
    {
        this.pointsHometeam = pointsHometeam;
    }

    @Override
    public double getPointsForeignteam()
    {
        return pointsForeignteam;
    }

    @Override
    public void setPointsForeignteam(double pointsForeignteam)
    {
        this.pointsForeignteam = pointsForeignteam;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public boolean IsFinal()
    {
        return this.fin;
    }
}
