package engine.model.hitbox;

import engine.model.elementary.interfaces.Rotatable;
import engine.model.elementary.Angle;
import engine.model.elementary.Rectangle;
import engine.model.elementary.Vector2D;
import engine.model.elementary.interfaces.Localisable;
import engine.model.elementary.interfaces.Sized;
import engine.model.tools.GeometryManager;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Adrien
 */
public class RectHitBox extends HitBox implements Rotatable, Localisable, Sized
{
    public RectHitBox(double x, double y, double w, double h, Angle angle)
    {
        this(new Rectangle(x, y, w, h), angle);
    }
    public RectHitBox(double x, double y, double w, double h)
    {
        this(new Rectangle(x, y, w, h));
    }
    public RectHitBox(Rectangle bound)
    {
        this(bound, Angle.ZERO);
    }
    public RectHitBox(Rectangle bound, Angle angle)
    {
        this.bound = bound;
        this.angle = angle;
    }
    
    private Rectangle bound;
    private Angle angle;
    
    
    @Override
    protected Collection<Vector2D> getPoints(Angle angleOffset)
    {
        Vector2D center = getCenter();
        Angle newAngle = angle.add(angleOffset);
        
        return Arrays.asList(new Vector2D[]
        {
            GeometryManager.rotate(bound.getLocation(), newAngle, center),
            GeometryManager.rotate(bound.getLocation().add(bound.getSize()), newAngle, center),
            GeometryManager.rotate(bound.getLocation().add(bound.getSize().mul(Vector2D.X)), newAngle, center),
            GeometryManager.rotate(bound.getLocation().add(bound.getSize().mul(Vector2D.Y)), newAngle, center)
        });
    }
    

    @Override
    public boolean intersectWith(Vector2D point)
    {
        return this.toRectangle().intersectWith(point);
    }

    @Override
    public boolean intersectWith(HitBox otherHitBox, Vector2D offset)
    {
        Vector2D center = getCenter();
        Collection<Vector2D> points = otherHitBox.toPoints();
        
        return points.stream()
                .map(p -> p.add(offset))
                .map(p -> GeometryManager.rotate(p, angle.getNeg(), center))
                .map(p -> bound.intersectWith(p))
                .allMatch(b -> b);
    }
    
    @Override
    public Vector2D getCenter()
    {
        return bound.getLocation().add(bound.getSize().div(2));
    }

    @Override
    public void setAngle(Angle angle)
    {
        this.angle = angle;
    }
    @Override
    public Angle getAngle()
    {
        return angle;
    }

    @Override
    public Vector2D getLocation()
    {
        return bound.getLocation();
    }

    @Override
    public void setLocation(Vector2D location)
    {
        bound.setLocation(location);
    }

    @Override
    public double getWidth()
    {
        return bound.getWidth();
    }

    @Override
    public double getHeight()
    {
        return bound.getHeight();
    }

    @Override
    public Vector2D getSize()
    {
        return bound.getSize();
    }
}
