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
package enginev2.model.vector;

/**
 *
 * @author Adrien
 */
public interface Vector<V extends Vector> extends Cloneable
{
    public V add(V vector);
    public V sub(V vector);
    public V mul(V vector);
    public V div(V vector);
    
    public V add(double value);
    public V sub(double value);
    public V mul(double value);
    public V div(double value);
    
    public double getDistance(V vector);
    
    public boolean isEmpty();
    public boolean isPurelyPositive();
    public boolean isPurelyNegative();
    public boolean hasEmptyMember();
    public boolean hasPositiveMember();
    public boolean hasNegativeMember();
}
