package Tetrominoes;

public class JTetromino extends Tetromino{

    private static final int[][] shape = {{1,-1},{0,-1},{0,0},{0,1}};
    public JTetromino(){
         super(shape);
    }
    @Override
    public String toString() {
        return "JTetromino";
    }
}
