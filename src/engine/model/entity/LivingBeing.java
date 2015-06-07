/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.model.entity;

import engine.model.elementary.Vector2D;
import engine.model.elementary.interfaces.Drawable;
import engine.model.elementary.interfaces.GameEntity;
import engine.model.elementary.interfaces.Localisable;
import engine.model.image.Picture;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public abstract class LivingBeing<P extends Picture> implements GameEntity, Drawable, Localisable
{
    public LivingBeing()
    {
        this.visible = true;
        this.location = Vector2D.ZERO;
    }
    
    private boolean visible;
    private Vector2D location;
    
    private P picture;
    protected void setPicture(P picture)
    {
        this.picture = picture;
    }
    protected P getPicture()
    {
        return picture;
    }

    @Override
    public void draw(Graphics graphics, Vector2D screenOffset)
    {
        if(!isVisible())
            return;
        
        getPicture().draw(graphics, getLocation().add(screenOffset));
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
}
