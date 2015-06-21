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
package enginev2.model.vector.vector2d;

import java.awt.Dimension;

/**
 *
 * @author Adrien
 */
public class ImmutableVector2D extends Vector2D
{
    public ImmutableVector2D()
    {
        this(0, 0);
    }
    public ImmutableVector2D(Dimension dim)
    {
        this.x = dim.width;
        this.y = dim.height;
    }
    public ImmutableVector2D(double value)
    {
        this.x = value;
        this.y = value;
    }
    public ImmutableVector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public final double x;
    public final double y;

    @Override
    protected double getX()
    {
        return x;
    }

    @Override
    protected double getY()
    {
        return y;
    }
}
