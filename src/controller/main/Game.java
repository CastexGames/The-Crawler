/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

import engine.controller.GamePanel;
import javax.swing.JFrame;
import engine.settings.ExceptionManager;
import engine.settings.WindowSettings;

/**
 *
 * @author Adrien
 */
public class Game
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        initializeSettings();
        
        JFrame window = new JFrame(WindowSettings.getWindowSettings().getWindowName());
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(WindowSettings.getWindowSettings().isResizable());
        window.pack();
        window.setVisible(true);
    }
    
    private static void initializeSettings()
    {
        WindowSettings.setGlobalWindowSettings(new game.settings.test.WindowSettings());
        ExceptionManager.setGloabalExceptionManager(new game.settings.test.ExceptionManager());
    }
}
