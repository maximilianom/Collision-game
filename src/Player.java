public class Player extends Entity {
    
    //CONSTRUCTOR
    public Player(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        //player should remain still at the beginning
        vx = 0;
        vy = 0;
    }
}