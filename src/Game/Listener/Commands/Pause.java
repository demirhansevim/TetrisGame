package Game.Listener.Commands;

import Game.TetrisGame;


public class Pause implements Command {
        
    @Override
    public void execute(TetrisGame game) {
        game.pause();
    }

}
