package com.moral.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.moral.startest.Bob;
import com.moral.startest.Bob.State;
import com.moral.startest.World;

public class BobRenderer
{
	private static final float RUNNING_FRAME_DURATION = 0.06f;
	private final World world;
	private boolean debug = false;

	/** Textures **/
	private TextureRegion bobIdleLeft;
	private TextureRegion bobIdleRight;
	private TextureRegion bobFrame;
	private TextureRegion bobJumpLeft;
	private TextureRegion bobFallLeft;
	private TextureRegion bobJumpRight;
	private TextureRegion bobFallRight;

	/** Animations **/
	private Animation walkLeftAnimation;
	private Animation walkRightAnimation;

	/** for debug rendering **/
	ShapeRenderer debugRenderer = new ShapeRenderer();


	public BobRenderer(World world, boolean debug)
	{
		this.world = world;
		this.debug = debug;
		this.loadTextures();
	}

	private void loadTextures() {
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("assets/images/textures/textures.pack"));
		this.bobIdleLeft = atlas.findRegion("bob-01");
		this.bobIdleRight = new TextureRegion(this.bobIdleLeft);
		this.bobIdleRight.flip(true, false);
		TextureRegion[] walkLeftFrames = new TextureRegion[5];
		for (int i = 0; i < 5; i++)
		{
			walkLeftFrames[i] = atlas.findRegion("bob-0" + (i + 2));
		}
		this.walkLeftAnimation = new Animation(RUNNING_FRAME_DURATION, walkLeftFrames);

		TextureRegion[] walkRightFrames = new TextureRegion[5];

		for (int i = 0; i < 5; i++)
		{
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

	public void drawBob(SpriteBatch spriteBatch)
	{
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
		spriteBatch.draw(this.bobFrame, bob.getPosition().x, bob.getPosition().y, Bob.SIZE, Bob.SIZE);
	}

	public void drawDebug()
	{
		// render Bob
		Bob bob = this.world.getBob();
		Rectangle rect = bob.getBounds();
		this.debugRenderer.setColor(new Color(0, 1, 0, 1));
		this.debugRenderer.rect(rect.x, rect.y, rect.width, rect.height);
		this.debugRenderer.end();
	}

}
