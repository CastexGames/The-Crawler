package engine.model.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import engine.model.elementary.interfaces.Drawable;
import engine.model.elementary.interfaces.GameEntity;
import engine.model.elementary.interfaces.Localisable;
import engine.model.elementary.Vector2D;
import engine.model.tools.ImageLoader;
import java.awt.Color;

/**
 *
 * @author Adrien
 */
public class UniformPicture extends Picture
{
    public UniformPicture(Color backgroundColor, Color borderColor)
    {
        super(null);
        
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }
    public UniformPicture(Color backgroundColor)
    {
        this(backgroundColor, null);
    }
    
    protected Color backgroundColor;
    protected Color borderColor;
    
    public Color getBackgroundColor()
    {
        return backgroundColor;
    }
    public void setBackgroundColor(Color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }
    
    public Color getBorderColor()
    {
        return borderColor;
    }
    public void setBorderColor(Color borderColor)
    {
        this.borderColor = borderColor;
    }

    @Override
    public void draw(Graphics graphics, Vector2D screenOffset)
    {
        if(!isVisible())
            return;
        
        Vector2D drawLocation = this.getLocation().add(screenOffset);
        
        if(backgroundColor != null)
        {
            graphics.setColor(backgroundColor);
            graphics.fillRect((int)drawLocation.x, (int)drawLocation.y, (int)size.x, (int)size.y);
        }
        
        if(borderColor != null)
        {
            graphics.setColor(borderColor);
            graphics.drawRect((int)drawLocation.x, (int)drawLocation.y, (int)size.x, (int)size.y);
        }
    }
}
