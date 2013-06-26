package com.moral.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.moral.startest.Bob;
import com.moral.startest.Bob.State;
import com.moral.startest.World;

public class BobRenderer
{
	private static final float RUNNING_FRAME_DURATION = 0.06f;
	private final SpriteBatch spriteBatch;
	private final World world;
	private boolean debug = false;

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

	public BobRenderer(World world, boolean debug)
	{
		this.world = world;
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
		this.spriteBatch.draw(this.bobFrame, bob.getPosition().x, bob.getPosition().y, Bob.SIZE, Bob.SIZE);
	}

}
