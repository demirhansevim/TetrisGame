package Game.GameStates;


import Game.TetrisGame;

public class GamePaused implements GameState{
    private static GamePaused ourInstance = new GamePaused();
    private String stateName = "GamePaused";

    private GamePaused(){
    }

    public static GamePaused getInstance(){
        return ourInstance;
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public void pause(TetrisGame parent) {
        parent.getPaused().setText("Paused");
    }

}
