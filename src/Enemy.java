public class Enemy extends Entity {
    
    public enum SpeedDirection {
        LEFT, RIGHT, UP, DOWN
    }
    
    private SpeedDirection direction;
    
    public Enemy(float x, float y, int width, int height, SpeedDirection direction ) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direction = direction;
        
        switch(direction) {
        case LEFT:
            vy = 0;
            vx = -0.3f;
            break;
        case RIGHT:
            vy = 0;
            vx = 0.3f;
            break;
        case UP:
            vy = -0.3f;
            vx = 0;
            break;
        case DOWN:
            vy = 0.3f;
            vx = 0;
            break;
        }
    }
    
    public SpeedDirection getDirection() {
        return this.direction;
    }
}