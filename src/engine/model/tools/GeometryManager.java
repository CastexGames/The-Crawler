package engine.model.tools;

import engine.model.elementary.Angle;
import engine.model.elementary.Vector2D;

/**
 *
 * @author Adrien
 */
public abstract class GeometryManager
{
    public static double rotate(double point1D, Angle angle)
    {
        return point1D * angle.toRotationCoef();
    }
    public static double rotate(double point1D, Angle angle, double rotationRef)
    {
        return (point1D - rotationRef) * angle.toRotationCoef() + rotationRef;
    }
    
    public static Vector2D rotate(Vector2D point2D, Angle angle)
    {
        return new Vector2D(
                rotate(point2D.x, angle),
                rotate(point2D.y, angle)
        );
    }
    public static Vector2D rotate(Vector2D point2D, Angle angle, Vector2D rotationRef)
    {
        return new Vector2D(
                rotate(point2D.x, angle, rotationRef.x),
                rotate(point2D.y, angle, rotationRef.y)
        );
    }
}
