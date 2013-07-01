package com.moral.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
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

	SpriteBatch sb;

	public GameScreen(PongGame game)
	{
		this.sb = new SpriteBatch();
		this.game = game;
		Vector2 pos = new Vector2(1f, 2f);
		this.player = new PlayerPaddle(pos);

		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();

	}

	@Override
	public void render(float delta)
	{
		//this.player.shape.setProjectionMatrix(this.cam.combined);
		this.sb.begin();
		Rectangle rect = this.player.getBounds();
		this.player.shape.begin(ShapeType.Rectangle);
		this.player.shape.setColor(new Color(0, 1, 0, 1));
		this.player.shape.rect(rect.x, rect.y, rect.width, rect.height);
		this.player.shape.end();

		this.sb.end();
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
