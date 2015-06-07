/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.model;

import engine.model.elementary.GameEntityList;
import engine.model.elementary.Vector2D;
import engine.model.elementary.interfaces.Updatable;
import java.awt.Graphics;
import engine.model.tools.Observable;

/**
 *
 * @author Adrien
 */
public class GameContext extends Observable implements Updatable
{
    public GameContext()
    {
        entities = new GameEntityList();
    }
    
    private static GameContext gameContext = null;
    public static GameContext getCurrentGameContext()
    {
        return gameContext;
    }
    public static void setCurrentGameContext(GameContext gameContext)
    {
        GameContext.gameContext = gameContext;
    }
    
    protected GameEntityList entities;

    @Override
    public void update()
    {
        entities.update();
    }

    public void draw(Graphics graphics)
    {
        entities.draw(graphics, Vector2D.ZERO);
    }
}