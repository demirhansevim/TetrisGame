package Game;
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
    private JLabel isPaused;

    private TetrisWindow() {

        JLabel scoreString = new JLabel("Score:");
        score = new JLabel("0");
        scoreboard = new JPanel();
        isPaused = new JLabel();
        scoreboard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scoreboard, BorderLayout.NORTH);
        scoreboard.add(scoreString, BorderLayout.CENTER);
        scoreboard.add(score, BorderLayout.CENTER);
        scoreboard.add(isPaused, BorderLayout.CENTER);

        var tetrisGame = new TetrisGame(this);
        add(tetrisGame);
        tetrisGame.setFocusable(true);
        tetrisGame.startGame();

        setSize(300, 600);
        setTitle("Tetris Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    JLabel getScore() {
        return score;
    }
    JLabel getPaused() {
        return isPaused;
    }

    public static TetrisWindow getInstance() {
        if (tetrisWindow == null)
            tetrisWindow = new TetrisWindow();
        return tetrisWindow;
    }
}
