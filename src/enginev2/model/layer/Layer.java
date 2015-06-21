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
package enginev2.model.layer;

import enginev2.model.update.UpdateContext;
import enginev2.model.entity.IEntity;
import enginev2.view.drawer.drawers.layers.LayerDrawer;
import enginev2.view.ViewPort;
import enginev2.view.drawer.Drawer;
import java.awt.Graphics;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Adrien
 */
public class Layer implements IEntity
{
    public Layer()
    {
        this.entities = new LinkedList<>();
        this.focusManager = new FocusManager();
        this.layer = null;
    }
    public Layer(FocusManager focusManager)
    {
        this.entities = new LinkedList<>();
        this.focusManager = focusManager;
        this.layer = null;
    }
    
    private Layer layer;
    protected final Collection<IEntity> entities;
    protected final FocusManager focusManager;
    
    public Collection<IEntity> getEntities()
    {
        return entities;
    }
    public void addEntity(IEntity entity)
    {
        entity.setLayer(this);
        entities.add(entity);
    }
    
    public FocusManager getFocusManager()
    {
        return focusManager;
    }

    @Override
    public Drawer getDrawer()
    {
        return LayerDrawer.getInstance();
    }

    @Override
    public void update(UpdateContext context)
    {
        entities.forEach(e -> e.update(context));
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
