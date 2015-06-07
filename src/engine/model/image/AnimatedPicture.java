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
public class AnimatedPicture extends Picture
{
    public AnimatedPicture(String[] names)
    {
        super(null);
        
        if(names == null)
            this.images = null;
        else
            this.images = Stream.of(names)
                    .map(n -> ImageLoader.loadImage(n))
                    .toArray(BufferedImage[]::new);
        
        this.currentIndex = 0;
        this.animationTurn = 0;
        this.image = getCurrentImage();
    }
    
    protected final BufferedImage[] images;
    private int currentIndex;
    private int animationTurn;
    
    public void restart()
    {
        currentIndex = 0;
        animationTurn = 0;
    }
    
    public int getNumberOfAnimationTurn()
    {
        return animationTurn;
    }
    
    protected int getMaximumIndex()
    {
        return images.length;
    }
    
    protected int next()
    {
        currentIndex = (currentIndex + 1) % getMaximumIndex();
        
        if(currentIndex == 0)
            animationTurn++;
        
        image = getCurrentImage();
        return currentIndex;
    }
    
    protected int getCurrentIndex()
    {
        return currentIndex;
    }
    
    public BufferedImage getCurrentImage()
    {
        return images[getCurrentIndex()];
    }
    
    public boolean isFirstImage()
    {
        return getCurrentIndex() == 0;
    }
}
