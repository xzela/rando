package com.moral;

import com.badlogic.gdx.Game;
import com.moral.screens.GameScreen;

public class PongGame extends Game
{
	public final int WINDOW_WIDTH = 480 ;
	public final int WINDOW_HEIGHT = 320;
	public final String WINDOW_TITLE = "Pong Game";

	public GameScreen gs;


	@Override
	public void create()
	{
		gs = new GameScreen(this);
		setScreen(gs);
	}

}