package contract.dto.classes;

import contract.domain.IMatchresult;
import contract.dto.IMatchresultDto;
import java.io.Serializable;
import java.util.HashMap;

public class MatchresultDto
        implements Serializable, IMatchresultDto
{
    private Integer id;
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
    private static HashMap<IMatchresult, MatchresultDto> matchresults = new HashMap<>();

    public static MatchresultDto copy(IMatchresult matchresult)
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

    @Override
    public void setFinal(boolean fin) {
        this.fin = fin;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
}
