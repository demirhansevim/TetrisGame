package Game.Listener.Commands;

import Game.TetrisGame;


public class RotateCommand implements Command {
     
    @Override
    public void execute(TetrisGame game) {
        game.rotate();
    }

}
