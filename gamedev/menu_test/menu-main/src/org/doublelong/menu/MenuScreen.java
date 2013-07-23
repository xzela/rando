package org.doublelong.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class MenuScreen implements Screen
{

	private final SpriteBatch batch;
	private final OrthographicCamera cam;

	private final Rectangle cursor;

	private final Rectangle[] menu;
	private final ShapeRenderer r;

	public MenuScreen()
	{
		this.batch = new SpriteBatch();
		this.cam = new OrthographicCamera(600, 600);
		this.menu = new Rectangle[2];
		this.cursor = new Rectangle(10f, 10f, 10f, 10f);
		this.r = new ShapeRenderer();
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.batch.begin();
		this.r.begin(ShapeType.FilledRectangle);
		this.r.filledRect(10f, 100f, 10f, 10f);
		this.r.end();
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
