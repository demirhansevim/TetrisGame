package Tetrominoes.TetrominoFactory;

public class STetromino extends Tetromino{

    private static final int[][] shape = {{0,-1},{0,0},{1,0},{1,1}};
    public STetromino(){
         super(shape);
    }
    @Override
    public String toString() {
        return "STetromino";
    }
}
