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
package enginev2.model.entity;

import enginev2.model.layer.Layer;
import enginev2.model.Rectangle;
import enginev2.model.vector.Vector;
import enginev2.view.drawer.Drawer;
import enginev2.view.drawer.drawers.EmptyDrawer;

/**
 *
 * @author Adrien
 */
public abstract class GameEntity<V extends Vector> implements IGameEntity<V>
{
    public GameEntity(V location, V size)
    {
        this.bound = new Rectangle<>(location, size);
        this.drawer = EmptyDrawer.getInstance();
        this.layer = null;
    }
    public GameEntity(Rectangle<V> bound)
    {
        this.bound = bound;
        this.drawer = EmptyDrawer.getInstance();
        this.layer = null;
    }
    
    private Drawer drawer;
    private Layer layer;
    private final Rectangle<V> bound;

    @Override
    public Rectangle<V> getBound()
    {
        return bound;
    }

    @Override
    public void setLocation(V location)
    {
        bound.setLocation(location);
    }

    @Override
    public void setSize(V size)
    {
        bound.setSize(size);
    }
    
    protected void setDrawer(Drawer drawer)
    {
        this.drawer = drawer;
    }
    
    @Override
    public Drawer getDrawer()
    {
        return drawer;
    }

    @Override
    public Layer getLayer()
    {
        return layer;
    }
    @Override
    public void setLayer(Layer layer)
    {
        this.layer = layer;
    }
}
