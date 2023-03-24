package at.eim.games.firstgame;

import org.newdawn.slick.Graphics;

public class Oval {

    private float x;
    private float y;
    private ObjectsGame.DIRECTION direction;
    private final float speed;

    public Oval(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = ObjectsGame.DIRECTION.RIGHT;
    }

    public void update(int delta) {
        if(this.direction == ObjectsGame.DIRECTION.RIGHT) {
            this.x += (float) delta/speed;
            if (this.x > 500)
                direction = ObjectsGame.DIRECTION.LEFT;
        } else {
            this.x -= (float) delta/speed;
            if (this.x < 50)
                direction = ObjectsGame.DIRECTION.RIGHT;
        }
    }

    public void render(Graphics graphics) {
        graphics.drawOval((int)this.x,0,100,50);
    }

}
