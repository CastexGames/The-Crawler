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
package enginev2.model.layer;

import enginev2.model.update.Updatable;
import enginev2.model.update.UpdateContext;
import enginev2.model.entity.IGameEntity;
import enginev2.model.key.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 * @author Adrien
 */
public class FocusManager implements Updatable
{
    public FocusManager()
    {
        focused = new HashSet<>();
        focusedListeners = new HashSet<>();
    }
    
    private final Collection<IGameEntity> focused;
    private final Collection<KeyListener> focusedListeners;
    
    public Collection<IGameEntity> getFocused()
    {
        return focused;
    }
    public void setFocused(IGameEntity focused)
    {
        this.focused.clear();
        this.focusedListeners.clear();
        appendFocused(focused);
    }
    public void setFocused(Collection<IGameEntity> focused)
    {
        this.focused.clear();
        this.focusedListeners.clear();
        appendFocused(focused);
    }
    
    public void appendFocused(IGameEntity focused)
    {
        if(focused instanceof KeyListener)
            this.focusedListeners.add((KeyListener)focused);
        this.focused.add(focused);
    }
    public void appendFocused(Collection<IGameEntity> focused)
    {
        this.focused.addAll(focused);
        
        this.focusedListeners.addAll(focused.stream()
                .filter(f -> f instanceof KeyListener)
                .map(f -> (KeyListener)f)
                .collect(Collectors.toList()));
    }
    
    @Override
    public void update(UpdateContext context)
    {
        if(focused != null && !context.getKeys().isEmpty())
            this.focusedListeners.forEach(f -> f.keyPressed(context.getKeys()));
    }
}
