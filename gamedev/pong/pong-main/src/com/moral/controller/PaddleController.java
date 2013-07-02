package com.moral.controller;

import java.util.HashMap;
import java.util.Map;

import com.moral.entity.Paddle;
import com.moral.screens.Board;

public class PaddleController
{
	private static final float SPEED = 0.1f;

	enum Keys
	{
		UP, DOWN
	}
	static Map<Keys, Boolean> keys = new HashMap<PaddleController.Keys, Boolean>();
	static
	{
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
	}

	private final Paddle paddle;

	public PaddleController(Paddle paddle)
	{
		this.paddle = paddle;
	}

	public void upPressed()
	{
		keys.get(keys.put(Keys.UP, true));
	}

	public void upReleased()
	{
		keys.get(keys.put(Keys.UP, false));
	}

	public void downPressed()
	{
		keys.get(keys.put(Keys.DOWN, true));
	}

	public void downReleased()
	{
		keys.get(keys.put(Keys.DOWN, false));
	}

	public void update(float delta)
	{
		this.processInput(delta);
	}

	private boolean processInput(float delta)
	{
		//System.out.println(keys.get(Keys.UP));
		if (keys.get(Keys.UP))
		{
			if ((this.paddle.getPosition().y + this.paddle.getBounds().height) <= Board.BOARD_HEIGHT)
				this.paddle.getPosition().y += SPEED;
		}
		if (keys.get(Keys.DOWN))
		{
			if (this.paddle.getPosition().y > 0)
				this.paddle.getPosition().y -= SPEED;
		}
		System.out.println(this.paddle.getPosition().y);
		return false;
	}
}
