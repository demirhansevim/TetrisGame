package Tetrominoes;

public class ITetromino extends Tetromino{

    private static final int[][] shape = {{0,-1},{0,0},{0,1},{0,2}};
    public ITetromino(){
         super(shape);
    }
    @Override
    public String toString() {
        return "ITetromino";
    }
}
