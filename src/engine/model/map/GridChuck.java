package engine.model.map;

import engine.model.elementary.Vector2D;
import engine.model.elementary.interfaces.Drawable;
import java.awt.Graphics;

/**
 *
 * @author Adrien
 */
public class GridChuck extends Chunk
{
    public GridChuck(int width, int height, double caseSize)
    {
        super(new Vector2D(width * caseSize, height * caseSize));
        
        this.caseSize = caseSize;
        this.cases = new Drawable[width][height];
    }
    
    protected final double caseSize;
    protected final Drawable[/* x */][/* y */] cases;

    @Override
    public void draw(Graphics graphics, Vector2D screenOffset)
    {
        if(!this.isVisible())
            return;
        
        super.draw(graphics, screenOffset);
        
        Vector2D newLocation = screenOffset.add(this.getLocation());
        
        for(int x = 0; x < super.getWidth(); x++)
            for(int y = 0; y < super.getWidth(); y++)
                if(cases[x][y] != null)
                    cases[x][y].draw(graphics, newLocation);
    }
}
