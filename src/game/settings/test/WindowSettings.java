/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.settings.test;

/**
 *
 * @author Adrien
 */
public class WindowSettings extends enginev2.settings.WindowSettings
{
    public WindowSettings()
    {
        super();
    }
    
    
    @Override
    public String getWindowName()
    {
        return "The Crawling";
    }
    
    @Override
    public boolean isResizable()
    {
        return false;
    }
    
    @Override
    public int getWindowWidth()
    {
        return 320;
    }
    @Override
    public int getWindowHeight()
    {
        return 240;
    }
    
    @Override
    public int getFPS()
    {
        return 60;
    }
    
    @Override
    public boolean isFullScreen()
    {
        return false;
    }

    @Override
    public String[] getIcon()
    {
        return null;
    }
}
