/*
 * Copyright (C) 2015 Adrien
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package engine.model;

import engine.model.elementary.UpdateContext;
import engine.model.elementary.interfaces.GameEntity;
import engine.model.elementary.interfaces.KeyListener;
import engine.model.elementary.interfaces.Updatable;

/**
 *
 * @author Adrien
 */
public class FocusManager implements GameEntity, Updatable
{
    protected FocusManager()
    { }
    
    private static FocusManager focusManager;
    public static void setFocusManager(FocusManager focusManager)
    {
        focusManager.focusManager = focusManager;
    }
    public static FocusManager getFocusManager()
    {
        if(focusManager == null)
            focusManager = new FocusManager();
        return focusManager;
    }
    
    private KeyListener focused = null;
    public KeyListener getFocused()
    {
        return focused;
    }
    public void setFocused(KeyListener focused)
    {
        this.focused = focused;
    }
    
    @Override
    public void update(UpdateContext context)
    {
        if(focused != null && !context.getKeys().isEmpty())
            context.getKeys().forEach(k -> focused.keyPressed(k));
    }
}
