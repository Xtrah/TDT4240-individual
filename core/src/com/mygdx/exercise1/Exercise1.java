package com.mygdx.exercise1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.exercise1.states.GameStateManager;
import com.mygdx.exercise1.states.MenuState;
import com.mygdx.exercise1.states.PlayState;

public class Exercise1 extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Ex1 Task 1";

	private GameStateManager gsm;
	private SpriteBatch batch;
	// Texture img;


	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		// img = new Texture(Gdx.files.internal("attackhelicopter.png"));
		Gdx.gl.glClearColor(1, 0, 1, 1);
		gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

		// batch.begin();
		// batch.draw(img, 0, 0);
		// batch.end();
	}
}
