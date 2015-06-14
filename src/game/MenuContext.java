package game;

import engine.model.GameContext;
import engine.model.components.Label;
import engine.model.elementary.Vector2D;
import java.awt.Font;

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
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 30);
        
        Label label = new Label("Chocolat");
        label.setLocation(new Vector2D(100, 100));
        label.setFont(font);
        entities.add(label);
    }
}
