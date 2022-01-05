package Tetrominoes.TetrominoFactory;

public class TTetromino extends Tetromino{

    private static final int[][] shape = {{-1,0},{0,0},{1,0},{0,1}};
    public TTetromino(){
         super(shape);
    }
    @Override
    public String toString() {
        return "TTetromino";
    }
}
