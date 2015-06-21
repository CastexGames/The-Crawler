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
package enginev2.model.event;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 *
 * @author Adrien
 */
public class Event<T>
{
    public Event(Object sender)
    {
        this.events = new LinkedList<>();
        this.sender = sender;
    }
    
    protected final Object sender;
    protected final Collection<EventHandler<T>> events;
    
    public boolean add(EventHandler<T> event)
    {
        return events.add(event);
    }
    
    public boolean remove(EventHandler<T> event)
    {
        return events.remove(event);
    }
    
    public void clear()
    {
        events.clear();
    }
    
    public void invoke()
    {
        this.invoke((T)null);
    }
    public void invoke(T arg)
    {
        this.invoke(new EventArg<>(sender, arg));
    }
    public void invoke(EventArg<T> arg)
    {
        events.removeAll(events.stream().map(e ->
                {
                    arg.removeEventHandler(false);
                    e.compute(arg);
                    if(arg.willRemoveEventHandler())
                        return e;
                    else
                        return null;
                })
                .filter(e -> e != null)
                .collect(Collectors.toList())
        );
    }
}
