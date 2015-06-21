/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginev2.model;

import enginev2.model.update.UpdateContext;
import enginev2.model.update.Updatable;
import enginev2.model.layer.Layer;
import enginev2.model.vector.vector2d.Vector2D;
import enginev2.settings.WindowSettings;
import enginev2.view.ViewPort;
import java.awt.Graphics;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Adrien
 */
public abstract class GameContext implements Updatable
{
    public GameContext()
    {
        this.id = sid++;
        this.layers = new LinkedList<>();
        
        initialize();
    }
    
    public static int sid = 1;
    public final int id;
    
    protected abstract void initialize();
    
    private static GameContext gameContext = null;
    public static GameContext getCurrentGameContext()
    {
        return gameContext;
    }
    public static void setCurrentGameContext(GameContext gameContext)
    {
        GameContext.gameContext = gameContext;
    }
    
    protected final Collection<Layer> layers;
    
    protected void addLayer(Layer layer)
    {
        layers.add(layer);
    }
    
    protected ViewPort createViewPort()
    {
        WindowSettings settings = WindowSettings.getWindowSettings();
        
        return new ViewPort(Vector2D.ZERO, settings.getScreenSize());
    }

    @Override
    public void update(UpdateContext context)
    {
        layers.forEach(l -> l.update(context));
    }

    public void draw(Graphics graphics)
    {
        layers.forEach(l -> l.getDrawer().paint(l, graphics, createViewPort()));
    }
}
