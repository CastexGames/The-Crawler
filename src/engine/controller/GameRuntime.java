/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.controller;

import engine.model.GameContext;

/**
 *
 * @author Adrien
 */
public class GameRuntime extends Runtime
{
    public GameRuntime(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }
    
    protected final GamePanel gamePanel;

    @Override
    protected void initialize()
    { }

    @Override
    protected void loop()
    {
        GameContext.getCurrentGameContext().update();
        
        gamePanel.draw();
    }
}
