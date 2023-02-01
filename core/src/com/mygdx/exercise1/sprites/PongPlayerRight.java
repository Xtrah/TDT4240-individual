package com.mygdx.exercise1.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.exercise1.Exercise1;

public class PongPlayerRight {
    private Texture bird1, bird2, bird3;
    private Sprite birdSprite;
    private Vector2 pos;
    private int speed;
    private boolean xPositive;
    private boolean yPositive;
    private float elapsedTime = 0;

    private Rectangle birdObject;

    public PongPlayerRight() {
        bird1 = new Texture("leftheli1.png");
        bird2 = new Texture("leftheli2.png");
        bird3 = new Texture("leftheli3.png");
        pos = new Vector2(Exercise1.WIDTH-50-bird1.getWidth(), Exercise1.HEIGHT/2);
        birdSprite = new Sprite(bird1);
        birdSprite.flip(true,false);
        xPositive = true;
        yPositive = true;
        speed = 300;

        birdObject = new Rectangle(Exercise1.WIDTH-50-bird1.getWidth(), Exercise1.HEIGHT/2, bird1.getWidth(), bird1.getHeight());
    }

    public Rectangle getBirdObject() {
        return birdObject;
    }

    public Sprite getBirdSprite() {
        return birdSprite;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void update(float dt, PongBall ball) {
        elapsedTime += dt;
        if (elapsedTime > 0.1f) {
            elapsedTime = 0;
            if (birdSprite.getTexture() == bird1) {
                birdSprite.setTexture(bird2);
            } else if (birdSprite.getTexture() == bird2) {
                birdSprite.setTexture(bird3);
            } else {
                birdSprite.setTexture(bird1);
            }
        }

        birdObject.setPosition(pos.x, pos.y);

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pos.y += 5;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            pos.y -= 5;
        }

    }
}