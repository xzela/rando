package com.moral.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.moral.renderer.BallRenderer;
import com.moral.screens.Board;

public class Ball
{
	private final static float SPEED = 2f;
	private final static float MAX_SPEED = 10f;
	private final static float RESET_X = 5f;
	private final static float RESET_Y = 5f;

	private final static float SIZE = .25f;
	private Vector2 direction;

	public float ballSpeed;
	public float getBallSpeed() { return this.ballSpeed; }

	private final Rectangle bounds = new Rectangle();
	public Rectangle getBounds() { return this.bounds; }

	private Vector2 position;
	public Vector2 getPosition() { return this.position; }

	private BallRenderer renderer;

	public Ball(Vector2 position)
	{
		this.ballSpeed = SPEED;
		this.position = position;
		this.bounds.setX(this.position.x);
		this.bounds.setY(this.position.y);
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
		this.direction = new Vector2(-1, 0);
		this.renderer = new BallRenderer(this);
	}

	public void render(SpriteBatch batch, OrthographicCamera cam)
	{
		this.renderer.render(batch, cam);
	}

	public void update(Paddle player, float delta)
	{

		this.position.add(this.ballSpeed * this.direction.x * delta, this.ballSpeed * this.direction.y * delta);
		this.bounds.setX(this.position.x);
		this.bounds.setY(this.position.y);

		//System.out.println("Paddle bounds: " + player.getPosition());
		//System.out.println("Ball bounds: " + this.getBounds());


		if (this.bounds.overlaps(player.getBounds()))
		{
			this.direction.x = -this.direction.x;

			float sign = Math.signum(this.position.y + player.getPosition().y);
			this.direction.y = sign * Math.abs(this.position.y + player.getPosition().y) / 30;

			if (this.ballSpeed < MAX_SPEED)
			{
				this.ballSpeed += 2;
			}
			if (this.ballSpeed > MAX_SPEED)
			{
				this.ballSpeed = MAX_SPEED;
			}
		}
		//System.out.println(this.direction.y);
		// test to bounce back from wall
		if (this.bounds.x >= (Board.BOARD_WIDTH - this.bounds.width))
		{
			float sign = Math.signum(this.position.y);
			this.direction.x = -this.direction.x;
			this.direction.y = -this.direction.y;
			this.direction.y = -sign * Math.abs(this.position.y) / 30;
		}

		// if ball pasts the left side of the screen.
		if (this.bounds.x < 0)
		{
			System.out.println("Ball bounds: " + this.getBounds());
			this.reset();
		}

		//System.out.println("Height: " + Board.BOARD_HEIGHT  this.bounds.height);
		// if ball hits the top of the board
		if (this.position.y > (Board.BOARD_HEIGHT - this.bounds.height))
		{
			this.direction.y = -this.direction.y;
		}
//
//		// if ball hits the bottom of the board
//		if (this.position.y > Board.BOARD_HEIGHT - this.bounds.height)
//		{
//			this.direction.y = -this.direction.y;
//		}
	}

	private void reset()
	{
		this.position = new Vector2(RESET_X, RESET_Y);
		this.ballSpeed = SPEED;
		this.bounds.setX(this.position.x);
		this.bounds.setY(this.position.y);
		this.direction = new Vector2(-1,0);
	}
}
