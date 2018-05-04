
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import sun.awt.image.*;

public class Project_Swing extends Component {
    
    int height = 0, width = 0;
    
    BufferedImage originalImage;
    ToolkitImage displayImage;
    
    int tile = 1;
    
    public void paint(Graphics g) {
        for (int vertical = 0; vertical < tile; vertical++) {
            for (int horizontal = 0; horizontal < tile; horizontal++) {
                g.drawImage(displayImage, width * horizontal / tile, height * vertical / tile, null);
            }
        }
    }
    
    public Project_Swing () {
        try {
            originalImage = ImageIO.read(new File("resources//original.jpg"));
        }
        catch (IOException e) {}   
        
        this.height = getPreferredSize().height;
        this.width = getPreferredSize().width;
        
        displayImage = (ToolkitImage) originalImage.getScaledInstance(Math.round(width / tile), Math.round(height / tile), 1);
    }
    
    public Dimension getPreferredSize () {
        if (originalImage == null) {
            return new Dimension(0,0);
        }
        else {
            return new Dimension(originalImage.getWidth(null), originalImage.getHeight(null));
        }
    }
    
    public static void main () {        
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
        
        frame.add(new Project_Swing());
        
        frame.setUndecorated(true);
        
        frame.pack();
        frame.setVisible(true);
    }
}