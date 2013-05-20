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
		loadDemoLevel();
	}

	public void loadDemoLevel()
	{
		width = 10;
		height = 7;

		blocks = new Block[width][height];

		for (int col = 0; col < width; col++)
		{
			for (int row = 0; row < height; row++)
			{
				blocks[col][row] = null;
			}
		}

		blocks[0][1] = new Block(new Vector2(0, 1));
		blocks[0][2] = new Block(new Vector2(0, 2));
		blocks[0][3] = new Block(new Vector2(0, 3));

		for (int col = 0; col < 10; col++)
		{
			blocks[col][0] = new Block(new Vector2(col, 0));
			blocks[col][6] = new Block(new Vector2(col, 6));

			if (col > 2)
			{
				blocks[col][1] = new Block(new Vector2(col, 1));
			}

		}
		blocks[9][2] = new Block(new Vector2(9,2));
		blocks[9][3] = new Block(new Vector2(9,3));
		blocks[9][4] = new Block(new Vector2(9,4));
		blocks[9][5] = new Block(new Vector2(9,5));

		blocks[6][3] = new Block(new Vector2(6,3));
		blocks[6][4] = new Block(new Vector2(6,4));
		blocks[6][5] = new Block(new Vector2(6,5));
	}

}
