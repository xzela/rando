package com.moral.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.moral.renderer.PaddleRenderer;

public class Paddle
{
	private final static float WIDTH = .25f;
	private final static float HEIGHT = 2f;

	private PaddleRenderer renderer;

	private final Rectangle bounds = new Rectangle();
	public Rectangle getBounds() { return this.bounds; }

	private final Vector2 position;
	public Vector2 getPosition() { return this.position;}
	public void setX(float x) { this.position.x = x; }
	public void setY(float y) { this.position.y = y; }


	public Paddle(Vector2 position)
	{
		this.position = position;
		this.bounds.setX(position.x);
		this.bounds.setY(position.y);
		this.bounds.height = HEIGHT;
		this.bounds.width = WIDTH;
		this.renderer = new PaddleRenderer(this);
	}

	public void render(SpriteBatch batch, OrthographicCamera cam)
	{
		this.renderer.render(batch, cam);
	}
}
