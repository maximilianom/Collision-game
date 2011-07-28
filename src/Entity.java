import java.awt.Rectangle;

public class Entity {
    private int width;
    private int height;
    
    //position
    private float x;
    private float y;
    
    //velocity
    private float vx;
    private float vy;
    
    //collision
    private boolean collided;
    
    //CONSTRUCTOR
    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        collided = false;
        
        //entity should remain still at beginning
        vx = 0;
        vy = 0;
    }
 
    public void update(long timePassed) {
        x += vx * timePassed;
        y += vy * timePassed;
    }
    
    public Rectangle getRectangle() {
        return new Rectangle(Math.round(getX()), Math.round(getY()), getWidth(), getHeight());
    }
    
    public void setVelocityY(float vy) {
        this.vy = vy;
    }
    
    public void setVelocityX(float vx) {
        this.vx = vx;
    }
    
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public boolean isCollided() {
        return this.collided;
    }
    
    public void setCollided(boolean collided) {
        this.collided = collided;
    }
}