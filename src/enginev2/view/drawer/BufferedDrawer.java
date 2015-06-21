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
import enginev2.model.vector.Vector;
import enginev2.model.vector.vector2d.Vector2D;
import enginev2.view.ViewPort;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Adrien
 */
public abstract class BufferedDrawer<T extends IEntity> extends Drawer<T>
{
    public BufferedDrawer()
    {
        this.buffer = null;
    }
    
    private Image buffer;
    
    @Override
    protected void intermediaryDraw(T obj, Graphics graphic, ViewPort viewPort)
    {
        if(buffer == null || isUpdated(obj))
        {
            // Create a new buffered image
            Vector size = viewPort.getSize();
            buffer = new BufferedImage((int)size.getDimension(0), (int)size.getDimension(1), BufferedImage.TYPE_4BYTE_ABGR);
            
            // Draw on the buffered image
            Graphics bufferGraphic = buffer.getGraphics();
            super.intermediaryDraw(obj, bufferGraphic, viewPort);
            bufferGraphic.dispose();
        }
        
        // Draw the buffered image on the graphics
        graphic.drawImage(buffer, 0, 0, null);
    }
    
    protected abstract boolean isUpdated(T obj);
}
