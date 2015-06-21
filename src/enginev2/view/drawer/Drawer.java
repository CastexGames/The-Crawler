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
package enginev2.view.drawer;

import enginev2.model.entity.IEntity;
import enginev2.settings.ExceptionManager;
import enginev2.model.vector.Vector;
import enginev2.view.ViewPort;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public abstract class Drawer<T extends IEntity>
{
    protected ViewPort transformViewPort(ViewPort viewPort, Vector locationOffset)
    {
        if(!locationOffset.isEmpty())
        {
            try
            {
                viewPort = viewPort.clone();
                viewPort.setLocation(viewPort.getLocation().add(locationOffset));
            }
            catch (CloneNotSupportedException ex)
            {
                ExceptionManager.getExceptionManager().manager(ex);
            }
        }
        
        return viewPort;
    }
    
    public void paint(T obj, Graphics graphic, ViewPort viewPort)
    {
        if(!viewPort.isEmpty() && isOnTheScreen(obj, viewPort))
            intermediaryDraw(obj, graphic, viewPort);
    }
    
    protected void intermediaryDraw(T obj, Graphics graphic, ViewPort viewPort)
    {
        draw(obj, graphic, viewPort);
    }
    
    protected abstract boolean isOnTheScreen(T obj, ViewPort viewPort);
    
    /**
     * Draw the current element (from <i>getEntity()</i>) and draw the children.
     * 
     * @param graphic
     * @param viewPort 
     */
    protected abstract void draw(T obj, Graphics graphic, ViewPort viewPort);
}
