package at.eim.games.firstgame;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {

    private float x;
    private float y;
    private float ovalX;
    private float circleY;
    private float speed;
    private byte stateRect;
    private boolean stateOval;
    private boolean stateCircle;

    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 100.0f;
        this.y = 100.0f;
        this.ovalX = 200.0f;
        this.circleY = 100.0f;
        this.speed = 1.8f;
        this.stateRect = 0;
        this.stateOval = true;
        this.stateCircle = true;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        if(this.stateOval) {
            this.ovalX += (float) delta/speed;
            if (this.ovalX > 500)
                stateOval = false;
        } else {
            this.ovalX -= (float) delta/speed;
            if (this.ovalX < 50)
                stateOval = true;
        }

        if(this.stateCircle) {
            this.circleY += (float) delta/speed;
            if (this.circleY > 450)
                stateCircle = false;
        } else {
            this.circleY -= (float) delta/speed;
            if (this.circleY < 50)
                stateCircle = true;
        }

        switch (this.stateRect) {
            case 0: {
                this.x += (float) delta/speed;
                if (this.x > 600)
                    this.stateRect = 1;
            } break;

            case 1: {
                this.y += (float) delta/speed;
                if (this.y > 400)
                    this.stateRect = 2;
            } break;

            case 2: {
                this.x -= (float) delta/speed;
                if (this.x < 100)
                    this.stateRect = 3;
            } break;

            case 3: {
                this.y -= (float) delta/speed;
                if (this.y < 100)
                    this.stateRect = 0;
            } break;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect((int)this.x,(int)this.y,100,100);
        graphics.drawOval((int)this.ovalX,0,100,50);
        graphics.drawOval(0,(int)this.circleY,50,50);
        graphics.drawString("Hello World", 50, 50);
    }

    public static void main(String[] argv) {
        try{
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
