package com.mygdx.exercise1.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.exercise1.sprites.Bird;

public class PlayState extends State {
    private Bird bird;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(69, 69);
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bird.getBirdSprite(), bird.getPos().x, bird.getPos().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
