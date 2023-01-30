package com.mygdx.exercise1.states;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.exercise1.Exercise1;
import com.mygdx.exercise1.sprites.Bird;

public class PlayState extends State {
    private Bird bird;
    private BitmapFont font;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(69, 69);
        font = new BitmapFont();
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
        font.draw(sb, bird.getPos().x + " - " + bird.getPos().y, 25, Exercise1.HEIGHT - 25);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
