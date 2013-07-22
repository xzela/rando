package org.doublelong.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class MenuScreen implements Screen
{

	private final Skin skin;
	private final Stage stage;

	private final Label label;
	String[] listEntries = {"This is a list entry", "And another one", "The meaning of life", "Is hard to come by",
			"This is a list entry", "And another one", "The meaning of life", "Is hard to come by", "This is a list entry",
			"And another one", "The meaning of life", "Is hard to come by", "This is a list entry", "And another one",
			"The meaning of life", "Is hard to come by", "This is a list entry", "And another one", "The meaning of life",
	"Is hard to come by"};

	public MenuScreen()
	{

		this.skin = new Skin(Gdx.files.internal("ui/uiskin.json"), new TextureAtlas(Gdx.files.internal("ui/uiskin.atlas")));
		this.stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
		this.label = new Label("Word: ", this.skin);

		Gdx.input.setInputProcessor(stage);
		Window window = new Window("Dialog", skin);
		window.setPosition(0, 0);
		window.defaults().spaceBottom(10);

		window.add(this.label).colspan(4);
		window.pack();

		this.stage.addActor(window);

		Table t = new Table();
		t.row();
		t.add(this.label);

		t.layout();

		this.stage.addActor(t);
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		this.stage.draw();
		Table.drawDebug(stage);
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

}
