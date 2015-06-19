/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.controller;

import engine.settings.ExceptionManager;
import engine.settings.WindowSettings;

/**
 *
 * @author Adrien
 */
public abstract class Runtime implements Runnable
{
    public Runtime()
    {
        this.running = false;
    }
    
    private boolean running;
    
    @Override
    public void run()
    {
        running = true;
        try
        {
            initialize();
            
            while(running)
            {
                long startTime = System.currentTimeMillis();

                loop();
                
                long value = WindowSettings.getWindowSettings().getFPSTime() - (System.currentTimeMillis() - startTime);
                if(value > 0)
                    Thread.sleep(value);
            }
        }
        catch (InterruptedException ex)
        {
            ExceptionManager.getExceptionManager().manager(ex);
        }
    }
    
    public void stop()
    {
        running = false;
    }
    
    protected abstract void initialize();
    protected abstract void loop();
}
