package engine.model.image;

import engine.controller.IRunnable;
import engine.controller.Ticker;
import engine.model.elementary.UpdateContext;
import engine.model.elementary.Vector2D;
import engine.model.elementary.interfaces.Drawable;
import engine.model.elementary.interfaces.GameEntity;
import engine.model.elementary.interfaces.Localisable;
import engine.model.elementary.interfaces.Updatable;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public class TickAnimatedPicture<T extends AnimatedPicture> implements Updatable, Runnable, IRunnable, Localisable, Drawable, GameEntity
{
    public TickAnimatedPicture(T picture, long animationTick)
    {
        this.picture = picture;
        this.ticker = new Ticker(this, animationTick);
    }
    
    protected final T picture;
    protected final Ticker ticker;
    
    @Override
    public void start()
    {
        ticker.start();
    }
    
    @Override
    public void reset()
    {
        picture.restart();
        
        ticker.reset();
    }
    
    @Override
    public void pause()
    {
        ticker.pause();
    }
    
    @Override
    public void resume()
    {
        ticker.resume();
    }

    @Override
    public boolean isRunning()
    {
        return ticker.isRunning();
    }

    @Override
    public void update(UpdateContext context)
    {
        ticker.update(context);
    }

    @Override
    public void run()
    {
        picture.next();
    }

    @Override
    public Vector2D getLocation()
    {
        return picture.getLocation();
    }

    @Override
    public void setLocation(Vector2D location)
    {
        picture.setLocation(location);
    }

    @Override
    public void draw(Graphics graphics, Vector2D screenOffset)
    {
        picture.draw(graphics, screenOffset);
    }

    @Override
    public boolean isVisible()
    {
        return picture.isVisible();
    }

    @Override
    public void setVisible(boolean visible)
    {
        picture.setVisible(visible);
    }
}
