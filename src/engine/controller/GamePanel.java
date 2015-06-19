package engine.controller;

import java.awt.Graphics2D;
import javax.swing.JPanel;
import engine.model.GameContext;
import engine.settings.KeyMap;
import engine.settings.WindowSettings;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Adrien
 */
public class GamePanel extends JPanel implements Observer, KeyListener, MouseInputListener
{
    public GamePanel()
    {
        super();
        
        this.setFocusable(true);
        this.requestFocus();
        
        updateSettings();
        
        this.addKeyListener(this);
        this.addMouseListener(this);
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

    @Override
    public void keyTyped(KeyEvent ke)
    {
    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        String action = KeyMap.getKeyMap().getActionFromKey(String.valueOf(ke.getKeyChar()));
        
        if(action != null)
            KeyMap.getKeyMap().getActionManager().getAction(action).invoke();
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
    }

    @Override
    public void mouseEntered(MouseEvent me)
    {
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
    }

    @Override
    public void mouseDragged(MouseEvent me)
    {
    }

    @Override
    public void mouseMoved(MouseEvent me)
    {
    }
}
