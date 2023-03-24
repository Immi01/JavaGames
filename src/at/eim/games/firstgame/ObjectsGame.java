package at.eim.games.firstgame;

import org.newdawn.slick.*;

public class ObjectsGame extends BasicGame {

    public enum DIRECTION {UP, RIGHT, DOWN, LEFT};
    private Rectangle rectangle;
    private Oval oval;
    private Circle circle;
    private float speed;

    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        speed = 1.8f;
        rectangle = new Rectangle(100.0f, 100.0f, speed);
        oval = new Oval(200.0f, 0.0f, speed);
        circle = new Circle(0.0f, 100.0f, speed);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        rectangle.update(delta);
        oval.update(delta);
        circle.update(delta);

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        rectangle.render(graphics);
        oval.render(graphics);
        circle.render(graphics);
        graphics.drawString("Hello World", 50, 50);
    }

    public static void main(String[] argv) {
        try{
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
