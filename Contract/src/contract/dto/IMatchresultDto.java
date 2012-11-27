/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

/**

 @author Thomas
 */
public interface IMatchresultDto
        extends IDto
{
    double getPointsForeignteam();

    double getPointsHometeam();

    void setPointsForeignteam(double pointsForeignteam);

    void setPointsHometeam(double pointsHometeam);

    public boolean IsFinal();
    
    void setFinal(boolean fin);
}
