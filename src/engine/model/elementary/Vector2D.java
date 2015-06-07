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
    
    public static final Vector2D ZERO = new Vector2D(0, 0);
    public static final Vector2D X = new Vector2D(1, 0);
    public static final Vector2D Y = new Vector2D(0, 1);
}
