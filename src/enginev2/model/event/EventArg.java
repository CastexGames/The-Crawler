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

/**
 *
 * @author Adrien
 */
public class EventArg<T>
{
    public EventArg(Object sender)
    {
        this(sender, null);
    }
    public EventArg(Object sender, T arg)
    {
        this.sender = sender;
        this.arg = arg;
        this.willRemoveEventHandler = false;
    }
    
    private final Object sender;
    private final T arg;
    private boolean willRemoveEventHandler;
    
    public Object getSender()
    {
        return sender;
    }
    
    public T getArgument()
    {
        return arg;
    }
    
    
    public void removeEventHandler(boolean value)
    {
        willRemoveEventHandler = value;
    }
    public boolean willRemoveEventHandler()
    {
        return willRemoveEventHandler;
    }
}
