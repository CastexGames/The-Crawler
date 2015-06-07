/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.model.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import engine.model.elementary.interfaces.Drawable;
import engine.model.elementary.interfaces.GameEntity;
import engine.model.elementary.interfaces.Localisable;
import engine.model.elementary.Vector2D;
import engine.model.tools.ImageLoader;

/**
 *
 * @author Adrien
 */
public class Picture implements Localisable, Drawable, GameEntity
{
    public Picture(String name)
    {
        image = ImageLoader.loadImage(name);
        location = Vector2D.ZERO;
        visible = true;
    }
    
    protected BufferedImage image;
    
    protected Vector2D location;
    protected boolean visible;

    @Override
    public Vector2D getLocation()
    {
        return location;
    }
    
    @Override
    public void setLocation(Vector2D location)
    {
        this.location = location;
    }

    @Override
    public void draw(Graphics graphics, Vector2D screenOffset)
    {
        if(!isVisible())
            return;
        
        Vector2D drawLocation = this.getLocation().add(screenOffset);
        graphics.drawImage(image, (int)drawLocation.x, (int)drawLocation.y, null);
    }

    @Override
    public boolean isVisible()
    {
        return visible;
    }

    @Override
    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }
}
