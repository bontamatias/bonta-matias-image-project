
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Project {
    
    static int height = 0, width = 0;
    
    static AdvancedPicture canvas;
    
    public static void main () {
        //open up the original image
        AdvancedPicture originalImage = new AdvancedPicture(new Picture("resources//original.jpg"));
        
        //get the height and width of the image for future use
        height = originalImage.getHeight();
        width = originalImage.getWidth();
        
        //create a new image to edit
        AdvancedPicture image1 = new AdvancedPicture(new Picture("resources//original.jpg"));
        
        //apply a recursive edit to the image
        image1.recurse(10);
        
        
        //create a new image to edit
        AdvancedPicture image2 = new AdvancedPicture(new Picture("resources//original.jpg"));
        
        image2.greyscale();
        image2.mirrorHorizontalInvert();
        image2.mirrorVertical();
        
        //create a new image to edit
        AdvancedPicture image3 = new AdvancedPicture(new Picture("resources//original.jpg"));
        
        image3.greyscale();
        
        //create a new image to edit
        AdvancedPicture image4 = new AdvancedPicture(new Picture("resources//original.jpg"));
        
        image4.mirrorVertical();
        
        //create a new image to edit
        AdvancedPicture image5 = new AdvancedPicture(new Picture("resources//original.jpg"));
        
        image5.modify(100);
        
        //create a new image to edit
        AdvancedPicture image6 = new AdvancedPicture(new Picture("resources//original.jpg"));
        
        image6.filter(100);
        
        //generate a canvas big enough to fix six of the image
        canvas = new AdvancedPicture(originalImage.getWidth() * 3, originalImage.getHeight() * 2);
        
        //copy all six generated images onto the previously generated canvas
        canvas.copyTo(image1, width * 0, height * 0);
        canvas.copyTo(image2, width * 1, height * 0);
        canvas.copyTo(image3, width * 2, height * 0);
        canvas.copyTo(image4, width * 0, height * 1);
        canvas.copyTo(image5, width * 1, height * 1);
        canvas.copyTo(image6, width * 2, height * 1);
        

        canvas.explore();
        
        //canvas.write("resources//four.jpg");
    }
}