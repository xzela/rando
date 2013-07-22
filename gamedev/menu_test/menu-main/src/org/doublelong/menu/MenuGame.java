package org.doublelong.menu;

import com.badlogic.gdx.Game;

public class MenuGame extends Game
{

	private MenuScreen menu;

	@Override
	public void create()
	{
		this.menu = new MenuScreen();
		setScreen(this.menu);
	}

}
