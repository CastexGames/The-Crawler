package enginev2.controller;

import enginev2.model.update.Updatable;
import enginev2.model.update.UpdateContext;

/**
 *
 * @author Adrien
 */
public class Ticker implements Updatable, IRunnable
{
    public Ticker(Runnable runnable, long animationTick)
    {
        this.runnable = runnable;
        this.animationTick = animationTick;
        this.running = false;
        this.nbTicks = 0;
    }
    
    protected final Runnable runnable;
    protected final long animationTick;
    
    protected boolean running;
    private long nbTicks;
    
    @Override
    public void start()
    {
        running = true;
        nbTicks = 0;
    }
    
    @Override
    public void reset()
    {
        running = false;
        nbTicks = 0;
    }
    
    @Override
    public void pause()
    {
        running = false;
    }
    
    @Override
    public void resume()
    {
        running = true;
    }

    @Override
    public boolean isRunning()
    {
        return running;
    }

    @Override
    public void update(UpdateContext context)
    {
        if(running)
        {
            nbTicks++;
            
            if(nbTicks >= animationTick)
            {
                runnable.run();
                nbTicks -= animationTick;
            }
        }
    }
}
