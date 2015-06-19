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

import enginev2.model.vector.Vector;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public abstract class Drawer<T>
{
    public Drawer(T entity)
    {
        this.entity = entity;
    }
    
    private final T entity;
    protected final T getEntity()
    {
        return entity;
    }
    
    public void draw(Graphics graphic, ViewPort viewPort, Vector locationOffset)
    {
        if(!locationOffset.isEmpty())
        {
            try
            {
                viewPort = viewPort.clone();
                viewPort.setLocation(viewPort.getLocation().add(locationOffset));
            }
            catch (CloneNotSupportedException ex)
            { }
        }
        
        if(!viewPort.isEmpty() && isOnTheScreen(viewPort))
            draw(graphic, viewPort);
    }
    
    protected abstract boolean isOnTheScreen(ViewPort viewPort);
    protected abstract void draw(Graphics graphic, ViewPort viewPort);
}
