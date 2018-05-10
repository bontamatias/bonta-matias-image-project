import java.util.Arrays;
import java.awt.Color;
import java.util.Random;

public class AdvancedPicture extends Picture {
    Random gen = new Random();
    
    /**
    * Constructor that takes a file name and creates the picture
    * @param fileName the name of the file to create the picture from
    */
    public AdvancedPicture (String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }
    
    /**
    * Constructor that takes the width and height
    * @param width the width of the desired picture
    * @param height the height of the desired picture
    */
    public AdvancedPicture (int width, int height) {
        // let the parent class handle this width and height
        super(width,height);
    }
    
    /**
    * Constructor that takes a picture and creates a
    * copy of that picture
    */
    public AdvancedPicture (Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }
    
    public void copyTo (SimplePicture image, int xStart, int yStart) {
        Pixel source = null;
        Pixel target = null;
       
        for (int x = xStart; x < image.getWidth() + xStart; x++) {
            for (int y = yStart; y < image.getHeight() + yStart; y++) {
                source = image.getPixel(x - xStart, y - yStart);
                target = this.getPixel(x, y);
                target.setColor(source.getColor());
            }
        }
    }
    
    public void mirrorVertical () {
        Pixel source = null;
        Pixel target = null;
        int mirrorPoint = (int) getHeight() / 2;
       
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < mirrorPoint; y++) {
                source = getPixel(x, y);
                target = getPixel(x,getHeight() - 1 - y);
                target.setColor(source.getColor());
            }
        }
    }
    
    public void mirrorHorizontal () {
        Pixel source = null;
        Pixel target = null;
        int mirrorPoint = (int) getWidth() / 2;
       
        for (int x = 0; x < mirrorPoint; x++) {
            for (int y = 0; y < getHeight(); y++) {
                source = getPixel(x, y);
                target = getPixel(getWidth() - 1 - x,y);
                target.setColor(source.getColor());
            }
        }
    }
    
    public void mirrorVerticalInvert () {
        Pixel source = null;
        Pixel target = null;
        int mirrorPoint = (int) getHeight() / 2;
       
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < mirrorPoint; y++) {
                target = getPixel(x, y);
                source = getPixel(x,getHeight() - 1 - y);
                target.setColor(source.getColor());
            }
        }
    }
    
    public void mirrorHorizontalInvert () {
        Pixel source = null;
        Pixel target = null;
        int mirrorPoint = (int) getWidth() / 2;
       
        for (int x = 0; x < mirrorPoint; x++) {
            for (int y = 0; y < getHeight(); y++) {
                target = getPixel(x, y);
                source = getPixel(getWidth() - 1 - x,y);
                target.setColor(source.getColor());
            }
        }
    }
    
    public void pixelSort () {
        int[][] pixelData = deconstructImage();
        
        for (int[] slice : pixelData) {
            Arrays.sort(slice);
        }
        
        //System.out.println(Integer.toBinaryString(pixelData[0][0]));
        
        rebuildImage(pixelData);
    }
    
    public void greyscale () {
        for (Pixel target : getPixels()) {
            target.setColor(new Color((int) target.getAverage(), (int) target.getAverage(), (int) target.getAverage()));
        }
    }
    
    public void modify (int mod) {
        int red;
        int green;
        int blue;
        
        for (Pixel target : getPixels()) {
            red = (int) target.getRed() + mod;
            green = (int) target.getGreen() + mod;
            blue = (int) target.getBlue() + mod;
            if (red > 255) red = 255;       if (red < 0) red = 0;
            if (green > 255) green = 255;   if (green < 0) green = 0;
            if (blue > 255) blue = 255;     if (blue < 0) blue = 0;
            
            target.setColor(new Color(red, green, blue));
        }
    }
    
    public void blacken (int cutoff) {        
        for (Pixel target : getPixels()) {
            if (target.getAverage() > cutoff) {
                target.setColor(Color.white);
            }
            else {
                target.setColor(Color.black);
            }
        }
    }
    
    public void recurse (int limit) {
        doRecurse(0, limit);
    }
    
    private void doRecurse (int step, int limit) {
        if (step < limit) {
            Pixel source = null;
            Pixel target = null;
           
            for (int x = 0; x < getWidth(); x+=2) {
                for (int y = 0; y < getHeight(); y+=2) {
                    target = getPixel(x/2, y/2);
                    source = getPixel(x, y);
                    target.setColor(source.getColor());
                }
            }
            doRecurse(++step, limit);
        }
    }
    
    private int[][] deconstructImage () {
        int[][] pixelData = new int[getWidth()][getHeight()];
        
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                pixelData[x][y] = getBasicPixel(x,y);
            }
        }
        
        return pixelData;
    }
    
    private void rebuildImage (int[][] pixelData) {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                setBasicPixel(x, y, pixelData[x][y]);
            }
        }
    }
    
    private Color random() {
        return new Color(gen.nextInt(255),gen.nextInt(255),gen.nextInt(255));
    }
}