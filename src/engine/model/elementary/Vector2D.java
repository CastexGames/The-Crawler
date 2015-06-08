/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.model.elementary;

/**
 *
 * @author Adrien
 */
public class Vector2D
{
    public Vector2D()
    {
        this(0, 0);
    }
    public Vector2D(double value)
    {
        this.x = value;
        this.y = value;
    }
    public Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public final double x;
    public final double y;
    
    public Vector2D add(Vector2D vector)
    {
        return new Vector2D(x + vector.x, y + vector.y);
    }
    public Vector2D sub(Vector2D vector)
    {
        return new Vector2D(x - vector.x, y - vector.y);
    }
    public Vector2D mul(Vector2D vector)
    {
        return new Vector2D(x * vector.x, y * vector.y);
    }
    public Vector2D div(Vector2D vector)
    {
        return new Vector2D(x / vector.x, y / vector.y);
    }
    
    public Vector2D add(double value)
    {
        return new Vector2D(x + value, y + value);
    }
    public Vector2D sub(double value)
    {
        return new Vector2D(x - value, y - value);
    }
    public Vector2D mul(double value)
    {
        return new Vector2D(x * value, y * value);
    }
    public Vector2D div(double value)
    {
        return new Vector2D(x / value, y / value);
    }
    
    public double getDistance(Vector2D vector)
    {
        double x1 = vector.x - this.x;
        double y1 = vector.y - this.y;
        
        return Math.sqrt(x1*x1 - y1*y1);
    }
    
    public static final Vector2D ONE = new Vector2D(1, 1);
    public static final Vector2D ZERO = new Vector2D(0, 0);
    public static final Vector2D X = new Vector2D(1, 0);
    public static final Vector2D Y = new Vector2D(0, 1);

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Vector2D)
        {
            Vector2D v = (Vector2D)o;
            return v.x == this.x && v.y == this.y;
        }
        
        return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }
}
