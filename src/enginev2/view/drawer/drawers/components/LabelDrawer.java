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

import enginev2.model.vector.Vector;
import enginev2.view.ViewPort;
import enginev2.view.components.Label;
import enginev2.view.drawer.Drawer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Adrien
 */
public class LabelDrawer extends ComponentDrawer<Label>
{
    public LabelDrawer()
    {
        this.font = null;
        this.color = null;
        this.backgroundColor = null;
    }
    
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 20);
    
    private Font font;
    private Color color;
    private Color backgroundColor;
    
    public Font getFont()
    {
        if(this.font == null)
            this.font = DEFAULT_FONT;
        return this.font;
    }
    public void setFont(Font font)
    {
        this.font = font;
    }
    
    public Color getColor()
    {
        if(this.color == null)
            this.color = DEFAULT_COLOR;
        return this.color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public Color getBackground()
    {
        return this.backgroundColor;
    }
    public void setBackground(Color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }

    @Override
    protected void draw(Label obj, Graphics graphic, ViewPort viewPort)
    {
        Vector location = viewPort.getLocation().add(obj.getBound().getLocation());
        
        if(obj.getValue() == null)
            return;
        
        graphic.setFont(getFont());
        
        if(getBackground() != null)
        {
            Vector size = obj.getBound().getSize();
            if(size.isEmpty())
            {
                obj.updateSize(graphic);
                size = obj.getBound().getSize();
            }
            graphic.setColor(getBackground());
            graphic.fillRect((int)location.getIntDimension(0), (int)location.getIntDimension(1), (int)size.getIntDimension(0), (int)size.getIntDimension(1));
        }
        
        graphic.setColor(getColor());
        
        graphic.drawString(obj.getValue().toString(), (int)(location.getDimension(0) - obj.getPrintOffset().x), (int)(location.getDimension(1) - obj.getPrintOffset().y));
        
        super.draw(obj, graphic, viewPort);
    }
}
