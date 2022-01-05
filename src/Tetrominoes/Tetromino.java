package Tetrominoes;

public abstract class Tetromino {
    private int[][] shape;
    public Tetromino(int[][] shape){
        this.shape = shape;
    }
    public int[][] getShape(){
        return shape;

    }
    public abstract String toString();
}
