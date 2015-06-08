package engine.model.hitbox;

import engine.model.elementary.Angle;
import engine.model.elementary.Rectangle;
import engine.model.elementary.Vector2D;
import engine.model.elementary.interfaces.Localisable;
import engine.model.tools.GeometryManager;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Adrien
 */
public class CircleHitBox extends HitBox implements Localisable
{
    public CircleHitBox(double x, double y, double radius)
    {
        this(new Vector2D(x, y), radius);
    }
    public CircleHitBox(Vector2D location, double radius)
    {
        this.location = location;
        this.radius = radius;
    }
    
    private Vector2D location;
    private double radius;
    
    
    @Override
    protected Collection<Vector2D> getPoints(Angle angleOffset)
    {
        Collection<Vector2D> collection = new ArrayList<>(360);
        Vector2D vectorToTransform = getCenter().add(Vector2D.X.mul(radius));
        
        for(int i = 0; i < 360; i++)
            collection.add(GeometryManager.rotate(vectorToTransform, new Angle(i)));
        
        return collection;
    }
    

    @Override
    public boolean intersectWith(Vector2D point)
    {
        return getCenter().getDistance(point) <= radius;
    }

    @Override
    public boolean intersectWith(HitBox otherHitBox, Vector2D offset)
    {
        Vector2D center = getCenter();
        Collection<Vector2D> points = otherHitBox.toPoints();
        
        return points.stream()
                .map(p -> p.add(offset))
                .map(p -> center.getDistance(p) <= radius)
                .allMatch(b -> b);
    }

    @Override
    public Rectangle toRectangle()
    {
        return new Rectangle(this.location, new Vector2D(radius * 2));
    }
    
    @Override
    public Vector2D getCenter()
    {
        return this.location;
    }

    @Override
    public Vector2D getLocation()
    {
        return location;
    }

    @Override
    public void setLocation(Vector2D location)
    {
        this.location = location;
    }
}
