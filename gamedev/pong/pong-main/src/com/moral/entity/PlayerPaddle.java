package com.moral.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.moral.controller.PaddleController;

public class PlayerPaddle extends Paddle
{
	public final PaddleController controller;

	public PlayerPaddle(Vector2 position)
	{
		super(position);
		this.color = Color.GREEN;
		this.controller = new PaddleController(this);
	}

	public void update(float delta)
	{
		this.controller.update(delta);
	}

}
