/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginev2.model.vector.vector2d;

import enginev2.model.vector.Vector;
import java.awt.Dimension;

/**
 *
 * @author Adrien
 */
public class Vector2D implements Vector<Vector2D>
{
    public Vector2D()
    {
        this(0, 0);
    }
    public Vector2D(Dimension dim)
    {
        this.x = dim.width;
        this.y = dim.height;
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
    
    public double x;
    public double y;
    
    protected double getX()
    {
        return x;
    }
    protected double getY()
    {
        return y;
    }
    
    @Override
    public Vector2D add(Vector2D vector)
    {
        return new Vector2D(getX() + vector.getX(), getY() + vector.getY());
    }
    @Override
    public Vector2D sub(Vector2D vector)
    {
        return new Vector2D(getX() - vector.getX(), getY() - vector.getY());
    }
    @Override
    public Vector2D mul(Vector2D vector)
    {
        return new Vector2D(getX() * vector.getX(), getY() * vector.getY());
    }
    @Override
    public Vector2D div(Vector2D vector)
    {
        return new Vector2D(getX() / vector.getX(), getY() / vector.getY());
    }
    
    @Override
    public Vector2D add(double value)
    {
        return new Vector2D(getX() + value, getY() + value);
    }
    @Override
    public Vector2D sub(double value)
    {
        return new Vector2D(getX() - value, getY() - value);
    }
    @Override
    public Vector2D mul(double value)
    {
        return new Vector2D(getX() * value, getY() * value);
    }
    @Override
    public Vector2D div(double value)
    {
        return new Vector2D(getX() / value, getY() / value);
    }
    
    @Override
    public double getDistance(Vector2D vector)
    {
        double x1 = vector.getX() - this.getX();
        double y1 = vector.getY() - this.getY();
        
        return Math.sqrt(x1*x1 + y1*y1);
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
            return v.getX() == this.getX() && v.getY() == this.getY();
        }
        
        return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.getX()) ^ (Double.doubleToLongBits(this.getX()) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.getY()) ^ (Double.doubleToLongBits(this.getY()) >>> 32));
        return hash;
    }

    @Override
    protected Vector2D clone() throws CloneNotSupportedException
    {
        return (Vector2D)super.clone();
    }

    @Override
    public String toString()
    {
        return "(" + getX() + ", " + getY() + ")";
    }

    @Override
    public boolean isEmpty()
    {
        return getX() == 0 && getY() == 0;
    }

    @Override
    public boolean isPurelyPositive()
    {
        return getX() >= 0 && getY() >= 0;
    }

    @Override
    public boolean isPurelyNegative()
    {
        return getX() <= 0 && getY() <= 0;
    }

    @Override
    public boolean hasEmptyMember()
    {
        return getX() == 0 || getY() == 0;
    }

    @Override
    public boolean hasPositiveMember()
    {
        return getX() > 0 || getY() > 0;
    }

    @Override
    public boolean hasNegativeMember()
    {
        return getX() < 0 || getY() < 0;
    }
    
    @Override
    public double getDimension(int dimension)
    {
        switch(dimension)
        {
            case 0:
                return getX();
                
            case 1:
                return getY();
                
            default:
                return 0;
        }
    }
    @Override
    public long getIntDimension(int dimension)
    {
        return (long)Math.floor(getDimension(dimension));
    }

    @Override
    public int getDimensionNumber()
    {
        return 2;
    }
}
