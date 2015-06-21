package game;

import enginev2.model.GameContext;
import enginev2.model.key.Key;
import enginev2.model.layer.Layer;
import enginev2.model.actions.MoveAction;
import enginev2.model.vector.vector2d.Vector2D;
import enginev2.settings.KeyMap;
import enginev2.view.components.ComponentRow;
import enginev2.view.components.Label;
import java.awt.Color;
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
        Layer frontLayer = new Layer();
        addLayer(frontLayer);
        
        ComponentRow cr = new ComponentRow(null);
        cr.setLocation(new Vector2D(100, 100));
        
        Label label = new Label("Chocolat");
        label.getDrawer().setBackground(Color.red);
        label.onClick.add(arg ->
        {
            label.setVisible(false);
        });
        
        cr.addChild(label);
        
        Label label2 = new Label("Chocolat2");
        label2.getDrawer().setBackground(Color.GREEN);
        label2.onClick.add(arg ->
        {
            label2.setVisible(false);
        });
        cr.addChild(label2);
        
        frontLayer.addEntity(cr);
        
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
