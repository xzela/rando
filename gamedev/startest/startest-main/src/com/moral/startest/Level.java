package com.moral.startest;

import com.badlogic.gdx.math.Vector2;

public class Level
{

	private int height;
	public int getHeight() { return this.height; }
	public void setHeighth(int height) { this.height = height; }

	private int width;
	public int getWidth() { return this.width; }
	public void setWidth(int width) { this.width = width; }


	private Block[][] blocks;
	public Block[][] getBlocks() {return this.blocks; }
	public void setBlocks(Block[][] blocks) { this.blocks = blocks;}
	public Block get(int x, int y) { return this.blocks[x][y]; }

	public Level()
	{
		this.loadDemoLevel();
	}

	public void loadDemoLevel()
	{
		this.width = 15;
		this.height = 10;

		this.blocks = new Block[this.width][this.height];

		for (int col = 0; col < this.width; col++)
		{
			for (int row = 0; row < this.height; row++)
			{
				this.blocks[col][row] = null;
			}
		}

		this.blocks[0][1] = new Block(new Vector2(0, 1));
		this.blocks[0][2] = new Block(new Vector2(0, 2));
		this.blocks[0][3] = new Block(new Vector2(0, 3));

		for (int col = 0; col < 10; col++)
		{
			this.blocks[col][0] = new Block(new Vector2(col, 0));
			this.blocks[col][6] = new Block(new Vector2(col, 6));

			if (col > 2)
			{
				this.blocks[col][1] = new Block(new Vector2(col, 1));
			}

		}
		this.blocks[9][2] = new Block(new Vector2(9,2));
		this.blocks[9][3] = new Block(new Vector2(9,3));
		this.blocks[9][4] = new Block(new Vector2(9,4));
		this.blocks[9][5] = new Block(new Vector2(9,5));

		this.blocks[6][3] = new Block(new Vector2(6,3));
		this.blocks[6][4] = new Block(new Vector2(6,4));
		this.blocks[6][5] = new Block(new Vector2(6,5));
	}

}
