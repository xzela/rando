package com.moral.renderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.moral.entity.Paddle;

public class PaddleRenderer
{
	private final Paddle paddle;
	private final ShapeRenderer renderer;

	public PaddleRenderer(Paddle paddle)
	{
		this.paddle = paddle;
		this.renderer = new ShapeRenderer();
	}

	public void render(SpriteBatch batch, OrthographicCamera cam)
	{
		this.renderer.setProjectionMatrix(cam.combined);
		this.renderer.begin(ShapeType.FilledRectangle);
		this.renderer.setColor(Color.RED);
		this.renderer.filledRect(this.paddle.getBounds().x,
				this.paddle.getBounds().y,
				this.paddle.getBounds().width,
				this.paddle.getBounds().height);
		this.renderer.end();
	}
}
