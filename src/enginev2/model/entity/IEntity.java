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
package enginev2.model.entity;

import enginev2.model.layer.Layer;
import enginev2.model.update.Updatable;
import enginev2.view.drawer.Drawer;

/**
 *
 * @author Adrien
 */
public interface IEntity<D extends Drawer> extends Updatable
{
    public Drawer getDrawer();
    public Layer getLayer();
    public void setLayer(Layer layer);
}
