package Game;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;

import Tetrominoes.CreateTetromino;
import Tetrominoes.TetrominoFactory.Tetromino;
import Tetrominoes.TetrominoFactory.TetrominoFactory;

import Game.GameStates.GameState;
import Game.GameStates.GameRunning;
import Game.GameStates.GamePaused;

import Game.Listener.KeyboardListener;

public class TetrisGame extends JPanel {

    private int width = 10;
    private int height = 20;
    private int gameSpeed = 180;
    private Timer gameRunning;
    private boolean atBottom;
    private int score = 0;
    private CreateTetromino currentTetromino;
    private int currentTetrominoX = 0;
    private int currentTetrominoY = 0;
    private JLabel scoreLabel;
    private JLabel isPaused;
    private Tetromino[] board;
    protected TetrominoFactory factory = TetrominoFactory.getInstance();
    private GameState state = GameRunning.getInstance();

    public TetrisGame(TetrisWindow parent) {
        scoreLabel = parent.getScore();
        isPaused = parent.getPaused();
        addKeyListener(new KeyboardListener(this));

    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getPaused() {
        return isPaused;
    }

    public int getScore() {
        return score;
    }

    // Returns tetromino at location
    private Tetromino findTetromino(int x, int y) {
        return board[(y * width) + x];
    }

    // Initializes the game
    public void startGame() {
        ActionListener playGame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTetromino();
            }
        };
        currentTetromino = new CreateTetromino();
        board = new Tetromino[width * height];

