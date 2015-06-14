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
package engine.model.elementary;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Adrien
 */
public class UpdateContext
{
    public UpdateContext()
    { }
    
    public UpdateContext(Vector2D clickLocation)
    {
        this.isClisked = true;
        this.clickLocation = clickLocation;
    }
    
    public UpdateContext(Key... keys)
    {
        this.keys = Arrays.asList(keys);
        this.isClisked = false;
    }
    public UpdateContext(Collection<Key> keys)
    {
        this.keys = keys;
        this.isClisked = false;
    }
    
    public UpdateContext(Vector2D clickLocation, Key... keys)
    {
        this.keys = Arrays.asList(keys);
        this.isClisked = true;
        this.clickLocation = clickLocation;
    }
    public UpdateContext(Vector2D clickLocation, Collection<Key> keys)
    {
        this.keys = keys;
        this.isClisked = true;
        this.clickLocation = clickLocation;
    }
    
    
    
    
    private boolean isClisked = false;
    private Vector2D clickLocation = Vector2D.ZERO;
    private Collection<Key> keys;
    
    
    public boolean isClicked()
    {
        return this.isClisked;
    }
    
    public Vector2D getClickLocation()
    {
        return this.clickLocation;
    }
    
    public void clickHandled()
    {
        isClisked = false;
    }
    
    public Collection<Key> getKeys()
    {
        return keys;
    }
}
