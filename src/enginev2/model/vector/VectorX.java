/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginev2.model.vector;

import java.awt.Dimension;

/**
 *
 * @author Adrien
 */
public class VectorX implements Vector<VectorX>
{
    public VectorX()
    {
        this(0, 0);
    }
    public VectorX(Dimension dim)
    {
        this.values = new double[2];
        this.values[0] = dim.width;
        this.values[1] = dim.height;
    }
    public VectorX(double... values)
    {
        this.values = values;
    }
    
    public final double[] values;
    
    @Override
    public VectorX add(VectorX vector)
    {
        double[] vs = new double[getDimensionNumber()];
        for(int d = 0; d < getDimensionNumber(); d++)
            vs[d] = values[d] + vector.values[d];
        return new VectorX(vs);
    }
    @Override
    public VectorX sub(VectorX vector)
    {
        double[] vs = new double[getDimensionNumber()];
        for(int d = 0; d < getDimensionNumber(); d++)
            vs[d] = values[d] - vector.values[d];
        return new VectorX(vs);
    }
    @Override
    public VectorX mul(VectorX vector)
    {
        double[] vs = new double[getDimensionNumber()];
        for(int d = 0; d < getDimensionNumber(); d++)
            vs[d] = values[d] * vector.values[d];
        return new VectorX(vs);
    }
    @Override
    public VectorX div(VectorX vector)
    {
        double[] vs = new double[getDimensionNumber()];
        for(int d = 0; d < getDimensionNumber(); d++)
            vs[d] = values[d] / vector.values[d];
        return new VectorX(vs);
    }
    
    @Override
    public VectorX add(double value)
    {
        double[] vs = new double[getDimensionNumber()];
        for(int d = 0; d < getDimensionNumber(); d++)
            vs[d] = values[d] + value;
        return new VectorX(vs);
    }
    @Override
    public VectorX sub(double value)
    {
        double[] vs = new double[getDimensionNumber()];
        for(int d = 0; d < getDimensionNumber(); d++)
            vs[d] = values[d] - value;
        return new VectorX(vs);
    }
    @Override
    public VectorX mul(double value)
    {
        double[] vs = new double[getDimensionNumber()];
        for(int d = 0; d < getDimensionNumber(); d++)
            vs[d] = values[d] * value;
        return new VectorX(vs);
    }
    @Override
    public VectorX div(double value)
    {
        double[] vs = new double[getDimensionNumber()];
        for(int d = 0; d < getDimensionNumber(); d++)
            vs[d] = values[d] / value;
        return new VectorX(vs);
    }
    
    @Override
    public double getDistance(VectorX vector)
    {
        double concat = 0;
        
        for(int d = 0; d < getDimensionNumber(); d++)
        {
            double v = values[d] - vector.values[d];
            concat += v*v;
        }
        
        return Math.sqrt(concat);
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Vector)
        {
            Vector v = (Vector)o;
            
            if(v.getDimensionNumber() != getDimensionNumber())
                return false;
            
            for(int d = 0; d < getDimensionNumber(); d++)
                if(v.getDimension(d) != values[d])
                    return false;
            
            return true;
        }
        
        return false;
    }

    @Override
    protected VectorX clone() throws CloneNotSupportedException
    {
        return (VectorX)super.clone();
    }

    @Override
    public String toString()
    {
        String result = "(";
        
        for(double value : values)
        {
            if(result.length() > 1)
                result += ", ";
            result += value;
        }
        
        return result + ")";
    }

    @Override
    public boolean isEmpty()
    {
        for(double value : values)
            if(value != 0)
                return false;
        return true;
    }

    @Override
    public boolean isPurelyPositive()
    {
        for(double value : values)
            if(value < 0)
                return false;
        return true;
    }

    @Override
    public boolean isPurelyNegative()
    {
        for(double value : values)
            if(value >= 0)
                return false;
        return true;
    }

    @Override
    public boolean hasEmptyMember()
    {
        for(double value : values)
            if(value == 0)
                return true;
        return false;
    }

    @Override
    public boolean hasPositiveMember()
    {
        for(double value : values)
            if(value > 0)
                return true;
        return false;
    }

    @Override
    public boolean hasNegativeMember()
    {
        for(double value : values)
            if(value < 0)
                return true;
        return false;
    }
    
    @Override
    public double getDimension(int dimension)
    {
        if(dimension < values.length)
            return values[dimension];
        else
            return 0;
    }
    @Override
    public long getIntDimension(int dimension)
    {
        return (long)Math.floor(getDimension(dimension));
    }

    @Override
    public int getDimensionNumber()
    {
        return values.length;
    }
}
