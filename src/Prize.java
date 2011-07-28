public class Prize extends Entity {
    
    //have you collected the prize?
    private boolean collected;
    
    public Prize(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        //prizes should remain still... or shouldn't they?...
        vx = 0;
        vy = 0;
        
        //initializing collected to false
        collected = false;
    }
    
    public void setCollected(boolean collected) {
        this.collected = collected;
    }
    
    public boolean isCollected() {
        return collected;
    }
}