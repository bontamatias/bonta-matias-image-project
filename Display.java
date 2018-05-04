import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class Display extends Component {
    
    int height = 0, width = 0;
    
    BufferedImage displayImage;
    
    public void paint(Graphics screen) {
        screen.drawImage(displayImage, 0, 0, null);
    }
    
    public Display (BufferedImage displayImage) {
        this.displayImage = displayImage;   
        
        this.height = getPreferredSize().height;
        this.width = getPreferredSize().width;
    }
    
    public Dimension getPreferredSize () {
        if (displayImage == null) {
            return new Dimension(0,0);
        }
        else {
            return new Dimension(displayImage.getWidth(null), displayImage.getHeight(null));
        }
    }
    
    public static void go (BufferedImage displayImage) {        
        JFrame frame = new JFrame("Image Project_Swing");
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
        
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent k) {
                if(k.getKeyCode() == k.VK_ESCAPE) {
                    frame.dispose();
                }
            } 
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new Display(displayImage));
        
        frame.setUndecorated(true);
        
        frame.pack();
        frame.setVisible(true);
    }
}