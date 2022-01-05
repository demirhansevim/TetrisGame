import java.util.Random;
import Tetrominoes.TetrominoFactory;
import Tetrominoes.Tetromino;

public class Shape {

    protected TetrominoFactory factory = new TetrominoFactory();
    private String[] tetrominoes = { "ZTetromino", "STetromino", "ITetromino", "TTetromino","OTetromino",
    "LTetromino", "JTetromino"
    };
    private Tetromino pieceShape;

    public Shape() {
        setShape(factory.createShape("NoTetromino"));
    }

    protected void setShape(Tetromino shape) {
        pieceShape = shape;
    }

    private void setX(int index, int x) {
        pieceShape.getShape()[index][0] = x;
    }

    private void setY(int index, int y) {
        pieceShape.getShape()[index][1] = y;
    }

    public int x(int index) {
        return pieceShape.getShape()[index][0];
    }

    public int y(int index) {
        return pieceShape.getShape()[index][1];
    }

    public Tetromino getShape() {
        return pieceShape;
    }

    public void setRandomShape() {

        var r = new Random();
        int x = r.nextInt(tetrominoes.length);
        setShape(factory.createShape(tetrominoes[x]));
    }

    public int minX() {

        int m = pieceShape.getShape()[0][0];

        for (int i = 0; i < 4; i++) {

            m = Math.min(m, pieceShape.getShape()[i][0]);
        }

        return m;
    }

    public int minY() {

        int m = pieceShape.getShape()[0][1];

        for (int i = 0; i < 4; i++) {

            m = Math.min(m, pieceShape.getShape()[i][1]);
        }
        System.out.println(m);
        return m;
    }

    public Shape rotateLeft() {



        if (pieceShape.toString() == "OTetromino") {

            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {

            result.setX(i, y(i));
            result.setY(i, -x(i));
            
        }

        return result;
    }

    public Shape rotateRight() {

        if (pieceShape.toString() == "OTetromino") {

            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {

            result.setX(i, -y(i));
            result.setY(i, x(i));
        }

        return result;
    }
}
