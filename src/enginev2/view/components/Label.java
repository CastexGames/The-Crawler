package enginev2.view.components;

import enginev2.model.layer.Layer;
import enginev2.model.Rectangle;
import enginev2.model.vector.vector2d.Vector2D;
import enginev2.view.drawer.drawers.components.LabelDrawer;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Adrien
 */
public class Label<T> extends Component
{
    public Label(Component parent, T value)
    {
        super(parent);
        
        this.value = value;
        
        setDrawer(new LabelDrawer());
    }
    public Label(T value)
    {
        this(null, value);
    }
    
    private T value;
    
    public T getValue()
    {
        return this.value;
    }
    public void setValue(T value)
    {
        this.value = value;
    }
    
    @Override
    public boolean intersectWith(Vector2D location)
    {
        return getBound().intersectWith(location.add(getPrintOffset()));
    }
    
    private Rectangle<Vector2D> textBound = null;
    public Rectangle<Vector2D> updateSize(Graphics graphic)
    {
        if(this.getDrawer().getFont() != null)
        {
            Rectangle2D bound = graphic.getFontMetrics().getStringBounds(this.value.toString(), graphic);
            textBound = new Rectangle(new Vector2D(bound.getX(), bound.getY()), new Vector2D(bound.getWidth(), bound.getHeight()));
            setSize(textBound.getSize());
        }
        return textBound;
    }
    
    public Vector2D getPrintOffset()
    {
        return textBound.getLocation();
    }

    @Override
    public void setLayer(Layer layer)
    {
        super.setLayer(layer);
    }

    @Override
    public LabelDrawer getDrawer()
    {
        return (LabelDrawer)super.getDrawer();
    }
}
