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
public enum MoveAction
{
    FORWARD("forward"),
    BACKWARD("backward"),
    RETURN("return"),
    LEFT("left"),
    RIGHT("right"),
    LATERAL_LEFT("lateral_left"),
    LATERAL_RIGHT("lateral_right"),
    SIT("sit"),
    LAY("lay"),
    STAND("stand"),
    RUN("run"),
    WALK("walk"),
    SNEAK("sneak"),
    STOP("stop");

    private final String value;

    private MoveAction(final String value)
    {
        this.value = "MoveAction::" + value;
    }

    @Override
    public String toString()
    {
        return value;
    }
}
