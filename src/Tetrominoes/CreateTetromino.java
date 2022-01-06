package Tetrominoes;

import java.util.Random;

import Tetrominoes.TetrominoFactory.Tetromino;
import Tetrominoes.TetrominoFactory.TetrominoFactory;

public class CreateTetromino {
    protected TetrominoFactory factory = TetrominoFactory.getInstance();

    private String[] tetrominoes = { "ZTetromino", "STetromino", "ITetromino", "TTetromino", "OTetromino",
            "LTetromino", "JTetromino"
    };
    private Tetromino tetromino;

    public CreateTetromino() {
        setTetromino(factory.createShape("NoTetromino"));
    }

    public void setTetromino(Tetromino tetromino) {
        this.tetromino = tetromino;
    }

    public void setX(int index, int x) {
        tetromino.getShape()[index][0] = x;
    }

    public void setY(int index, int y) {
        tetromino.getShape()[index][1] = y;
    }

    public int tetrominoX(int index) {
        return tetromino.getShape()[index][0];
    }

    public int tetrominoY(int index) {
        return tetromino.getShape()[index][1];
    }

    public Tetromino getTetromino() {
        return tetromino;
    }

    public int tetrominoTop() {
        int top = tetromino.getShape()[0][1];

        for (int i = 0; i < 4; i++) {
            top = Math.min(top, tetromino.getShape()[i][1]);
        }
        return top;
    }

  

    public void createRandomTetromino() {
        var r = new Random();
        int x = r.nextInt(tetrominoes.length);
        setTetromino(factory.createShape(tetrominoes[x]));
    }

    public CreateTetromino rotate() {

        if (tetromino.toString() == "OTetromino") {

            return this;
        }

        CreateTetromino rotatedTetromino = new CreateTetromino();

        rotatedTetromino.tetromino = tetromino.clone();

        int[][] shape = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; ++j) {
                shape[i][j] = tetromino.getShape()[i][j];
            }
        }
        for (int i = 0; i < 4; ++i) {

            rotatedTetromino.setX(i, shape[i][1]);
            rotatedTetromino.setY(i, -shape[i][0]);
        }

        return this;
    }
}
