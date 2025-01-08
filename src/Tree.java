import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tree {
    private int x, y;
    private Image image;
    Random random = new Random();

    public Tree(int windowWidth, int windowHeight, Image image) {
        this.x = random.nextInt(windowWidth);
        this.y = random.nextInt(windowHeight);
        this.image = image;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
