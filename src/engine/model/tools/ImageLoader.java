package engine.model.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import javax.imageio.ImageIO;
import engine.settings.ExceptionManager;

/**
 *
 * @author Adrien
 */
public class ImageLoader
{
    private ImageLoader()
    { }
    
    protected static final ClassLoader loader = ImageLoader.class.getClassLoader();
    
    public static BufferedImage loadImage(String name)
    {
        if(name == null)
            return null;
        
        File file = new File(name);
        if(file.exists())
            return loadImage(file);
        else
            return loadImage(loader.getResourceAsStream(name));
    }
    public static BufferedImage loadImage(File file)
    {
        if(file == null || !file.exists())
            return null;
        
        try
        {
            return loadImage(Files.newInputStream(file.toPath(), StandardOpenOption.READ));
        }
        catch (IOException ex)
        {
            ExceptionManager.getExceptionManager().manager(ex);
            return null;
        }
    }
    public static BufferedImage loadImage(InputStream stream)
    {
        if(stream == null)
            return null;
        
        try
        {
            return ImageIO.read(stream);
        }
        catch (IOException ex)
        {
            ExceptionManager.getExceptionManager().manager(ex);
            return null;
        }
    }
}
