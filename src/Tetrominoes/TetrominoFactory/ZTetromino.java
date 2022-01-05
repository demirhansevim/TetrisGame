package Tetrominoes.TetrominoFactory;

public class ZTetromino extends Tetromino{

    private static final int[][] shape = {{0,-1},{0,0},{-1,0},{-1,1}};
    public ZTetromino(){
         super(shape);
    }
    @Override
    public String toString() {
        return "ZTetromino";
    }
}
