package engine.model.tools;

/**
 *
 * @author Adrien
 */
public class Observable extends java.util.Observable
{
    public Observable()
    {
        super();
    }
    
    protected void notifyChanges()
    {
        super.setChanged();
        super.notifyObservers();
    }
}
