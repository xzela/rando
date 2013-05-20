package com.moral.startest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.moral.startest.Bob.State;

public class WorldRenderer {

	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	private static final float RUNNING_FRAME_DURATION = 0.06f;

	private final World world;
	private final OrthographicCamera cam;

	/** for debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();

	/** Textures **/
	private TextureRegion bobIdleLeft;
	private TextureRegion bobIdleRight;
	private TextureRegion blockTexture;
	private TextureRegion bobFrame;
	private TextureRegion bobJumpLeft;
	private TextureRegion bobFallLeft;
	private TextureRegion bobJumpRight;
	private TextureRegion bobFallRight;

	/** Animations **/
	private Animation walkLeftAnimation;
	private Animation walkRightAnimation;

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
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
//		cam.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		this.debug = debug;
		this.spriteBatch = new SpriteBatch();
		this.loadTextures();
	}

	private void loadTextures() {
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("assets/images/textures/textures.pack"));
		this.bobIdleLeft = atlas.findRegion("bob-01");
		this.bobIdleRight = new TextureRegion(this.bobIdleLeft);
		this.bobIdleRight.flip(true, false);
		this.blockTexture = atlas.findRegion("block");
		TextureRegion[] walkLeftFrames = new TextureRegion[5];
		for (int i = 0; i < 5; i++) {
			walkLeftFrames[i] = atlas.findRegion("bob-0" + (i + 2));
		}
		this.walkLeftAnimation = new Animation(RUNNING_FRAME_DURATION, walkLeftFrames);

		TextureRegion[] walkRightFrames = new TextureRegion[5];

		for (int i = 0; i < 5; i++) {
			walkRightFrames[i] = new TextureRegion(walkLeftFrames[i]);
			walkRightFrames[i].flip(true, false);
		}
		this.walkRightAnimation = new Animation(RUNNING_FRAME_DURATION, walkRightFrames);
		this.bobJumpLeft = atlas.findRegion("bob-up");
		this.bobJumpRight = new TextureRegion(this.bobJumpLeft);
		this.bobJumpRight.flip(true, false);
		this.bobFallLeft = atlas.findRegion("bob-down");
		this.bobFallRight = new TextureRegion(this.bobFallLeft);
		this.bobFallRight.flip(true, false);
	}


	public void render() {
		this.moveCamera(this.world.getBob().getPosition().x, this.world.getBob().getPosition().y );
		this.spriteBatch.setProjectionMatrix(this.cam.combined);
		this.spriteBatch.begin();
		this.drawBlocks();
		this.drawBob();
		this.spriteBatch.end();
		this.drawCollisionBlocks();
		if (true)
			this.drawDebug();
	}

	public void moveCamera(float x, float y)
	{
//		if(this.world.getBob().getPosition().x > CAMERA_HEIGHT / 2f)
//		{
			this.cam.position.set(x, y, 0);
			this.cam.update();
//		}
	}

	private void drawBlocks() {
		for (Block block : this.world.getDrawableBlocks((int)CAMERA_WIDTH, (int)CAMERA_HEIGHT)) {
			this.spriteBatch.draw(this.blockTexture, block.getPosition().x * this.ppuX, block.getPosition().y * this.ppuY, Block.SIZE * this.ppuX, Block.SIZE * this.ppuY);
		}
	}

	private void drawBob() {
		Bob bob = this.world.getBob();
		this.bobFrame = bob.isFacingLeft() ? this.bobIdleLeft : this.bobIdleRight;
		if(bob.getState().equals(State.WALKING)) {
			this.bobFrame = bob.isFacingLeft() ? this.walkLeftAnimation.getKeyFrame(bob.getStateTime(), true) : this.walkRightAnimation.getKeyFrame(bob.getStateTime(), true);
		} else if (bob.getState().equals(State.JUMPING)) {
			if (bob.getVelocity().y > 0) {
				this.bobFrame = bob.isFacingLeft() ? this.bobJumpLeft : this.bobJumpRight;
			} else {
				this.bobFrame = bob.isFacingLeft() ? this.bobFallLeft : this.bobFallRight;
			}
		}
		this.spriteBatch.draw(this.bobFrame, bob.getPosition().x * this.ppuX, bob.getPosition().y * this.ppuY, Bob.SIZE * this.ppuX, Bob.SIZE * this.ppuY);
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
		// render Bob
		Bob bob = this.world.getBob();
		Rectangle rect = bob.getBounds();
		this.debugRenderer.setColor(new Color(0, 1, 0, 1));
		this.debugRenderer.rect(rect.x, rect.y, rect.width, rect.height);
		this.debugRenderer.end();
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