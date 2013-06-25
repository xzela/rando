package com.moral.startest;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Monster
{

	static final float SIZE = 5f;

	Rectangle bounds = new Rectangle();
	Vector2 position = new Vector2();

	public Monster(Vector2 position)
	{
		this.position = position;
		this.bounds.setX(position.x);
		this.bounds.setY(position.y);

		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}

	public Rectangle getBounds()
	{
		return this.bounds;
	}

	public Vector2 getPosition()
	{
		return this.position;
	}
}
