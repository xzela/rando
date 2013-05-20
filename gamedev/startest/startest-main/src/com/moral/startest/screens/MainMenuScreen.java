package com.moral.startest.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.moral.startest.StarTest;

public class MainMenuScreen implements Screen
{

	StarTest game;
	SpriteBatch spriteBatch;
	BitmapFont font;

	public MainMenuScreen(StarTest game)
	{
		spriteBatch = new SpriteBatch();
		font = new BitmapFont();
		this.game = game;
	}

	@Override
	public void render(float delta)
	{
		spriteBatch.begin();
			font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
			font.draw(spriteBatch, "press z", 10, 30);
		spriteBatch.end();

		if (Gdx.input.isKeyPressed(Keys.Z))
		{
			game.setScreen(game.gameScreen);
		}
	}

	@Override
	public void resize(int width, int height)
	{
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
