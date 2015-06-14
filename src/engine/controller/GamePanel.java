package engine.controller;

import java.awt.Graphics2D;
import javax.swing.JPanel;
import engine.model.GameContext;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
