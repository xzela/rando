package com.moral.startest.controller;

import com.moral.startest.Monster;
import com.moral.startest.World;

public class MonsterController
{

	private final Monster monster;
	private final World world;

	public MonsterController(World world)
	{
		this.world = world;
		this.monster = this.world.getMonster();
	}
}
