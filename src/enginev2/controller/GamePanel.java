package enginev2.controller;

import enginev2.model.GameContext;
import enginev2.model.update.UpdateContext;
import enginev2.model.vector.vector2d.Vector2D;
import javax.swing.JPanel;
import enginev2.settings.KeyMap;
import enginev2.settings.WindowSettings;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
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
        g = getGraphics();
    }
    
    public static Graphics g;

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
        Vector2D dim = WindowSettings.getWindowSettings().getWindowSize();
        this.setPreferredSize(new Dimension((int)dim.x, (int)dim.y));
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
        Point location = me.getLocationOnScreen();
        UpdateContext.eventReceived(new Vector2D(location.x, location.y));
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
