package Game.Listener.Commands;

import Game.TetrisGame;


public class GoRightCommand implements Command {

    @Override
    public void execute(TetrisGame game) {
        game.goRight();
    }

}
