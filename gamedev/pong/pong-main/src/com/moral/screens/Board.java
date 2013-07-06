package com.moral.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.moral.PongGame;

public class Board
{
	// define the board width and height
	public static final float BOARD_WIDTH = 10f;
	public static final float BOARD_HEIGHT = 7f;

	// define the scores
	public int player_score = 0;
	public int ai_score = 0;

	// rendering
	private final SpriteBatch batch;
	private final BitmapFont font;

	PongGame game;

	public Board(PongGame game)
	{
		this.game = game;
		this.font = new BitmapFont();
		this.batch = new SpriteBatch();
	}

	public void render()
	{
		this.batch.begin();
		this.drawPlayerScore(this.batch);
		this.drawAIScore(this.batch);
		this.drawGoalText(this.batch);
		this.batch.end();
	}

	/**
	 * draws the goal objective to the screen
	 * @param batch
	 */
	public void drawGoalText(SpriteBatch batch)
	{
		this.font.setColor(Color.LIGHT_GRAY);
		this.font.draw(batch, "Score " + this.game.scoreGoal + " points", this.game.WINDOW_WIDTH / 2 - 50, this.game.WINDOW_HEIGHT - 10);
	}

	/**
	 * draws the player score to the screen
	 * @param batch
	 */
	public void drawPlayerScore(SpriteBatch batch)
	{
		this.font.setColor(Color.GRAY);
		this.font.draw(batch, "Player Score: " +  player_score, 6f, 310f);
	}

	/**
	 * draws the AI score to the screen
	 * @param batch
	 */
	public void drawAIScore(SpriteBatch batch)
	{
		this.font.setColor(Color.GRAY);
		this.font.draw(batch, "AI Score: " +  ai_score, 400f, 310f);
	}

	/**
	 * increases the players score
	 */
	public void increasePlayerScore()
	{
		this.player_score += 1;
	}

	/**
	 * increases the ai score
	 */
	public void increaseAIScore()
	{
		this.ai_score += 1;
	}

}
