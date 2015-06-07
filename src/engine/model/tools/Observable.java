/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
