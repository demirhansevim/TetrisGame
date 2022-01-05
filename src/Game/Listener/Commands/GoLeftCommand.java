package Game.Listener.Commands;

import Game.TetrisGame;

public class GoLeftCommand implements Command {
    @Override
    public void execute(TetrisGame game) {
        game.goLeft();
    }

}
