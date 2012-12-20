/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.webservice;

import java.util.Date;
import javax.xml.bind.annotation.*;

/**

 @author Thomas
 */
@XmlType(propOrder =
{
    "id", "date", "hometeam", "foreignteam", "pointsHometeam",
    "pointsForeignteam"
})
public class MatchresultWs
{
    private int Id;
    private Date date;
    private String hometeam;
    private String foreignteam;
    private double pointsHometeam;
    private double pointsForeignteam;

    public MatchresultWs(int _Id, Date _Date, String _hometeam, String _foreignteam, double _pointsHometeam, double _pointsForeignteam)
    {
        Id = _Id;
        date = _Date;
        hometeam = _hometeam;
        foreignteam = _foreignteam;
        pointsHometeam = _pointsHometeam;
        pointsForeignteam = _pointsForeignteam;
    }

    @XmlElement(name = "id", required = true)
    public int getId()
    {
        return Id;
    }

    @XmlElement(name = "date", required = true)
    public Date getDate()
    {
        return date;
    }

    @XmlElement(name = "hometeam", required = true)
    public String getHometeam()
    {
        return hometeam;
    }

    @XmlElement(name = "foreignteam", required = true)
    public String getForeignteam()
    {
        return foreignteam;
    }

    @XmlElement(name = "pointsHometeam", required = true)
    public double getPointsHometeam()
    {
        return pointsHometeam;
    }

    @XmlElement(name = "pointsForeignteam", required = true)
    public double getPointsForeignteam()
    {
        return pointsForeignteam;
    }
}
