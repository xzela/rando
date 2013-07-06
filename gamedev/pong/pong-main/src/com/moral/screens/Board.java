package com.moral.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.moral.PongGame;

public class Board
{
	public static final float BOARD_WIDTH = 10f;
	public static final float BOARD_HEIGHT = 7f;

	public int player_score = 0;
	public int ai_score = 0;

	private final SpriteBatch batch;
	private final BitmapFont font;

	PongGame game;

	public Board(PongGame game)
	{
		this.game = game;
		this.font = new BitmapFont();
		this.batch = new SpriteBatch();
	}

	public void render(SpriteBatch batch, OrthographicCamera cam)
	{
		this.batch.begin();
		this.drawPlayerScore(this.batch);
		this.drawAIScore(this.batch);
		this.batch.end();
	}

	public void update(float delta)
	{

	}

	public void drawPlayerScore(SpriteBatch batch)
	{
		this.font.setColor(Color.GRAY);
		this.font.draw(batch, "Player Score: " +  player_score, 6f, 310f);
	}

	public void drawAIScore(SpriteBatch batch)
	{
		this.font.setColor(Color.GRAY);
		this.font.draw(batch, "AI Score: " +  ai_score, 400f, 310f);
	}

	public void increasePlayerScore()
	{
		this.player_score += 1;
	}

	public void increaseAIScore()
	{
		this.ai_score += 1;
	}

}
