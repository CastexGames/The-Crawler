/*
 * Copyright (C) 2015 Adrien
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package enginev2.view;

import enginev2.model.Rectangle;
import enginev2.model.vector.Vector;

/**
 *
 * @author Adrien
 */
public class ViewPort implements Cloneable
{
    public ViewPort(Vector location, Vector size)
    {
        this.bound = new Rectangle<>(location, size);
        
        this.location = location;
        setSize(size);
        
        initialSize = this.size;
        initialLocation = this.location;
        initialEndLocation = this.endLocation;
    }
    
    private Vector location;
    public Vector getLocation()
    {
        return location;
    }
    /**
     * 
     * It changes the size.
     * 
     * @param location 
     */
    public void setLocation(Vector location)
    {
        this.location = location;
        this.size = this.endLocation.sub(location);
    }
    /**
     * 
     * It changes the end location.
     * 
     * @param location 
     */
    public void setLocationAlternative(Vector location)
    {
        this.location = location;
        this.endLocation = location.add(this.size);
        this.bound.setLocation(location);
    }
    
    private Vector endLocation;
    public Vector getEndLocation()
    {
        return endLocation;
    }
    public void setEndLocation(Vector endLocation)
    {
        this.endLocation = endLocation;
        this.size = endLocation.sub(this.location);
        this.bound.setSize(size);
    }
    
    private Vector size;
    public Vector getSize()
    {
        return size;
    }
    public void setSize(Vector size)
    {
        this.size = size;
        this.endLocation = this.location.add(size);
        this.bound.setSize(size);
    }
    
    private final Rectangle<Vector> bound;
    public Rectangle<Vector> getBound()
    {
        return bound;
    }
    
    
    private final Vector initialSize;
    private final Vector initialLocation;
    private final Vector initialEndLocation;
    public Vector getInitialSize()
    {
        return initialSize;
    }
    public Vector getInitialLocation()
    {
        return initialLocation;
    }
    public Vector getInitialEndLocation()
    {
        return initialEndLocation;
    }
    
    
    public boolean isEmpty()
    {
        return endLocation.hasNegativeMember() || endLocation.hasEmptyMember();
    }
    
    @Override
    public ViewPort clone() throws CloneNotSupportedException
    {
        return (ViewPort)super.clone();
    }
}
