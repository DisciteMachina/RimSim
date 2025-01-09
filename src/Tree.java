import java.awt.*;
import java.util.Random;

public class Tree {
    private int x, y;
    private Image image;
    private int scale;
    private int trunkHeight;

    Random random = new Random();

    public Tree(int windowWidth, int windowHeight, Image image) {
        this.x = random.nextInt(windowWidth);
        this.y = random.nextInt(windowHeight);
        this.image = image;
        scale = 50;
        this.trunkHeight = scale / 2;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, scale, scale);
    }

    public Rectangle getFoliageBounds() {
        return new Rectangle(x, y, scale, scale - trunkHeight);
    }

    public Rectangle getTrunkBounds() {
        return new Rectangle(x, y + scale - trunkHeight, scale, trunkHeight);
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, scale,scale,null);
    }
}
