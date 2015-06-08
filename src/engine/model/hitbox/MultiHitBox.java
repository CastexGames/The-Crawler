package engine.model.hitbox;

import engine.model.elementary.interfaces.Rotatable;
import engine.model.elementary.Angle;
import engine.model.elementary.Vector2D;
import engine.model.elementary.interfaces.Localisable;
import engine.model.elementary.interfaces.Sized;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * @author Adrien
 */
public class MultiHitBox extends HitBox implements Rotatable
{
    public MultiHitBox(HitBox[] bitBoxes)
    {
        this(Arrays.asList(bitBoxes));
    }
    public MultiHitBox(Collection<HitBox> hitBoxes)
    {
        this(hitBoxes, Angle.ZERO);
    }
    public MultiHitBox(HitBox[] bitBoxes, Angle angle)
    {
        this(Arrays.asList(bitBoxes), angle);
    }
    public MultiHitBox(Collection<HitBox> hitBoxes, Angle angle)
    {
        this.hitBoxes = hitBoxes;
        this.angle = angle;
    }
    
    private Collection<HitBox> hitBoxes;
    private Angle angle;
    
    
    @Override
    protected Collection<Vector2D> getPoints(Angle angleOffset)
    {
        return hitBoxes.stream()
                .flatMap(hb -> hb.getPoints(angleOffset).stream())
                .collect(Collectors.toList());
    }
    

    @Override
    public boolean intersectWith(Vector2D point)
    {
        return hitBoxes.stream().anyMatch(hb -> hb.intersectWith(point));
    }

    @Override
    public boolean intersectWith(HitBox otherHitBox, Vector2D offset)
    {
        return hitBoxes.stream().anyMatch(hb -> hb.intersectWith(otherHitBox, offset));
    }
    
    @Override
    public Vector2D getCenter()
    {
        Collection<Vector2D> centers = hitBoxes.stream().map(hb -> hb.getCenter()).collect(Collectors.toList());
        return new Vector2D(
                centers.stream().mapToDouble(c -> c.x).average().getAsDouble(),
                centers.stream().mapToDouble(c -> c.y).average().getAsDouble()
        );
    }

    @Override
    public void setAngle(Angle angle)
    {
        this.angle = angle;
    }
    @Override
    public Angle getAngle()
    {
        return angle;
    }
}
