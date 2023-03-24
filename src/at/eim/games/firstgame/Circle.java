package at.eim.games.firstgame;

import org.newdawn.slick.Graphics;

public class Circle {

    private float x;
    private float y;
    private ObjectsGame.DIRECTION direction;
    private final float speed;

    public Circle(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = ObjectsGame.DIRECTION.RIGHT;
    }

    public void update(int delta) {
        if(this.direction == ObjectsGame.DIRECTION.RIGHT) {
            this.y += (float) delta/speed;
            if (this.y > 450)
                direction = ObjectsGame.DIRECTION.LEFT;
        } else {
            this.y -= (float) delta/speed;
            if (this.y < 50)
                direction = ObjectsGame.DIRECTION.RIGHT;
        }
    }

    public void render(Graphics graphics) {
        graphics.drawOval(0,(int)this.y,50,50);
    }

}
