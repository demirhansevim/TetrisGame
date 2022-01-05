package Tetrominoes.TetrominoFactory;

public class LTetromino extends Tetromino{

    private static final int[][] shape = {{-1,-1},{0,-1},{0,0},{0,1}};
    public LTetromino(){
         super(shape);
    }
    @Override
    public String toString() {
        return "LTetromino";
    }
}
