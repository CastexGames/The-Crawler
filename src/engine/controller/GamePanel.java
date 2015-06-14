package engine.controller;

import java.awt.Graphics2D;
import javax.swing.JPanel;
import engine.model.GameContext;
import engine.settings.WindowSettings;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Adrien
 */
public class GamePanel extends JPanel implements Observer
{
    public GamePanel()
    {
        super();
        
        this.setFocusable(true);
        this.requestFocus();
        
        updateSettings();
    }

    @Override
    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        
        GameContext.getCurrentGameContext().draw(graphics);
    }

    public void draw()
    {
        this.repaint();
    }
    
    protected void updateSettings()
    {
        this.setPreferredSize(WindowSettings.getWindowSettings().getWindowSize());
    }

    @Override
    public void update(Observable o, Object o1)
    {
        updateSettings();
    }
}
