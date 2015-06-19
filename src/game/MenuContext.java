package game;

import engine.model.GameContext;
import engine.model.actions.MoveAction;
import engine.model.components.Label;
import engine.model.elementary.Key;
import engine.model.elementary.Vector2D;
import engine.model.event.EventArg;
import engine.model.event.EventHandler;
import engine.settings.KeyMap;
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
        
    }
    
    @Override
    protected void initialize()
    {
        Font font = new Font("Monotype Corsiva", Font.PLAIN, 30);
        
        Label label = new Label("Chocolat");
        label.setLocation(new Vector2D(100, 100));
        label.setFont(font);
        entities.add(label);
        
        KeyMap km = new KeyMap(
                new Key("z", MoveAction.FORWARD.toString())
        );
        
        km.getActionManager().setAction(MoveAction.FORWARD.toString(), arg ->
        {
            System.out.println("AAAAAAAAAAAAA");
            label.setVisible(false);
            arg.removeEventHandler(true);
        });
        
        KeyMap.setKeyMap(km);
    }
}
