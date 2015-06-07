/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.settings;

import java.awt.Dimension;

/**
 *
 * @author Adrien
 */
public abstract class ExceptionManager
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
