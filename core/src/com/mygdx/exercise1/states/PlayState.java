package com.mygdx.exercise1.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.exercise1.sprites.Bird;

public class PlayState extends State {
    private Bird bird;
    private Bird bird2;
    private Bird bird3;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(69, 69);
        bird2 = new Bird(69+69, 69+69);
        bird3 = new Bird(69+69+69, 69+69+69);
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        bird2.update(dt);
        bird3.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bird.getBirdSprite(), bird.getPos().x, bird.getPos().y);
        sb.draw(bird2.getBirdSprite(), bird2.getPos().x, bird2.getPos().y);
        sb.draw(bird3.getBirdSprite(), bird3.getPos().x, bird3.getPos().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
