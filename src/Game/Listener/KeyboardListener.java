package Game.Listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Game.TetrisGame;
import Game.Listener.Commands.Command;
import Game.Listener.Commands.GoLeftCommand;
import Game.Listener.Commands.GoRightCommand;
import Game.Listener.Commands.RotateCommand;
import Game.Listener.Commands.Pause;
import Game.Listener.Commands.Restart;

public class KeyboardListener extends KeyAdapter {
	
    private Command command;
    private TetrisGame game;

    public KeyboardListener(TetrisGame game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        command = null;
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_LEFT) {
            command = new GoLeftCommand();
        } else if (keycode == KeyEvent.VK_RIGHT) {
            command = new GoRightCommand();
        } else if (keycode == KeyEvent.VK_UP) {
            command = new RotateCommand();
        } else if (keycode == KeyEvent.VK_P) {
            command = new Pause();
        } else if (keycode == KeyEvent.VK_R) {
            command = new Restart();
        }
        if (command != null) {
            command.execute(game);
        }
    }

}
