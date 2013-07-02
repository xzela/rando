package com.moral.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.moral.renderer.BallRenderer;
import com.moral.screens.Board;

public class Ball
{
	private float SPEED = 2f;
	private final static Vector2 RESET_POSITION = new Vector2(5f,5f);
	private final static float SIZE = .25f;
	private Vector2 direction;

	private final Rectangle bounds = new Rectangle();
	public Rectangle getBounds() { return this.bounds; }

	private Vector2 position;
	public Vector2 getPosition() { return this.position; }

	private BallRenderer renderer;

	public Ball(Vector2 position)
	{
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

		this.position.add(this.SPEED * this.direction.x * delta, this.SPEED * this.direction.y * delta);
		this.bounds.setX(this.position.x);
		this.bounds.setY(this.position.y);

		System.out.println("Paddle bounds: " + player.getBounds());
		System.out.println("Ball bounds: " + this.getBounds());


		if (this.bounds.overlaps(player.getBounds()))
		{
			float sign = Math.signum(this.position.y - player.getBounds().y);
			this.direction.x = -this.direction.x;
			this.direction.y = sign * Math.abs(this.position.y - player.getBounds().y) / 30;
			this.SPEED += 1;
		}
		// test to bounce back from wall
//		if (this.bounds.x >= (Board.BOARD_WIDTH - this.bounds.width))
//		{
//			float sign = Math.signum(this.position.y + player.getBounds().y);
//			this.direction.x = -this.direction.x;
//			this.direction.y = sign * Math.abs(this.position.y + player.getBounds().y) / 30;
////			this.SPEED += 1;
//		}

		// if ball pasts the left side of the screen.
		if (this.bounds.x <= 0)
		{
			this.reset();
		}

		if (this.bounds.x >= Board.BOARD_WIDTH - this.bounds.width)
		{
			this.reset();
		}
	}

	private void reset()
	{
		this.position = RESET_POSITION;
		this.bounds.x = this.position.x;
		this.bounds.y = this.position.y;
		this.direction = new Vector2(-1,0);
	}
}
