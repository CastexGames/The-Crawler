package engine.model.elementary;

/**
 *
 * @author Adrien
 */
public class Angle
{
    public Angle()
    {
        angleRad = 0.0;
    }
    public Angle(double angleRad)
    {
        this.angleRad = angleRad;
    }
    public Angle(int angleDeg)
    {
        angleRad = degToRad(angleDeg);
    }
    
    private final double angleRad;
    
    public Angle mul(double coef)
    {
        return new Angle(this.angleRad * coef);
    }
    public Angle div(double coef)
    {
        return new Angle(this.angleRad / coef);
    }
    
    public Angle addRad(double valueRad)
    {
        return new Angle(this.angleRad + valueRad);
    }
    public Angle addDeg(double valueDeg)
    {
        return new Angle(this.angleRad + degToRad(valueDeg));
    }
    
    public Angle subRad(double valueRad)
    {
        return new Angle(this.angleRad + valueRad);
    }
    public Angle subDeg(double valueDeg)
    {
        return new Angle(this.angleRad - degToRad(valueDeg));
    }
    
    public Angle add(Angle angle)
    {
        return new Angle(this.angleRad + angle.angleRad);
    }
    public Angle sub(Angle angle)
    {
        return new Angle(this.angleRad - angle.angleRad);
    }
    
    public Angle getNeg()
    {
        return new Angle(-angleRad);
    }
    
    
    public double toDeg()
    {
        return radToDeg(angleRad);
    }
    public double toRad()
    {
        return angleRad;
    }
    public double toBoundedDeg()
    {
        double value = radToDeg(angleRad);
        if(value > 0)
        {
            while(value > MAX_DEG)
                value -= MAX_DEG;
        }
        else if(value < 0)
        {
            while(value < 0)
                value += MAX_DEG;
        }
        return value;
    }
    public double toBoundedRad()
    {
        double value = angleRad;
        if(value > 0)
        {
            while(value > MAX_RAD)
                value -= MAX_RAD;
        }
        else if(value < 0)
        {
            while(value < 0)
                value += MAX_RAD;
        }
        return value;
    }
    
    public double toRotationCoef()
    {
        return Math.cos(angleRad) + Math.sin(angleRad);
    }
    
    
    public static double radToDeg(double angle)
    {
        return (angle * 360) / (2 * Math.PI);
    }
    public static double degToRad(double angle)
    {
        return (angle * 2 * Math.PI) / 360;
    }
    
    /**
     * Represents an angle of 0° (0 rad).
     */
    public static Angle ZERO = new Angle(0.0);
    
    /**
     * Represents an angle of 90° (PI/2 rad).
     */
    public static Angle D90 = new Angle(degToRad(90));
    
    /**
     * Represents an angle of 180° (PI rad).
     */
    public static Angle D180 = new Angle(degToRad(180));
    
    /**
     * Represents an angle of 270° (PI * 3/2 rad).
     */
    public static Angle D270 = new Angle(degToRad(270));
    
    /**
     * PI
     */
    public static Angle PI = new Angle(Math.PI);
    
    /**
     * PI / 2
     */
    public static Angle PI2 = new Angle(2*Math.PI);
    
    /**
     * PI / 4
     */
    public static Angle PI4 = new Angle(Math.PI/4);
    
    
    public static double MAX_RAD = Math.PI * 2;
    public static double MAX_DEG = 360;

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Angle)
            return this.hashCode() == o.hashCode();
        return false;
    }

    @Override
    public int hashCode()
    {
        double angle = toBoundedRad();
        
        return 53 * 5 + (int) (Double.doubleToLongBits(angle) ^ (Double.doubleToLongBits(angle) >>> 32));
    }
}
