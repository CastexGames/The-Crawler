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
package enginev2.settings;

import enginev2.model.key.ActionManager;
import enginev2.model.key.Key;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Adrien
 */
public class KeyMap
{
    public KeyMap(Key... keys)
    {
        this.keys = Arrays.asList(keys);
        this.actionManager = new ActionManager();
    }
    public KeyMap(Collection<Key> keys)
    {
        this.keys = keys;
        this.actionManager = new ActionManager();
    }
    
    protected Collection<Key> keys;
    protected ActionManager actionManager;
    
    private static KeyMap static_keymap = null;
    public static KeyMap getKeyMap()
    {
        return static_keymap;
    }
    public static void setKeyMap(KeyMap keyMap)
    {
        static_keymap = keyMap;
    }
    
    public ActionManager getActionManager()
    {
        return this.actionManager;
    }
    
    
    public String getActionFromKey(String keyName)
    {
        return keys.stream()
                .filter(k -> keyName.equals(k.getName()))
                .map(k -> k.getAction())
                .findFirst()
                .orElse(null);
    }
    public String[] getActionsFromKey(String keyName)
    {
        return keys.stream()
                .filter(k -> keyName.equals(k.getName()))
                .map(k -> k.getAction())
                .toArray(String[]::new);
    }
    
    public String getKeyFromAction(String action)
    {
        return keys.stream()
                .filter(k -> action.equals(k.getAction()))
                .map(k -> k.getName())
                .findFirst()
                .orElse(null);
    }
    public String[] getKeysFromAction(String action)
    {
        return keys.stream()
                .filter(k -> action.equals(k.getAction()))
                .map(k -> k.getName())
                .toArray(String[]::new);
    }
}
