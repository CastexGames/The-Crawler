package engine.model.map;

import com.sun.javafx.geom.Rectangle;
import engine.model.elementary.GameEntityList;
import engine.model.elementary.UpdateContext;
import engine.model.elementary.Vector2D;
import engine.model.elementary.interfaces.Drawable;
import engine.model.elementary.interfaces.Localisable;
import engine.model.elementary.interfaces.Sized;
import engine.model.elementary.interfaces.Updatable;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public class Chunk implements Drawable, Localisable, Updatable, Sized
{
    public Chunk(Vector2D size)
    {
        this.location = Vector2D.ZERO;
        this.visible = false;
        this.entityList = new GameEntityList();
        this.size = size;
    }
    
    private Vector2D size;
    private Vector2D location;
    private boolean visible;
    
    protected final GameEntityList entityList;


    @Override
    public void update(UpdateContext context)
    {
        entityList.update(context);
    }
    
    @Override
    public void draw(Graphics graphics, Vector2D screenOffset)
    {
        if(!this.isVisible())
            return;
        
        entityList.draw(graphics, this.getLocation().add(screenOffset));
    }

    @Override
    public boolean isVisible()
    {
        return visible;
    }

    @Override
    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    @Override
    public Vector2D getLocation()
    {
        return location;
    }

    @Override
    public void setLocation(Vector2D location)
    {
        this.location = location;
    }

    @Override
    public double getWidth()
    {
        return size.x;
    }

    @Override
    public double getHeight()
    {
        return size.y;
    }

    @Override
    public Vector2D getSize()
    {
        return size;
    }
}