        score = 0;
        scoreLabel.setText(String.valueOf(score));
        atBottom = false;
        resetBoard();
        createNewTetromino();
        gameRunning = new Timer(gameSpeed, playGame);
        gameRunning.start();
    }

    // Checks if tetromino can move down, draws it on the board if it can't
    private void updateTetromino() {
        if (state.getStateName().equals("GamePaused")) {
            return;
        }
        if (atBottom) {
            atBottom = false;
            createNewTetromino();
        } else {
            if (!moveTetromino(currentTetromino, currentTetrominoX, currentTetrominoY - 1)) {
                drawDroppedTetromino();
            }
        }
        repaint();
    }

    // Override for paintComponent called by repaint() in updateTetromino()
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateBoard(g);
    }

    // Updates the board with each tick, draws the tetrominoes on the board
    private void updateBoard(Graphics g) {
        int boardTop = (int) getSize().getHeight() - height * ((int) getSize().getHeight() / height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tetromino shape = findTetromino(j, height - i - 1);
                drawTetromino(g, j * ((int) getSize().getWidth() / width),
                        boardTop + i * ((int) getSize().getHeight() / height), shape);
            }
        }
        if (currentTetromino.getTetromino().toString() != "NoTetromino") {
            for (int i = 0; i < 4; i++) {
                int x = currentTetrominoX + currentTetromino.tetrominoX(i);
                int y = currentTetrominoY - currentTetromino.tetrominoY(i);
                drawTetromino(g, x * ((int) getSize().getWidth() / width),
                        boardTop + (height - y - 1) * ((int) getSize().getHeight() / height),
                        currentTetromino.getTetromino());
            }
        }
    }

    // Fills the board with empty tetrominoes
    private void resetBoard() {
        for (int i = 0; i < height * width; i++) {
            board[i] = factory.createShape("NoTetromino");
        }
    }

    // Draws the dropped tetrominoes and checks if the line is full
    private void drawDroppedTetromino() {
        for (int i = 0; i < 4; i++) {
            int x = currentTetrominoX + currentTetromino.tetrominoX(i);
            int y = currentTetrominoY - currentTetromino.tetrominoY(i);
            board[(y * width) + x] = currentTetromino.getTetromino();
        }

        removeFullLines();

        if (!atBottom) {
            createNewTetromino();
        }
    }

    // Creates a new tetromino at the top of the board
    private void createNewTetromino() {
        currentTetromino.createRandomTetromino();
        currentTetrominoX = width / 2;
        currentTetrominoY = height - 1 + currentTetromino.tetrominoTop();

        if (!moveTetromino(currentTetromino, currentTetrominoX, currentTetrominoY)) {
            gameRunning.stop();
            JOptionPane.showMessageDialog(null, String.format("Your score was %d", score), "Game Over",
                    JOptionPane.ERROR_MESSAGE);
            startGame();
        }
    }

    // Checks if the tetromino can move to the given location
    private boolean moveTetromino(CreateTetromino newPiece, int newX, int newY) {
        for (int i = 0; i < 4; i++) {
            int x = newX + newPiece.tetrominoX(i);
            int y = newY - newPiece.tetrominoY(i);
            if (x < 0 || x >= width || y < 0 || y >= height) {
                return false;
            }
            if (findTetromino(x, y).toString() != "NoTetromino") {
                return false;
            }
        }
        currentTetromino = newPiece;
        currentTetrominoX = newX;
        currentTetrominoY = newY;
        repaint();

        return true;
    }

    // Checks all lines to see if they are full, remove them if they are and
    // increase the score
    private void removeFullLines() {
        int addedScore = 0;
        for (int i = height - 1; i >= 0; i--) {
            boolean lineIsFull = true;
            for (int j = 0; j < width; j++) {
                if (findTetromino(j, i).toString() == "NoTetromino") {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                ++addedScore;
                for (int k = i; k < height - 1; k++) {
                    for (int j = 0; j < width; j++) {
                        board[(k * width) + j] = findTetromino(j, k + 1);
                    }
                }
            }
        }

        if (addedScore > 0) {
            score += addedScore;
            scoreLabel.setText(String.valueOf(score));
            atBottom = true;
            currentTetromino.setTetromino(factory.createShape("NoTetromino"));
        }
    }

    private void drawTetromino(Graphics g, int x, int y, Tetromino tetromino) {
        var color = new Color(255, 255, 255);
        if (tetromino.toString() == "LTetromino")
            color = new Color(168, 84, 50);
        if (tetromino.toString() == "STetromino")
            color = new Color(168, 157, 52);
        if (tetromino.toString() == "ZTetromino")
            color = new Color(121, 168, 50);
        if (tetromino.toString() == "TTetromino")
            color = new Color(50, 149, 168);
        if (tetromino.toString() == "ITetromino")
            color = new Color(88, 50, 169);
        if (tetromino.toString() == "JTetromino")
            color = new Color(168, 50, 164);
        if (tetromino.toString() == "OTetromino")
            color = new Color(224, 16, 19);

        g.setColor(color);
        g.fillRect(x, y, ((int) getSize().getWidth() / width) - 1, ((int) getSize().getHeight() / height) - 1);

    }

    public void pause() {
        if (state.getStateName().equals("GameRunning")) {
            state = GamePaused.getInstance();
        } else if (state.getStateName().equals("GamePaused")) {
            state = GameRunning.getInstance();
        }
        state.pause(this);
        repaint();

    }

    public void restart() {
        gameRunning.stop();
        if (state.getStateName().equals("GamePaused")) {
            isPaused.setText("");
        }
        state = GameRunning.getInstance();
        startGame();
    }

    public void goLeft() {
        if (currentTetromino.getTetromino().toString() == "NoTetromino") {
            return;
        }
        moveTetromino(currentTetromino, currentTetrominoX - 1, currentTetrominoY);
    }

    public void goRight() {
        if (currentTetromino.getTetromino().toString() == "NoTetromino") {
            return;
        }
        moveTetromino(currentTetromino, currentTetrominoX + 1, currentTetrominoY);
    }

    public void rotate() {
        if (currentTetromino.getTetromino().toString() == "NoTetromino") {
            return;
        }

        moveTetromino(currentTetromino.rotate(), currentTetrominoX, currentTetrominoY);

    }
}
