
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Project {
    
    static int height = 0, width = 0;
    
    static AdvancedPicture canvas;
    
    public static void main () {
        AdvancedPicture originalImage = new AdvancedPicture(new Picture("resources//original.jpg"));
        height = originalImage.getHeight();
        width = originalImage.getWidth();
        
        canvas = new AdvancedPicture(originalImage.getWidth() * 3, originalImage.getHeight() * 2);
        
        AdvancedPicture image1 = new AdvancedPicture(new Picture("resources//original.jpg"));
        
        image1.recurse(10);
        
        canvas.copyTo(originalImage, width * 0, height * 0);        canvas.copyTo(originalImage, width * 1, height * 0);        canvas.copyTo(originalImage, width * 2, height * 0);
        
        canvas.copyTo(originalImage, width * 0, height * 1);        canvas.copyTo(originalImage, width * 1, height * 1);        canvas.copyTo(originalImage, width * 2, height * 1);
        
        
        AdvancedPicture image2 = new AdvancedPicture(new Picture("resources//original.jpg"));
        AdvancedPicture image3 = new AdvancedPicture(new Picture("resources//original.jpg"));
        AdvancedPicture image4 = new AdvancedPicture(new Picture("resources//original.jpg"));
        AdvancedPicture image5 = new AdvancedPicture(new Picture("resources//original.jpg"));
        AdvancedPicture image6 = new AdvancedPicture(new Picture("resources//original.jpg"));
        

        canvas.explore();
        
        //canvas.write("resources//four.jpg");
    }
}