package engine.settings;

import java.awt.Dimension;
import engine.model.tools.Observable;
import java.awt.Toolkit;

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
    public abstract boolean isFullScreen();
    public abstract String[] getIcon();
    
    
    public final Dimension getScreenSize()
    {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    public final Dimension getDisplaySize()
    {
        if(isFullScreen())
            return getScreenSize();
        else
            return getWindowSize();
    }
}
