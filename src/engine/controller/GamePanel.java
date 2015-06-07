/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.controller;

import java.awt.Graphics2D;
import javax.swing.JPanel;
import engine.model.GameContext;
import engine.settings.WindowSettings;

/**
 *
 * @author Adrien
 */
public class GamePanel extends JPanel
{
    public GamePanel()
    {
        super();
        
        this.setPreferredSize(WindowSettings.getWindowSettings().getWindowSize());
        this.setFocusable(true);
        this.requestFocus();
    }

    public void draw()
    {
        Graphics2D graphics = (Graphics2D)getGraphics();
        
        GameContext.getCurrentGameContext().draw(graphics);
    }
}
