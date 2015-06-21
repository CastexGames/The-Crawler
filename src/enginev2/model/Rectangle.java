package enginev2.model;

import enginev2.model.vector.Vector;
import enginev2.model.vector.vector2d.Vector2D;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Adrien
 */
public class Rectangle<V extends Vector>
{
    public Rectangle(V location, V size)
    {
        this.location = location;
        this.size = size;
    }
    
    public static Rectangle<Vector2D> createRectangle2D()
    {
        return new Rectangle<>(Vector2D.ZERO, Vector2D.ONE.mul(10));
    }
    public static Rectangle<Vector2D> createRectangle2D(double x, double y, double w, double h)
    {
        return new Rectangle<>(new Vector2D(x, y), new Vector2D(w, h));
    }
    public static Rectangle<Vector2D> createRectangle2D(Vector2D location, Vector2D size)
    {
        return new Rectangle<>(location, size);
    }
    public static Rectangle<Vector2D> createRectangle2D(Vector2D[] locations)
    {
        return createRectangle2D(Arrays.asList(locations));
    }
    public static Rectangle<Vector2D> createRectangle2D(Collection<Vector2D> locations)
    {
        double minX = locations.stream().mapToDouble(l -> l.x).min().getAsDouble();
        double minY = locations.stream().mapToDouble(l -> l.y).min().getAsDouble();
        double maxX = locations.stream().mapToDouble(l -> l.x).max().getAsDouble();
        double maxY = locations.stream().mapToDouble(l -> l.y).max().getAsDouble();
        
        return new Rectangle<>(new Vector2D(minX, minY), new Vector2D(maxX - minX, maxY - minY));
    }
    
    
    
    private V location;
    private V size;

    public double getWidth()
    {
        return size.getDimension(0);
    }

    public double getHeight()
    {
        return size.getDimension(1);
    }

    public double getDepth()
    {
        return size.getDimension(2);
    }
    
    public V getSize()
    {
        return size;
    }
    
    public void setSize(V size)
    {
        this.size = size;
    }

    public V getLocation()
    {
        return location;
    }

    public void setLocation(V location)
    {
        this.location = location;
    }
    
    public V getEndLocation()
    {
        return (V)this.location.add(this.size);
    }
    
    public boolean intersectWith(V point)
    {
        for(int d = 0; d < location.getDimensionNumber(); d++)
            if(point.getDimension(d) < this.location.getDimension(d) || point.getDimension(d) > this.getEndLocation().getDimension(d))
                return false;
        return true;
    }
    public boolean intersectWith(Rectangle rectangle)
    {
        for(int d = 0; d < location.getDimensionNumber(); d++)
        {
            double rectangleLocation = rectangle.location.getDimension(d);
            double rectangleEndLocation = rectangle.getEndLocation().getDimension(d);
            
            double thisEndLocation = this.getEndLocation().getDimension(d);
            double thisLocation = this.location.getDimension(d);
            
            if(!(rectangleLocation >= thisLocation && rectangleLocation <= thisEndLocation ||
                rectangleEndLocation >= thisLocation && rectangleEndLocation <= thisEndLocation))
                return false;
        }
        
        return true;
    }

    @Override
    public String toString()
    {
        return "{ location: "+getLocation()+" ; size: "+getSize()+" ; endLocation: "+getEndLocation()+" }";
    }
}
