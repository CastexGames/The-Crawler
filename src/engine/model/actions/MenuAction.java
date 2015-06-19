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
package engine.model.actions;

/**
 *
 * @author Adrien
 */
public enum MenuAction
{
    CLOSE("close"),
    VALIDATE("validate"),
    NEXT("next"),
    GO_THROUGH("go_through"),
    PAUSE("pause"),
    OPEN_MENU("open_menu"),
    OPEN_INVENTORY("open_inventory"),
    OPEN_STATUS("open_status"),
    OPEN_CRAFT("open_craft"),
    OPEN_ABILITIES("open_abilities");

    private final String value;

    private MenuAction(final String value)
    {
        this.value = "MenuAction::" + value;
    }

    @Override
    public String toString()
    {
        return value;
    }
}
