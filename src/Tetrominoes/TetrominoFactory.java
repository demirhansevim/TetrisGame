package Tetrominoes;

public class TetrominoFactory {
    private Tetromino tetromino;
    public Tetromino createShape(String type){
        
        switch(type){
            case "ITetromino":
                tetromino = new ITetromino();
                break;
            case "JTetromino":
                tetromino = new JTetromino();
                break;
            case "LTetromino":
                tetromino = new LTetromino();
                break;
            case "OTetromino":
                tetromino = new OTetromino();
                break;
            case "STetromino":
                tetromino = new STetromino();
                break;
            case "TTetromino":
                tetromino = new TTetromino();
                break;
            case "ZTetromino":
                tetromino = new ZTetromino();
                break;
            case "NoTetromino":
                tetromino = new NoTetromino();
                break;
            default:
                tetromino = null;
        }
        return tetromino;
    }
}
