package Tetrominoes.TetrominoFactory;

import java.util.HashMap;

public class TetrominoFactory {

    private static final HashMap<String, Tetromino> tetrominoMap = new HashMap<>();

    public Tetromino createShape(String type) {
    
        Tetromino tetromino = tetrominoMap.get(type);
        if (tetromino == null) {
            switch (type) {
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
            tetrominoMap.put(type, tetromino);
        }
        return tetromino;
    }
}
