package engine.model.elementary;

import engine.model.elementary.interfaces.Localisable;
import engine.model.elementary.interfaces.Sized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Adrien
 */
public class Rectangle implements Sized, Localisable
{
    public Rectangle()
    {
        this(Vector2D.ZERO, Vector2D.ONE.mul(10));
    }
    public Rectangle(double x, double y, double w, double h)
    {
        this(new Vector2D(x, y), new Vector2D(w, h));
    }
    public Rectangle(Vector2D location, Vector2D size)
    {
        this.location = location;
        this.size = size;
    }
    public Rectangle(Vector2D[] locations)
    {
        this(Arrays.asList(locations));
    }
    public Rectangle(Collection<Vector2D> locations)
    {
        double minX = locations.stream().mapToDouble(l -> l.x).min().getAsDouble();
        double minY = locations.stream().mapToDouble(l -> l.y).min().getAsDouble();
        double maxX = locations.stream().mapToDouble(l -> l.x).max().getAsDouble();
        double maxY = locations.stream().mapToDouble(l -> l.y).max().getAsDouble();
        
        this.location = new Vector2D(minX, minY);
        this.size = new Vector2D(maxX - minX, maxY - minY);
    }
    
    private Vector2D location;
    private Vector2D size;

    @Override
    public double getWidth()
    {
        return size.x;
    }

    @Override
    public double getHeight()
    {
        return size.y;
    }
    
    @Override
    public Vector2D getSize()
    {
        return size;
    }
    
    public void setSize(Vector2D size)
    {
        this.size = size;
    }
    public void setSize(double sizeX, double sizeY)
    {
        this.size = new Vector2D(sizeY, sizeY);
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
    public void setLocation(double x, double y)
    {
        this.location = new Vector2D(x, y);
    }
    
    public Vector2D getEndLocation()
    {
        return this.location.add(this.size);
    }
    
    public boolean intersectWith(Vector2D point)
    {
        return point.x >= this.location.x && point.x <= this.getEndLocation().x &&
                point.y >= this.location.y && point.y <= this.getEndLocation().y;
    }
    public boolean intersectWith(Rectangle rectangle)
    {
        boolean intersectY = rectangle.location.y >= this.location.y && rectangle.location.y <= this.getEndLocation().y ||
                rectangle.getEndLocation().y >= this.location.y && rectangle.getEndLocation().y <= this.getEndLocation().y;
        
        if(!intersectY)
            return false;
        
        boolean intersectX = rectangle.location.x >= this.location.x && rectangle.location.x <= this.getEndLocation().x ||
                rectangle.getEndLocation().x >= this.location.x && rectangle.getEndLocation().x <= this.getEndLocation().x;
        
        return intersectX;
    }
}
