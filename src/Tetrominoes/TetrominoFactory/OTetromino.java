package Tetrominoes.TetrominoFactory;

public class OTetromino extends Tetromino{

    private static final int[][] shape = {{0,0},{1,0},{0,1},{1,1}};
    public OTetromino(){
         super(shape);
    }
    @Override
    public String toString() {
        return "OTetromino";
    }
}
