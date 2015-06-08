package engine.model.hitbox;

import engine.model.elementary.Angle;
import engine.model.elementary.Rectangle;
import engine.model.elementary.Vector2D;
import java.util.Collection;

/**
 *
 * @author Adrien
 */
public abstract class HitBox
{
    protected abstract Collection<Vector2D> getPoints(Angle angleOffset);
    
    /**
     * Determine if the hit box is pointed by the <i>point</i>.
     * @param point Point to test with.
     * @return <b>true</b> if the hit box intersect with the point. <b>false</b>
     * otherwise.
     */
    public abstract boolean intersectWith(Vector2D point);
    
    /**
     * Determine if the two hit boxes intersect.
     * @param otherHitBox Other hit box to test with.
     * @return <b>true</b> if the both hit boxes intersect. <b>false</b> otherwise.
     */
    public boolean intersectWith(HitBox otherHitBox)
    {
        return intersectWith(otherHitBox, Vector2D.ZERO);
    }
    
    /**
     * Determine if the two hit boxes intersect.
     * @param otherHitBox Other hit box to test with.
     * @param offset Offset to apply on the <i>otherHitBox</i>.
     * @return <b>true</b> if the both hit boxes intersect. <b>false</b> otherwise.
     */
    public abstract boolean intersectWith(HitBox otherHitBox, Vector2D offset);
    
    public Rectangle toRectangle()
    {
        return new Rectangle(toPoints());
    }
    
    public Collection<Vector2D> toPoints(Angle angleOffset)
    {
        return getPoints(angleOffset);
    }
    public Collection<Vector2D> toPoints()
    {
        return getPoints(Angle.ZERO);
    }
    
    public Vector2D getCenter()
    {
        Collection<Vector2D> points = toPoints();
        return new Vector2D(
                points.stream().mapToDouble(p -> p.x).average().getAsDouble(),
                points.stream().mapToDouble(p -> p.y).average().getAsDouble()
        );
    }
}
