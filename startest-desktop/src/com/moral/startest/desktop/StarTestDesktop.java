package com.moral.startest.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.moral.startest.StarTest;

public class StarTestDesktop
{
	public static void main(String[] arg)
	{
		new LwjglApplication(new StarTest(), "Star Assault", 480, 320, true);
	}
}
