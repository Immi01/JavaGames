package at.eim.games.firstgame;

import org.newdawn.slick.Graphics;

public class Rectangle {

    private float x;
    private float y;
    private ObjectsGame.DIRECTION direction;
    private final float speed;

    public Rectangle(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        direction = ObjectsGame.DIRECTION.RIGHT;
    }

    public void update(int delta) {
        switch (this.direction) {
            case RIGHT: {
                this.x += (float) delta/speed;
                if (this.x > 600)
                    this.direction = ObjectsGame.DIRECTION.DOWN;
            } break;

            case DOWN: {
                this.y += (float) delta/speed;
                if (this.y > 400)
                    this.direction = ObjectsGame.DIRECTION.LEFT;
            } break;

            case LEFT: {
                this.x -= (float) delta/speed;
                if (this.x < 100)
                    this.direction = ObjectsGame.DIRECTION.UP;
            } break;

            case UP: {
                this.y -= (float) delta/speed;
                if (this.y < 100)
                    this.direction = ObjectsGame.DIRECTION.RIGHT;
            } break;
        }
    }

    public void render(Graphics graphics) {
        graphics.drawRect((int)this.x,(int)this.y,100,100);
    }

}
