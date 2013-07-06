package com.moral.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.moral.screens.Board;

public class AIPaddle extends Paddle
{

	public AIPaddle(Vector2 position)
	{
		super(position);
		this.color = Color.RED;
	}

	public void update(Ball ball, float delta)
	{
		this.getBounds().y = this.getPosition().y;

		// is the ball x direction coming towards the AI paddle?
		if (ball.getDirection().x > 0)
		{
			//
			if (this.getPosition().y < ball.getPosition().y)
			{
				if ((this.getPosition().y + this.getBounds().height) < Board.BOARD_HEIGHT)
				{
					this.getPosition().y += Paddle.SPEED;
				}
			}
			if (this.getPosition().y > ball.getPosition().y)
			{
				if (this.getPosition().y > 0)
				{
					this.getPosition().y -= Paddle.SPEED;
				}
			}
		}

	}
}
