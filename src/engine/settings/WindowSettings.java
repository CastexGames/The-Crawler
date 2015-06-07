/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.settings;

import java.awt.Dimension;
import engine.model.tools.Observable;

/**
 *
 * @author Adrien
 */
public abstract class WindowSettings extends Observable
{
    public WindowSettings()
    { }
    
    private static WindowSettings windowSettings = null;
    public static void setGlobalWindowSettings(WindowSettings windowSettings)
    {
        WindowSettings.windowSettings = windowSettings;
    }
    public static WindowSettings getWindowSettings()
    {
        return windowSettings;
    }
    
    
    public abstract String getWindowName();
    public abstract boolean isResizable();
    public abstract int getWindowWidth();
    public abstract int getWindowHeight();
    public Dimension getWindowSize()
    {
        return new Dimension(getWindowWidth(), getWindowHeight());
    }
    public abstract int getFPS();
    public long getFPSTime()
    {
        return 1000L / getFPS();
    }
}
