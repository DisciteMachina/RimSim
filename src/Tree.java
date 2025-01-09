import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tree {
    private int x, y;
    private Image image;
    Random random = new Random();
    int scale;

    public Tree(int windowWidth, int windowHeight, Image image) {
        this.x = random.nextInt(windowWidth);
        this.y = random.nextInt(windowHeight);
        this.image = image;
        scale = 50;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, scale, scale);
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, scale,scale,null);
    }
}
