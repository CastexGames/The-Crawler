/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.model.elementary.interfaces;

import engine.model.elementary.Vector2D;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public interface Drawable extends GameEntity
{
    public void draw(Graphics graphics, Vector2D screenOffset);
    
    public boolean isVisible();
    public void setVisible(boolean visible);
}
