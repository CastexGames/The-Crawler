package engine.model.components;

import engine.model.elementary.Vector2D;
import engine.model.image.Picture;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Adrien
 */
public class Label<T extends Object> extends Component
{
    public Label(Component parent, T value)
    {
        super(parent);
        
        this.value = value;
        this.font = null;
        this.color = null;
        this.background = null;
    }
    public Label(T value)
    {
        this(null, value);
    }
    
    private T value;
    private Font font;
    private Color color;
    private Picture background;
    
    public T getValue()
    {
        return this.value;
    }
    public void setValue(T value)
    {
        this.value = value;
    }
    
    public Font getFont()
    {
        return this.font;
    }
    public void setFont(Font font)
    {
        this.font = font;
    }
    
    public Color getColor()
    {
        return this.color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public Picture getBackground()
    {
        return this.background;
    }
    public void setBackground(Picture background)
    {
        this.background = background;
    }

    @Override
    protected void drawComponent(Graphics graphics, Vector2D location)
    {
        if(this.value == null)
            return;
        
        if(this.font != null)
            graphics.setFont(this.font);
        
        if(this.color != null)
            graphics.setColor(this.color);
        
        if(this.background != null)
        {
            Rectangle2D bound = graphics.getFontMetrics().getStringBounds(this.value.toString(), graphics);
            this.background.setSize(new Vector2D(bound.getX(), bound.getY()));
        }
        
        graphics.drawString(this.value.toString(), (int)location.x, (int)location.y);
    }

    @Override
    public double getWidth()
    {
        return getSize().x;
    }

    @Override
    public double getHeight()
    {
        return getSize().y;
    }

    @Override
    public Vector2D getSize()
    {
        Rectangle2D textBound = this.font.getStringBounds(this.value.toString(), null);
        return new Vector2D(textBound.getX(), textBound.getY());
    }
}
