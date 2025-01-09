import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends Canvas {
    private final Color earthBrown = new Color(0x6B4226);
    private final ArrayList<Tree> trees = new ArrayList<>();
    private final Image treeImage;

    public Board() {
        treeImage = new ImageIcon("resources/tree.png").getImage();
        int windowWidth = 1024;
        int windowHeight = 576;

        for (int i = 0; i < 100; i++) {
            Tree newTree = generateTree(windowWidth, windowHeight);
            trees.add(newTree);
        }

        JFrame window = new JFrame("Simulation");
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(earthBrown);

        window.add(this);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private Tree generateTree(int windowWidth, int windowHeight) {
        Tree newTree;
        boolean overLapping;

        do {
            newTree = new Tree(windowWidth, windowHeight, treeImage);
            overLapping = false;

            for (Tree tree : trees) {
                if (newTree.getBounds().intersects(tree.getBounds())) {
                    overLapping = true;
                    break;
                }
            }
        } while (overLapping);
        return newTree;
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);

        for (Tree tree : trees) {
            tree.draw(g);
        }
    }
}
