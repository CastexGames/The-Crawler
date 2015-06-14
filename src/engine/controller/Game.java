package engine.controller;

import engine.model.tools.ImageLoader;
import javax.swing.JFrame;
import engine.settings.WindowSettings;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Adrien
 */
public abstract class Game implements Runnable, Observer
{
    public Game()
    {
        window = new JFrame();
    }
    
    @Override
    public void run()
    {
        initializeSettings();
        
        initializeGame();
        
        GamePanel gp = new GamePanel();
        window.setContentPane(gp);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        updateSettings();
        
        GameRuntime runtime = new GameRuntime(gp);
        runtime.run();
    }
    
    protected final JFrame window;
    
    protected void updateSettings()
    {
        WindowSettings settings = WindowSettings.getWindowSettings();
        
        window.setVisible(false);
        window.dispose();
        
        window.setTitle(settings.getWindowName());
        window.setResizable(settings.isResizable());
        
        String[] icons = settings.getIcon();
        if(icons == null)
            window.setIconImages(null);
        else
            window.setIconImages(Stream.of(icons)
                    .map(s -> ImageLoader.loadImage(s))
                    .filter(i -> i != null)
                    .collect(Collectors.toList()));
        
        if(settings.isFullScreen())
        {
            window.setUndecorated(true);
            window.setLocation(0, 0);
            window.setPreferredSize(new Dimension(window.getToolkit().getScreenSize().width, window.getToolkit().getScreenSize().height));
        }
        
        window.pack();
        window.setVisible(true);
    }
    
    protected abstract void initializeSettings();
    protected abstract void initializeGame();

    @Override
    public void update(Observable o, Object arg)
    {
        updateSettings();
    }
}
