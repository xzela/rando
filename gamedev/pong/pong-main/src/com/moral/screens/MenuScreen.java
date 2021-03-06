package com.moral.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.moral.PongGame;

public class MenuScreen implements Screen
{
	PongGame game;
	SpriteBatch batch;
	BitmapFont font;

	public MenuScreen(PongGame game)
	{
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
		this.game = game;
	}

	/**
	 * render the menu screen
	 */
	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// start sprite batch
		this.batch.begin();
		// render text to screen
		font.setColor(Color.WHITE);
		font.draw(this.batch, "Press Z to start", this.game.WINDOW_WIDTH / 2 - 50, this.game.WINDOW_HEIGHT / 2);
		this.batch.end();
		//end sprite batch

		// listen for key input to start game
		if (Gdx.input.isKeyPressed(Keys.Z))
		{
			// set the pongScreen as current screen
			game.setScreen(game.pongScreen);
		}
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

}
