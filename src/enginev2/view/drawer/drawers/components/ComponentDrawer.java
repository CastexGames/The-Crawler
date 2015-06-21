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

import enginev2.view.drawer.drawers.*;
import enginev2.model.layer.Layer;
import enginev2.view.ViewPort;
import enginev2.view.components.Component;
import enginev2.view.drawer.Drawer;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public abstract class ComponentDrawer<T extends Component> extends Drawer<T>
{
    @Override
    protected boolean isOnTheScreen(T obj, ViewPort viewPort)
    {
        return obj.isVisible() && viewPort.getBound().intersectWith(obj.getBound());
    }
    
    @Override
    protected void draw(T obj, Graphics graphic, ViewPort viewPort)
    {
        obj.getChildren().forEach(c -> c.getDrawer().paint(c, graphic, viewPort));
    }
}
