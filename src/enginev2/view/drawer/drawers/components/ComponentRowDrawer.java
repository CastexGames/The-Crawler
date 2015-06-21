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
package enginev2.view.drawer.drawers.components;

import enginev2.model.entity.IEntity;
import enginev2.model.entity.IGameEntity;
import enginev2.model.vector.Vector;
import enginev2.model.vector.vector2d.Vector2D;
import enginev2.view.ViewPort;
import enginev2.view.components.ComponentRow;
import enginev2.view.drawer.Drawer;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public class ComponentRowDrawer extends Drawer<ComponentRow>
{
    public ComponentRowDrawer(double gap)
    {
        this.gap = new Vector2D(gap, 0);
    }
    public ComponentRowDrawer()
    {
        gap = new Vector2D(10, 0);
    }
    
    private static Drawer drawer = null;
    public static Drawer getInstance()
    {
        if(drawer == null)
            drawer = new ComponentRowDrawer();
        return drawer;
    }
    
    private final Vector2D gap;
    
    
    @Override
    protected boolean isOnTheScreen(ComponentRow obj, ViewPort viewPort)
    {
        return obj.isVisible() && viewPort.getBound().intersectWith(obj.getBound());
    }
    
    @Override
    protected void draw(ComponentRow obj, Graphics graphic, ViewPort viewPort)
    {
        Vector current = obj.getBound().getLocation();
        
        for(IGameEntity entity : obj.getChildren())
        {
            entity.setLocation(current);
            entity.getDrawer().paint(entity, graphic, viewPort);
            
            current = current.add(entity.getBound().getSize().mul(Vector2D.X)).add(gap);
        }
    }
}
