package Game.GameStates;

import Game.TetrisGame;

public class GameRunning implements GameState{
    private static GameRunning ourInstance = new GameRunning();
    private String stateName = "GameRunning";

    private GameRunning(){
    }

    public static GameRunning getInstance(){
        return ourInstance;
    }

    public String getStateName() {
        return stateName;
    }
    @Override
    public void pause(TetrisGame parent) {
        parent.getPaused().setText("");
    }

}
