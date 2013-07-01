package com.moral.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.moral.PongGame;
import com.moral.entity.PlayerPaddle;

public class GameScreen implements Screen
{
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;

	PongGame game;
	PlayerPaddle player;
	private final OrthographicCamera cam;

	SpriteBatch batch;
	ShapeRenderer sr;

	public GameScreen(PongGame game)
	{
		float h = CAMERA_HEIGHT;
		float w = CAMERA_WIDTH;
		this.cam = new OrthographicCamera(w, h);
		this.batch = new SpriteBatch();
		this.sr = new ShapeRenderer();

		this.game = game;
		Vector2 pos = new Vector2(1f, 3f);
		this.player = new PlayerPaddle(pos);


		this.cam.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
		//this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();

	}

	@Override
	public void render(float delta)
	{
		this.batch.begin();
			this.player.render(this.batch, this.cam);
		this.batch.end();

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
