package engine.model.elementary;

import engine.model.elementary.interfaces.GameEntity;
import engine.model.elementary.interfaces.Updatable;
import engine.model.elementary.interfaces.Localisable;
import engine.model.elementary.interfaces.Drawable;
import java.awt.Graphics;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import engine.model.tools.Observable;

/**
 *
 * @author Adrien
 */
public class GameEntityList extends Observable implements Collection<GameEntity>, Drawable, Updatable
{
    public GameEntityList()
    {
        super();
        
        entities = new LinkedList<>();
        updatables = new LinkedList<>();
        drawables = new LinkedList<>();
        
        visible = true;
    }
    
    protected final Collection<GameEntity> entities;
    protected final Collection<Updatable> updatables;
    protected final Collection<Drawable> drawables;
    
    protected boolean visible;

    @Override
    public int size()
    {
        return entities.size();
    }

    @Override
    public boolean isEmpty()
    {
        return entities.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return entities.contains(o);
    }

    @Override
    public Iterator<GameEntity> iterator()
    {
        return entities.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return entities.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return entities.toArray(a);
    }

    @Override
    public boolean add(GameEntity e)
    {
        if(!entities.add(e))
            return false;
        
        if(e instanceof Updatable)
            updatables.add((Updatable)e);
        
        if(e instanceof Drawable)
            drawables.add((Drawable)e);
        
        Collections.sort((List)drawables, Comparator.comparingDouble(d ->
                    {
                        if(d instanceof Localisable)
                            return ((Localisable)d).getLocation().y;
                        else
                            return Double.POSITIVE_INFINITY;
                    }));
        
        notifyChanges();
        
        return true;
    }

    @Override
    public boolean remove(Object o)
    {
        boolean result = entities.remove(o);
        updatables.remove(o);
        drawables.remove(o);
        
        notifyChanges();
        
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return entities.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends GameEntity> c)
    {
        return c.stream().map(e -> add(e)).anyMatch(b -> b);
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        boolean result = entities.removeAll(c);
        updatables.removeAll(c);
        drawables.removeAll(c);
        
        notifyChanges();
        
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        boolean result = entities.retainAll(c);
        updatables.retainAll(c);
        drawables.retainAll(c);
        
        notifyChanges();
        
        return result;
    }

    @Override
    public void clear()
    {
        entities.clear();
        updatables.clear();
        drawables.clear();
        
        notifyChanges();
    }
    

    @Override
    public void update(UpdateContext context)
    {
        updatables.stream()
                .forEach(u -> u.update(context));
    }

    @Override
    public void draw(Graphics graphics, Vector2D screenOffset)
    {
        if(!isVisible())
            return;
        
        drawables.stream()
                .filter(d -> d.isVisible())
                .forEachOrdered(d -> d.draw(graphics, screenOffset));
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
    
}
