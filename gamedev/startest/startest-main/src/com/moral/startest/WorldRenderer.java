package com.moral.startest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.moral.renderer.BobRenderer;

public class WorldRenderer {

	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	private static final float RUNNING_FRAME_DURATION = 0.06f;

	private final World world;
	private final BobRenderer bobRenderer;

	private final OrthographicCamera cam;

	/** for debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();

	/** Textures **/
	private TextureRegion blockTexture;

	private final SpriteBatch spriteBatch;
	private boolean debug = false;
	private int width;
	private int height;
	private float ppuX;	// pixels per unit on the X axis
	private float ppuY;	// pixels per unit on the Y axis

	public void setSize (int w, int h) {
		this.width = w;
		this.height = h;
		this.ppuX = this.width / CAMERA_WIDTH;
		this.ppuY = this.height / CAMERA_HEIGHT;
	}
	public boolean isDebug() {
		return this.debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public WorldRenderer(World world, boolean debug) {
		this.world = world;
		this.bobRenderer =  new BobRenderer(this.world, debug);
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		this.debug = debug;
		this.spriteBatch = new SpriteBatch();
		this.loadTextures();
	}

	private void loadTextures()
	{
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("assets/images/textures/textures.pack"));
		this.blockTexture = atlas.findRegion("block");
	}


	public void render()
	{
		this.moveCamera(this.world.getBob().getPosition().x, this.world.getBob().getPosition().y );
		this.spriteBatch.setProjectionMatrix(this.cam.combined);
		this.spriteBatch.begin();
		this.drawBlocks();
		this.bobRenderer.drawBob(this.spriteBatch);
		this.spriteBatch.end();
		this.drawCollisionBlocks();
		if (this.debug)
		{
			this.drawDebug();
			this.bobRenderer.drawDebug();
		}

	}

	public void moveCamera(float x, float y)
	{
		this.cam.position.set(x, y, 0);
		this.cam.update();
	}

	private void drawBlocks() {
		for (Block block : this.world.getDrawableBlocks((int)CAMERA_WIDTH, (int)CAMERA_HEIGHT)) {
			this.spriteBatch.draw(this.blockTexture,
					block.getPosition().x,
					block.getPosition().y,
					Block.SIZE,
					Block.SIZE);
		}
	}

	private void drawDebug() {
		// render blocks
		this.debugRenderer.setProjectionMatrix(this.cam.combined);
		this.debugRenderer.begin(ShapeType.Rectangle);
		for (Block block : this.world.getDrawableBlocks((int)CAMERA_WIDTH, (int)CAMERA_HEIGHT)) {
			Rectangle rect = block.getBounds();
			this.debugRenderer.setColor(new Color(1, 0, 0, 1));
			this.debugRenderer.rect(rect.x, rect.y, rect.width, rect.height);
		}
	}

	private void drawCollisionBlocks() {
		this.debugRenderer.setProjectionMatrix(this.cam.combined);
		this.debugRenderer.begin(ShapeType.FilledRectangle);
		this.debugRenderer.setColor(new Color(1, 1, 1, 1));
		for (Rectangle rect : this.world.getCollisionRects()) {
			this.debugRenderer.filledRect(rect.x, rect.y, rect.width, rect.height);
		}
		this.debugRenderer.end();

	}
}