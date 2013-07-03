package com.moral.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class AIPaddle extends Paddle
{

	public AIPaddle(Vector2 position)
	{
		super(position);
		this.color = Color.RED;
	}

	public void update(Ball ball, float delta)
	{
//		this.getPosition().x = ball.getPosition().x;
		this.getPosition().y = ball.getPosition().y - (this.getBounds().y / 2);
	}
}
