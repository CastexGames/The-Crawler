/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.settings.test;

/**
 *
 * @author Adrien
 */
public class ExceptionManager extends enginev2.settings.ExceptionManager
{
    public ExceptionManager()
    {
        super();
    }
    
    @Override
    public void manager(Exception ex)
    {
        ex.printStackTrace();
    }
}
