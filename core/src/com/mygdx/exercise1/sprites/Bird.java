package com.mygdx.exercise1.sprites;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.exercise1.Exercise1;

public class Bird {
    private Texture bird;
    private Sprite birdSprite;
    private Vector2 pos;
    private int speed;
    private boolean xPositive;
    private boolean yPositive;

    public Bird(int x, int y) {
        pos = new Vector2(x,y);
        bird = new Texture("attackhelicopter.png");
        birdSprite = new Sprite(bird);
        birdSprite.flip(true,false);
        xPositive = true;
        yPositive = true;
        speed = 300;
    }

    public Sprite getBirdSprite() {
        return birdSprite;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void update(float dt) {
        useMouse(dt);
    }

    // Gdx.input to move sprite using mouse
    public void useMouse (float dt) {
        if (Gdx.input.isTouched()) {
            pos.x = Gdx.input.getX() - bird.getWidth()/2;
            pos.y = -1*Gdx.input.getY() + Exercise1.HEIGHT - bird.getHeight()/2; // y-axis is inverted or something
        }

        // stop at edges
        if (pos.x > Exercise1.WIDTH-bird.getWidth()) {
            pos.x = Exercise1.WIDTH-bird.getWidth();
        }
        if (pos.x < 0) {
            pos.x = 0;
        }
        if (pos.y > Exercise1.HEIGHT-bird.getHeight()) {
            pos.y = Exercise1.HEIGHT-bird.getHeight();
        }
        if (pos.y < 0) {
            pos.y = 0;
        }
    }

    public void moveX(float speed) {
        if (xPositive) {
            pos.x += speed;
        }
        else {
            pos.x -= speed;
        }

        if (xPositive && (pos.x > Exercise1.WIDTH-bird.getWidth())) {
            pos.x -= speed;
            xPositive = false;
            birdSprite.flip(true,false);
        }

        if (!xPositive && (pos.x < 0)) {
            pos.x += speed;
            xPositive = true;
            birdSprite.flip(true, false);
        }
    }

    public void moveY(float speed) {
        if(yPositive) {
            pos.y += speed;
        }
        else {
            pos.y -= speed;
        }
        if(yPositive && (pos.y > Exercise1.HEIGHT-bird.getHeight())) {
            pos.y -= speed;
            yPositive = false;
        }
        if(!yPositive && (pos.y < 0)) {
            pos.y += speed;
            yPositive = true;
        }
    }
}
