
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Project {
    
    int height = 0, width = 0;
    
    int tile = 1;
    
    static AdvancedPicture canvas;
    
    public static void main () {
        canvas = new AdvancedPicture(new Picture("resources//original.jpg"));

        canvas.recurse(10);
        

        Display.go(canvas.getBufferedImage());
        
        //canvas.write("resources//four.jpg");
    }
}