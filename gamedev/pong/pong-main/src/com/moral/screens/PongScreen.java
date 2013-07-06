package com.moral.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.moral.PongGame;
import com.moral.entity.AIPaddle;
import com.moral.entity.Ball;
import com.moral.entity.Paddle;
import com.moral.entity.PlayerPaddle;

public class PongScreen implements Screen, InputProcessor
{
	Board board;

	PongGame game;
	PlayerPaddle player1;
	AIPaddle ai;
	Ball ball;
	private final OrthographicCamera cam;

	SpriteBatch batch;

	public PongScreen(PongGame game)
	{
		float paddle_y_start_position = (Board.BOARD_HEIGHT / 2 ) - Paddle.HEIGHT / 2;
		this.board = game.board;

		this.cam = new OrthographicCamera(Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
		this.batch = new SpriteBatch();

		this.game = game;
		this.player1 = new PlayerPaddle(new Vector2(0.5f, paddle_y_start_position));
		this.ai = new AIPaddle(new Vector2(9.5f, paddle_y_start_position));
		this.ball = new Ball(this.game, new Vector2(Board.BOARD_WIDTH / 2, Board.BOARD_HEIGHT / 2));

		this.cam.setToOrtho(false, Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		this.updateGame(delta);
		this.batch.begin();
		this.player1.render(this.batch, this.cam);
		this.ai.render(this.batch, this.cam);
		this.ball.render(this.batch, this.cam);
		this.board.render(); // don't need the batch or cam?
		this.batch.end();

	}

	/**
	 * update the game objects
	 * 
	 * @param delta
	 */
	public void updateGame(float delta)
	{
		// update the game objects
		this.cam.update();
		this.player1.update(delta);
		this.ai.update(this.ball, delta);
		this.ball.update(this.player1, this.ai, delta);

		// end game when either player or ai gets score goal
		if (this.board.ai_score >= this.game.scoreGoal || this.board.player_score >= this.game.scoreGoal)
		{
			// set end screen
			game.setScreen(this.game.endScreen);
		}

		// exit game when Q is pressed
		if(Gdx.input.isKeyPressed(Keys.Q))
		{
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
		Gdx.input.setInputProcessor(this);
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

	@Override
	public boolean keyDown(int keycode)
	{
		if (keycode == Keys.UP)
			this.player1.controller.upPressed();
		if (keycode == Keys.DOWN)
			this.player1.controller.downPressed();
		return true;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		if (keycode == Keys.UP)
			this.player1.controller.upReleased();
		if (keycode == Keys.DOWN)
			this.player1.controller.downReleased();
		return true;
	}

	@Override
	public boolean keyTyped(char character)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
