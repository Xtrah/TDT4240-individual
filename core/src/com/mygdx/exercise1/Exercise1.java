package com.mygdx.exercise1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.exercise1.states.GameStateManager;
import com.mygdx.exercise1.states.PongState;

public class Exercise1 extends ApplicationAdapter {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	public static final String TITLE = "Exercise 1 task 4 - Pong";

	private GameStateManager gsm;
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		gsm.push(new PongState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}
