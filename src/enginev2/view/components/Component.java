package enginev2.view.components;

import enginev2.model.entity.GameEntity;
import enginev2.model.entity.IGameEntity;
import enginev2.model.event.Event;
import enginev2.model.update.UpdateContext;
import enginev2.model.vector.vector2d.Vector2D;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Adrien
 */
public abstract class Component extends GameEntity<Vector2D>
{
    public Component(Component parent)
    {
        super(Vector2D.ZERO, Vector2D.ZERO);
        
        this.parent = parent;
        this.visible = true;
        this.children = new LinkedList<>();
        this.focused = false;
        this.canFocus = false;
    }
    public Component()
    {
        this(null);
    }
    
    private Component parent;
    private boolean visible;
    private final Collection<IGameEntity> children;
    
    public boolean isVisible()
    {
        return this.visible;
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    @Override
    public void update(UpdateContext context)
    {
        if(context.isClicked())
            if(intersectWith(context.getClickLocation()))
            {
                if(canFocus())
                {
                    focused = true;
                    getLayer().getFocusManager().setFocused(this);
                }
                onClick(context);
                context.clickHandled();
            }
        
        children.forEach(c -> c.update(context));
    }
    
    public boolean intersectWith(Vector2D location)
    {
        return getBound().intersectWith(location);
    }
    
    public final Event onClick = new Event(this);
    
    protected void onClick(UpdateContext context)
    {
        onClick.invoke();
    }
    
    
    private boolean focused;
    public boolean isFocused()
    {
        return focused;
    }
    
    private boolean canFocus;
    public boolean canFocus()
    {
        return canFocus;
    }
    public void setCanFocus(boolean canFocus)
    {
        this.canFocus = canFocus;
    }
    
    
    public Component getParent()
    {
        return this.parent;
    }
    public void setParent(Component parent)
    {
        if(this.parent != null)
            this.parent.children.remove(this);
        
        if(parent != null)
            parent.children.add(this);
        
        this.parent = parent;
    }
    
    
    
    public Collection<IGameEntity> getChildren()
    {
        return children;
    }
    
    public void addChild(Component child)
    {
        child.setParent(this);
    }
    public void addChildren(Collection<Component> childrens)
    {
        childrens.forEach(c -> addChild(c));
    }
    public void addChildren(Component[] childrens)
    {
        addChildren(Arrays.asList(childrens));
    }
    
    public void removeChild(Component child)
    {
        child.setParent(null);
    }
    public void removeChildren(Component[] childrens)
    {
        removeChildren(Arrays.asList(childrens));
    }
    public void removeChildren(Collection<Component> childrens)
    {
        childrens.forEach(c -> removeChild(c));
    }
}
