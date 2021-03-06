package com.moral.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.moral.PongGame;
import com.moral.renderer.BallRenderer;
import com.moral.screens.Board;

public class Ball
{
	private final static float SPEED = 2f;
	private final static float MAX_SPEED = 5f;
	private final static float SIZE = .2f;

	private float time = 0.0f;
	private final Board board;

	private Vector2 direction;
	public Vector2 getDirection() { return this.direction; }

	public float ballSpeed;
	public float getBallSpeed() { return this.ballSpeed; }

	private final Rectangle bounds = new Rectangle();
	public Rectangle getBounds() { return this.bounds; }

	private Vector2 position;
	public Vector2 getPosition() { return this.position; }

	private final BallRenderer renderer;

	public Ball(PongGame game, Vector2 position)
	{
		this.board = game.board;
		this.ballSpeed = SPEED;
		this.position = position;
		this.bounds.setX(this.position.x);
		this.bounds.setY(this.position.y);
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
		this.direction = new Vector2(this.startingDirection(), 0);
		this.renderer = new BallRenderer(this);
	}

	public void render(SpriteBatch batch, OrthographicCamera cam)
	{
		this.renderer.render(batch, cam);
	}

	public void update(Paddle player, Paddle ai, float delta)
	{
		// test to see if the player paddle hits
		this.collides(player, delta);

		//test to see if ai paddle hits
		this.collides(ai, delta);

		this.position.add(this.ballSpeed * this.direction.x * delta, this.ballSpeed * this.direction.y * delta);
		this.bounds.setX(this.position.x);
		this.bounds.setY(this.position.y);

		// if ball extends off the left side of the screen.
		// AI scores a point
		if (this.bounds.x < 0)
		{
			this.board.increaseAIScore();
			this.reset();
		}

		// if ball extends off the right side of the screen
		// Player scores a point
		if (this.bounds.x >= Board.BOARD_WIDTH)
		{
			this.board.increasePlayerScore();
			this.reset();
		}

		// ball goes off screen
		if (this.position.y <= -this.bounds.height || this.position.y >= (Board.BOARD_HEIGHT +  this.bounds.height))
		{
			this.reset();
		}

		// if ball hits the top of the board
		if (this.position.y >= (Board.BOARD_HEIGHT - this.bounds.height))
		{
			this.direction.y = -this.direction.y;
		}

		// if ball hits the bottom of the board
		if (this.position.y <= 0)
		{
			this.direction.y = -this.direction.y;
		}
	}

	/**
	 * reset all of the ball values
	 */
	private void reset()
	{
		this.position = new Vector2(Board.BOARD_WIDTH / 2, Board.BOARD_HEIGHT / 2);
		this.ballSpeed = SPEED;
		this.time = 0f;
		this.bounds.setX(this.position.x);
		this.bounds.setY(this.position.y);
		this.direction = new Vector2(this.startingDirection(),0);
	}

	private int startingDirection()
	{
		if (Math.random() >= .5)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

	private void collides(Paddle paddle, float delta)
	{
		this.time += 0.001f;
		if (this.bounds.overlaps(paddle.getBounds()) || paddle.getBounds().overlaps(this.bounds))
		{
			// reverse the x direction
			this.direction.x = -this.direction.x;
			// get the mid point of the paddle
			float mid = paddle.getBounds().y + (paddle.getBounds().height / 2);
			// find the point in which the ball strikes the paddle (relative to the paddle)
			float point = this.getPosition().y - mid;
			// update the y
			this.direction.y = Board.BOARD_HEIGHT / (20 / 3) * point + this.time;

			// increase the balls speed
			this.ballSpeed += 2f;
			if (this.ballSpeed > MAX_SPEED)
			{
				this.ballSpeed = MAX_SPEED;
			}
		}
	}
}
