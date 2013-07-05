package com.moral.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class AIPaddle extends Paddle
{

	private final float multi = 1;

	public AIPaddle(Vector2 position)
	{
		super(position);
		this.color = Color.RED;
	}

	public void update(Ball ball, float delta)
	{
		//		this.getPosition().x = ball.getPosition().x;
		if (ball.getDirection().x > 0)
		{
			float dir = Math.signum(ball.getPosition().y - (this.getBounds().y / 2));
			this.getPosition().y += dir * delta * (ball.ballSpeed * this.multi);
			if (dir > 0 && this.getPosition().y > ball.getPosition().y)
			{
				this.setY(ball.getPosition().y);
			}
			if (dir < 0 && this.getPosition().y < ball.getPosition().y)
			{
				this.setY(ball.getPosition().y);
			}

		}

	}
}
