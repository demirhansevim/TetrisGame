package Tetrominoes.TetrominoFactory;

public abstract class Tetromino implements Cloneable {
    private int[][] shape;
    private String color;

    public Tetromino(int[][] shape) {
        this.shape = shape;
    }

    public int[][] getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    public Tetromino clone() {
        Tetromino newTetromino = null;

        try {
            newTetromino = (Tetromino) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return newTetromino;
    }

    public abstract String toString();
}
