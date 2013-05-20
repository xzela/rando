package com.moral.startest;

import com.badlogic.gdx.Game;
import com.moral.startest.screens.MainMenuScreen;

public class StarTest extends Game
{
	public MainMenuScreen mainMenuScreen;
	public GameScreen gameScreen;

	@Override
	public void create()
	{
		mainMenuScreen = new MainMenuScreen(this);
		gameScreen = new GameScreen();
		setScreen(mainMenuScreen);
	}

}
