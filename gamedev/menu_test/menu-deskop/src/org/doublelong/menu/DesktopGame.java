package org.doublelong.menu;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopGame
{
	public static void main(String[] args)
	{
		MenuGame game = new MenuGame();
		new LwjglApplication(game, "Menu Testing", 600, 600, false);
	}
}
