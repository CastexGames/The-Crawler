/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.model.elementary.interfaces;

import engine.model.elementary.Vector2D;

/**
 *
 * @author Adrien
 */
public interface Localisable
{
    public Vector2D getLocation();
    public void setLocation(Vector2D location);
    
    //public boolean isVisibleOnTheScreen();
}
