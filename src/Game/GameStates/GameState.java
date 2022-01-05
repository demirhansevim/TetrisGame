package Game.GameStates;

import Game.TetrisGame;


public interface GameState {
    void pause(TetrisGame parent);  
    String getStateName();
}
