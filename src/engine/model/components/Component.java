package engine.model.components;

import engine.model.elementary.GameEntityList;
import engine.model.elementary.Vector2D;
import engine.model.elementary.interfaces.Drawable;
import engine.model.elementary.interfaces.GameEntity;
import engine.model.elementary.interfaces.Localisable;
import engine.model.elementary.interfaces.Updatable;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Adrien
 */
public abstract class Component implements GameEntity, Drawable, Localisable, Updatable
{
    public Component(Component parent)
    {
        this.parent = parent;
        this.visible = true;
        this.location = Vector2D.ZERO;
        this.children = new GameEntityList();
    }
    public Component()
    {
        this(null);
    }
    
    private Component parent;
    private boolean visible;
    private Vector2D location;
    private final GameEntityList children;

    @Override
    public void draw(Graphics graphics, Vector2D screenOffset)
    {
        Vector2D drawLocation = location.add(screenOffset);
        
        drawComponent(graphics, drawLocation);
        
        children.draw(graphics, drawLocation);
    }
    
    protected abstract void drawComponent(Graphics graphics, Vector2D location);

    @Override
    public boolean isVisible()
    {
        return this.visible;
    }

    @Override
    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    @Override
    public Vector2D getLocation()
    {
        return this.location;
    }

    @Override
    public void setLocation(Vector2D location)
    {
        this.location = location;
    }

    @Override
    public void update()
    {
        children.update();
    }
    
    
    public Component getParent()
    {
        return this.parent;
    }
    public void setParent(Component parent)
    {
        if(this.parent != null)
            this.parent.removeChild(this);
        
        if(parent != null)
            parent.addChild(this);
        
        this.parent = parent;
    }
    
    
    
    public void addChild(Component child)
    {
        children.add(this);
    }
    public void addChildren(Collection<Component> childrens)
    {
        children.addAll(childrens);
    }
    public void addChildren(Component[] childrens)
    {
        children.addAll(Arrays.asList(childrens));
    }
    
    public void removeChild(Component child)
    {
        children.remove(child);
    }
    public void removeChildren(Component[] childrens)
    {
        children.removeAll(Arrays.asList(childrens));
    }
    public void removeChildren(Collection<Component> childrens)
    {
        children.removeAll(childrens);
    }
}
