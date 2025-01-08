import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Board extends Canvas {
    private final Color earthBrown = new Color(0x6B4226);
    private final Random random = new Random();
    private ArrayList<Tree> trees = new ArrayList<>();
    private Image treeImage;

    public Board() {
        treeImage = new ImageIcon("resources/tree.png").getImage(); // Adjust path as needed

        for (int i = 0; i < 100; i++) {
            trees.add(new Tree(1024, 576, treeImage));
        }

        JFrame window = new JFrame("Simulation");
        this.setPreferredSize(new Dimension(1024, 576));
        this.setBackground(earthBrown);

        window.add(this);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);

        for (Tree tree : trees) {
            tree.draw(g);
        }
    }
}
