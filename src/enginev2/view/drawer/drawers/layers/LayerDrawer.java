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
package enginev2.view.drawer.drawers.layers;

import enginev2.model.layer.Layer;
import enginev2.view.ViewPort;
import enginev2.view.drawer.Drawer;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public class LayerDrawer extends Drawer<Layer>
{
    private LayerDrawer()
    { }
    
    private static Drawer drawer = null;
    public static Drawer getInstance()
    {
        if(drawer == null)
            drawer = new LayerDrawer();
        return drawer;
    }

    @Override
    protected boolean isOnTheScreen(Layer obj, ViewPort viewPort)
    {
        return true;
    }

    @Override
    protected void draw(Layer obj, Graphics graphic, ViewPort viewPort)
    {
        obj.getEntities().forEach(e -> e.getDrawer().paint(e, graphic, viewPort));
    }
}
