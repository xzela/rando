package com.moral.entity;

import com.badlogic.gdx.math.Vector2;

public class PlayerPaddle extends Paddle
{
	private final static float WIDTH = .25f;
	private final static float HEIGHT = 2f;

	public PlayerPaddle(Vector2 position)
	{
		super(position);
	}

}
