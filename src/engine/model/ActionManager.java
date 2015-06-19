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

import engine.model.event.Event;
import engine.model.event.EventHandler;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adrien
 */
public class ActionManager
{
    public ActionManager()
    {
        this.actions = new HashMap<>();
    }
    
    private final Map<String, Event> actions;
    
    public void setAction(String action, EventHandler actionMethod)
    {
        if(actions.containsKey(action))
            actions.get(action).add(actionMethod);
        else
        {
            Event event = new Event(this);
            event.add(actionMethod);
            actions.put(action, event);
        }
    }
    
    public void clearAction(String action)
    {
        if(actions.containsKey(action))
            actions.get(action).clear();
    }
    
    public Event getAction(String action)
    {
        return actions.getOrDefault(action, null);
    }
}
