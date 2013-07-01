package com.moral.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PlayerPaddle
{
	private final static float SIZE = 1f;

	public ShapeRenderer shape = new ShapeRenderer();

	private final Rectangle bounds = new Rectangle();
	public Rectangle getBounds() { return this.bounds; }

	private final Vector2 position;
	public Vector2 getPosition() { return this.position;}

	public PlayerPaddle(Vector2 position)
	{
		this.position = position;
		this.bounds.setX(position.x);
		this.bounds.setY(position.y);
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}
}
