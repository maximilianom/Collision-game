import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;

import javax.swing.*;

public class DrawPanel extends JPanel implements KeyListener {
    
    private Entity player;
    private Entity enemy;
    
    //Used for smooth animation
    private BufferedImage buffer;
    
    //CONSTRUCTOR
    public DrawPanel() {
        setIgnoreRepaint(true);
        addKeyListener(this);
        setFocusable(true);
    }
    
    //Method called from Gui containing main loop
    public void start() {
        
        //Very Important. Almost forgot
        init();
        
        long timeStarted = System.currentTimeMillis();
        long acumulatedTime = timeStarted;
        
        while(true) {
            try {
                long timePassed = System.currentTimeMillis() - acumulatedTime;
                acumulatedTime += timePassed;
                update(timePassed);
                checkCollisions();
                drawBuffer();
                drawScreen();
                Thread.sleep(15);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void init() {
        buffer = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
        loadEntities();   
    }
    
    private void loadEntities() {
        player = new Entity(0, 0, 50, 50);
        enemy = new Entity(400, 400, 50, 50); 
    }
    
    private void update(long timePassed) {
        player.update(timePassed);
        
        //have you gone out of the screen? Let me help you.
        if(player.getX() < 0) {
            player.setX(0);
        }
        if(player.getX() + player.getWidth() > this.getWidth()) {
            player.setX(this.getWidth() - player.getWidth());
        }
        if(player.getY() < 0) {
            player.setY(0);
        }
        if(player.getY() + player.getHeight() > this.getHeight()) {
            player.setY(this.getHeight() - player.getHeight());
        }
        
    }
    
    private void checkCollisions() {
        if(player.getRectangle().intersects(enemy.getRectangle())) {
            player.setCollided(true);
        }
    }
    
    private void drawBuffer() {
        Graphics2D b = buffer.createGraphics();
        b.setColor(Color.black);
        b.fillRect(0, 0, 800, 600);
        if (player.isCollided() == false) {
            b.setColor(Color.red);
            b.fillRect(Math.round(player.getX()), Math.round(player.getY()), player.getWidth(), player.getHeight());
            b.setColor(Color.blue);
            b.fillRect(Math.round(enemy.getX()), Math.round(enemy.getY()), enemy.getWidth(), enemy.getHeight());
            b.dispose();
        } else {
            b.setColor(Color.white);
            b.setFont(new Font("Arial", Font.PLAIN, 24));
            b.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            b.drawString("C O L L I S I O N !", 300, 300);
            b.setFont(new Font("Arial", Font.PLAIN, 18));
            b.drawString("press enter to try again", 300, 350);
            b.dispose();
        }   
    }
    
    private void drawScreen() {
        Graphics2D g = (Graphics2D)this.getGraphics();
        g.drawImage(buffer, 0 , 0, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        //Wanna exit?
        if(keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        
        //Wanna restart?
        if(keyCode == KeyEvent.VK_ENTER) {
            loadEntities();
        }
        
        if(keyCode == KeyEvent.VK_UP) {
            player.setVelocityY(-0.3f);
        }
        if(keyCode == KeyEvent.VK_DOWN) {
            player.setVelocityY(0.3f);
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
            player.setVelocityX(0.3f);
        }
        if(keyCode == KeyEvent.VK_LEFT) {
            player.setVelocityX(-0.3f);
        }
    }
    
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if(keyCode == KeyEvent.VK_UP) {
            player.setVelocityY(0);
        }
        if(keyCode == KeyEvent.VK_DOWN) {
            player.setVelocityY(0);
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
            player.setVelocityX(0);
        }
        if(keyCode == KeyEvent.VK_LEFT) {
            player.setVelocityX(0);
        }
    }
    
    //Nothing here... it doesn't matter
    public void keyTyped(KeyEvent e) {
        e.consume();
    }
}
