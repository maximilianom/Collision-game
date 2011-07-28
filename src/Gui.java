import java.awt.Font;

import javax.swing.*;

public class Gui {
    private JFrame window;
    private DrawPanel panel;
    
    public Gui() {
        window = new JFrame("I'm gonna collide");
        panel = new DrawPanel();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(panel);
        window.setFont(new Font("Arial", 25, Font.PLAIN));
        window.setVisible(true);
    }
    
    public static void main(String args[]) {
        Gui game = new Gui();
        game.start();
    }
    
    private void start() {
        panel.start();
    }
    
}