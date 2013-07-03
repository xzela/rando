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
import com.moral.entity.PlayerPaddle;

public class GameScreen implements Screen, InputProcessor
{
	PongGame game;
	PlayerPaddle player1;
	AIPaddle ai;
	Ball ball;
	private final OrthographicCamera cam;

	SpriteBatch batch;

	public GameScreen(PongGame game)
	{
		this.cam = new OrthographicCamera(Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
		this.batch = new SpriteBatch();

		this.game = game;
		this.player1 = new PlayerPaddle(new Vector2(0.5f, 2.5f));
		this.ai = new AIPaddle(new Vector2(9.5f, 2.5f));
		this.ball = new Ball(new Vector2(5f,5f));

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
		this.batch.end();

	}

	public void updateGame(float delta)
	{
		//this.ball.collision(this.player, delta);
		this.cam.update();
		this.player1.update(delta);
		this.ball.update(this.player1, this.ai, delta);
		this.ai.update(this.ball, delta);
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
	public boolean keyDown(int keycode) {
		if (keycode == Keys.UP)
			this.player1.controller.upPressed();
		if (keycode == Keys.DOWN)
			this.player1.controller.downPressed();
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.UP)
			this.player1.controller.upReleased();
		if (keycode == Keys.DOWN)
			this.player1.controller.downReleased();
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
