/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.controller;

/**
 *
 * @author Adrien
 */
public interface IRunnable
{
    public void start();
    public void reset();
    public void pause();
    public void resume();
    
    public boolean isRunning();
}
