/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.model.elementary.interfaces;

import engine.model.elementary.UpdateContext;

/**
 *
 * @author Adrien
 */
public interface Updatable extends GameEntity
{
    public void update(UpdateContext context);
}
