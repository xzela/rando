package com.moral.startest.controller;

import java.util.HashMap;
import java.util.Map;

import com.moral.startest.Bob;
import com.moral.startest.World;
import com.moral.startest.Bob.State;

public class WorldController
{
	enum Keys
	{
		LEFT,
		RIGHT,
		JUMP,
		FIRE
	}

	private final World world;
	private final Bob bob;

	static Map<Keys, Boolean> keys = new HashMap<WorldController.Keys, Boolean>();
	static
	{
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.JUMP, false);
		keys.put(Keys.FIRE, false);
	}

	public WorldController(World world)
	{
		this.world = world;
		this.bob = world.getBob();
	}

	public void leftPressed()
	{
		keys.get(keys.put(Keys.LEFT, true));
	}

	public void rightPressed()
	{
		keys.get(keys.put(Keys.RIGHT, true));
	}

	public void firePressed()
	{
		keys.get(keys.put(Keys.FIRE, true));
	}

	public void jumpPressed()
	{
		keys.get(keys.put(Keys.JUMP, true));
	}

	public void leftReleased()
	{
		keys.get(keys.put(Keys.LEFT, false));
	}

	public void rightReleased()
	{
		keys.get(keys.put(Keys.RIGHT, false));
	}

	public void fireReleased()
	{
		keys.get(keys.put(Keys.FIRE, false));
	}

	public void jumpReleased()
	{
		keys.get(keys.put(Keys.JUMP, false));
	}

	public void update(float delta)
	{
		processInput();
		bob.update(delta);
	}

	private void processInput()
	{
		// System.out.println(bob.getVelocity().x);
		if (keys.get(Keys.LEFT))
		{
			// left key is pressed
			bob.setFacingLeft(true);
			bob.setState(State.WALKING);
			bob.getVelocity().x = -Bob.SPEED;
		}

		if (keys.get(Keys.RIGHT))
		{

			// right key is pressed
			bob.setFacingLeft(false);
			bob.setState(State.WALKING);
			bob.getVelocity().x = Bob.SPEED;
			// System.out.println(bob.getVelocity().x);
		}

		// check to test if neither left or right are pressed
		if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT))
				|| (!keys.get(Keys.LEFT) && (!keys.get(Keys.RIGHT))))
		{
			bob.setState(State.IDLE);
			bob.getAcceleration().x = 0;
			bob.getVelocity().x = 0;
		}
	}
}
