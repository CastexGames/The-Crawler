package game.controller;

import engine.controller.Game;
import engine.model.GameContext;
import game.MenuContext;

/**
 * Change settings package to change settings set
 */
import game.settings.test.*;

/**
 * Entry point.
 * @author Adrien
 */
public class Main extends Game
{
    public Main()
    {
        super();
    }
    
    /**
     * Entry point.
     * @param args Program parameters.
     */
    public static void main(String[] args)
    {
        Thread th = new Thread(new Main());
        th.run();
    }

    @Override
    protected void initializeSettings()
    {
        System.out.println("Current settings package : " + WindowSettings.class.getPackage().getName());
        engine.settings.WindowSettings.setGlobalWindowSettings(new WindowSettings());
        engine.settings.ExceptionManager.setGloabalExceptionManager(new ExceptionManager());
    }

    @Override
    protected void initializeGame()
    {
        GameContext.setCurrentGameContext(new MenuContext());
    }
}
