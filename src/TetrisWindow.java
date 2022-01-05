import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class TetrisWindow extends JFrame {
    private static TetrisWindow tetrisWindow;
    private JLabel score;
    private JPanel scoreboard;

    private TetrisWindow() {

        score = new JLabel("0");
        scoreboard = new JPanel();
        scoreboard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scoreboard, BorderLayout.NORTH);
        scoreboard.add(score, BorderLayout.CENTER);

        var board = new Board(this);
        add(board);
        board.start();

        setSize(250, 500);
        setTitle("Tetris Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    JLabel getScore() {
        return score;
    }

    public static TetrisWindow getInstance() {
        if (tetrisWindow == null)
            tetrisWindow = new TetrisWindow();
        return tetrisWindow;
    }
}
