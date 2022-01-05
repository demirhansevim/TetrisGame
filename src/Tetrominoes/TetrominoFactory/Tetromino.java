package Tetrominoes.TetrominoFactory;

public abstract class Tetromino {
    private int[][] shape;
    private String color;
    public Tetromino(int[][] shape){
        this.shape = shape;
    }
    public int[][] getShape(){
        return shape;
    }
    public String getColor(){
        return color;
    }
    public abstract String toString();
}
