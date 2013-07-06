package com.moral;

import com.badlogic.gdx.Game;
import com.moral.screens.Board;
import com.moral.screens.EndScreen;
import com.moral.screens.MenuScreen;
import com.moral.screens.PongScreen;

public class PongGame extends Game
{
	public final int WINDOW_WIDTH = 480 ;
	public final int WINDOW_HEIGHT = 320;
	public final String WINDOW_TITLE = "Pong Game";

	public PongScreen pongScreen;
	public MenuScreen menuScreen;
	public EndScreen endScreen;

	public Board board;

	public int scoreGoal = 2;

	@Override
	public void create()
	{
		board = new Board(this);
		menuScreen = new MenuScreen(this);
		pongScreen = new PongScreen(this);
		endScreen = new EndScreen(this);

		setScreen(menuScreen);
	}

	public void reset()
	{
		create();
	}

}