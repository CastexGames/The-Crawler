package game;

import engine.model.GameContext;
import engine.model.components.Label;
import engine.model.elementary.Vector2D;

/**
 *
 * @author Adrien
 */
public class MenuContext extends GameContext
{
    public MenuContext()
    {
        super();
        
        initialize();
    }
    
    protected void initialize()
    {
        Label label = new Label("Chocolat");
        label.setLocation(new Vector2D(100, 100));
        entities.add(label);
    }
}
