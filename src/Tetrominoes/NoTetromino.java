package Tetrominoes;

public class NoTetromino extends Tetromino{

    private static final int[][] shape = {{0,0},{0,0},{0,0},{0,0}};
    public NoTetromino(){
         super(shape);
    }
    @Override
    public String toString() {
        return "NoTetromino";
    }
}
