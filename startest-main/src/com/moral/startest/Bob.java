package com.moral.startest;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bob
{
	public enum State
	{
		DYING, IDLE, JUMPING, WALKING
	}

	float stateTime = 0;

	static final float JUMP_VELOCITY = 1f;
	static final float SIZE = 0.5f;
	public static final float SPEED = 2f;

	Vector2 acceleration = new Vector2();
	public Vector2 getAcceleration() { return this.acceleration;}

	Rectangle bounds = new Rectangle();
	public Rectangle getBounds() { return this.bounds;}

	boolean facingLeft = true;

	Vector2 position = new Vector2();
	public Vector2 getPosition() { return this.position; }
	public void setPosition(Vector2 position) { this.position = position;}

	State state = State.IDLE;
	Vector2 velocity = new Vector2();

	public Bob(Vector2 position)
	{
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}

	public void setFacingLeft(boolean b)
	{
		this.facingLeft = b;
	}

	public boolean isFacingLeft()
	{
		return this.facingLeft;
	}

	public State getState()
	{
		return this.state;
	}

	public void update(float delta)
	{
		// position.add(velocity.tmp().mul(delta));
		stateTime += delta;

	}

	public void setState(State state)
	{
		this.state = state;
	}

	public Vector2 getVelocity()
	{
		return this.velocity;
	}

	public float getStateTime()
	{
		return this.stateTime;
	}
}
