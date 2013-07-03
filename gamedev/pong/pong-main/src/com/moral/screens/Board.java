package com.moral.screens;

public class Board
{
	public static final float BOARD_WIDTH = 10f;
	public static final float BOARD_HEIGHT = 7f;

	public int player_score = 0;
	public int ai_score = 0;

	public Board()
	{

	}

	public void increase_player_score()
	{
		this.player_score += 1;
	}

}
