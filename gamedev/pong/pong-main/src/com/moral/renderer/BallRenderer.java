package com.moral.renderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.moral.entity.Ball;

public class BallRenderer
{

	private final Ball ball;
	private final ShapeRenderer renderer;

	public BallRenderer(Ball ball)
	{
		this.ball = ball;
		this.renderer = new ShapeRenderer();
	}

	public void render(SpriteBatch batch, OrthographicCamera cam)
	{
		this.renderer.setProjectionMatrix(cam.combined);
		this.renderer.begin(ShapeType.FilledRectangle);
		this.renderer.setColor(Color.BLUE);
		this.renderer.filledRect(this.ball.getPosition().x,
				this.ball.getPosition().y,
				this.ball.getBounds().width,
				this.ball.getBounds().height);
		this.renderer.end();
	}
}
