package Game.Listener.Commands;

import Game.TetrisGame;

public class Restart implements Command {
   
    @Override
    public void execute(TetrisGame game) {
      game.restart();
    }

}
