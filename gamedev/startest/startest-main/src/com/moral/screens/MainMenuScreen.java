package com.moral.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.moral.startest.StarTest;

public class MainMenuScreen implements Screen 
{

	StarTest game;
	
	public MainMenuScreen(StarTest game)
	{
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.Z))
		{
			game.setScreen(game.gameScreen);
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
