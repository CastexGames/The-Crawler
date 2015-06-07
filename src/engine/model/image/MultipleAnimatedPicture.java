/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.model.image;

import java.awt.image.BufferedImage;
import java.util.stream.Stream;
import engine.model.tools.ImageLoader;

/**
 *
 * @author Adrien
 */
public class MultipleAnimatedPicture extends AnimatedPicture
{
    public MultipleAnimatedPicture(String[][] names)
    {
        super(null);
        
        if(names == null)
            this.images = null;
        else
            this.images = Stream.of(names)
                    .map(an -> Stream.of(an)
                            .map(n -> ImageLoader.loadImage(n))
                            .toArray(BufferedImage[]::new))
                    .toArray(BufferedImage[][]::new);
    }
    
    protected final BufferedImage[][] images;
    private int currentMode = 0;
    
    @Override
    protected int getMaximumIndex()
    {
        return images[getCurrentModeIndex()].length;
    }
    
    protected int getCurrentModeIndex()
    {
        return currentMode;
    }
    
    public void setMode(int mode)
    {
        currentMode = mode;
        restart();
    }
    
    @Override
    public BufferedImage getCurrentImage()
    {
        return images[getCurrentModeIndex()][getCurrentIndex()];
    }
}
