package enginev2.settings;

import engine.model.tools.Observable;
import enginev2.model.vector.vector2d.Vector2D;
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
    public Vector2D getWindowSize()
    {
        return new Vector2D(getWindowWidth(), getWindowHeight());
    }
    public abstract int getFPS();
    public long getFPSTime()
    {
        return 1000L / getFPS();
    }
    public abstract boolean isFullScreen();
    public abstract String[] getIcon();
    
    
    public final Vector2D getScreenSize()
    {
        return new Vector2D(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    public final Vector2D getDisplaySize()
    {
        if(isFullScreen())
            return getScreenSize();
        else
            return getWindowSize();
    }
}
