package com.moral.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.moral.PongGame;

public class EndScreen implements Screen
{

	PongGame game;
	SpriteBatch batch;
	BitmapFont font;

	public EndScreen(PongGame game)
	{
		this.game = game;
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
	}

	@Override
	public void render(float delta)
	{
		// clear screen
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// start sprite batch
		this.batch.begin();
		this.font.setColor(Color.RED);

		// determine winner based on score
		// and render appropriate text
		if (this.game.board.ai_score > this.game.board.player_score)
		{
			this.font.draw(this.batch, "AI WINS", this.game.WINDOW_WIDTH / 2 -50, this.game.WINDOW_HEIGHT / 2 + 15);
		}
		else
		{
			this.font.draw(this.batch, "PLAYER WINS", this.game.WINDOW_WIDTH / 2 -50, this.game.WINDOW_HEIGHT / 2 + 15);
		}
		// render instructions
		this.font.draw(this.batch, "PRESS 'R' TO TRY AGAIN", this.game.WINDOW_WIDTH / 2 - 50, this.game.WINDOW_HEIGHT / 2);
		this.font.draw(this.batch, "PRESS 'Q' TO QUIT", this.game.WINDOW_WIDTH / 2 - 50, this.game.WINDOW_HEIGHT / 2 - 15);
		this.batch.end();
		// end sprite batch

		// listen for input
		if (Gdx.input.isKeyPressed(Keys.R))
		{
			// restart game
			this.game.reset();
		}

		if(Gdx.input.isKeyPressed(Keys.Q))
		{
			// quit game
			Gdx.app.exit();
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
