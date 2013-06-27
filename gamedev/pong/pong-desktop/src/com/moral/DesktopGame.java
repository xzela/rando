package com.moral;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopGame {
	public static void main (String[] args)
	{
		PongGame game = new PongGame();
		new LwjglApplication(game, game.WINDOW_TITLE, game.WINDOW_WIDTH, game.WINDOW_HEIGHT, false);
	}
}