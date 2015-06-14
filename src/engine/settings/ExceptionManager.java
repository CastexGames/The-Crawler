package engine.settings;

import engine.model.tools.Observable;

/**
 *
 * @author Adrien
 */
public abstract class ExceptionManager extends Observable
{
    public ExceptionManager()
    { }
    
    private static ExceptionManager exceptionManager = null;
    public static void setGloabalExceptionManager(ExceptionManager exceptionManager)
    {
        ExceptionManager.exceptionManager = exceptionManager;
    }
    public static ExceptionManager getExceptionManager()
    {
        return exceptionManager;
    }
    
    public abstract void manager(Exception ex);
}
