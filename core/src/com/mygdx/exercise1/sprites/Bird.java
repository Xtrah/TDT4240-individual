package com.mygdx.exercise1.sprites;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.exercise1.Exercise1;

public class Bird {
    private Texture bird1, bird2, bird3;
    private Sprite birdSprite;
    private Vector2 pos;
    private int speed;
    private boolean xPositive;
    private boolean yPositive;
    private float elapsedTime = 0;

    private Rectangle birdObject;

    public Bird(int x, int y) {
        pos = new Vector2(x,y);
        bird1 = new Texture("heli1.png");
        bird2 = new Texture("heli2.png");
        bird3 = new Texture("heli3.png");
        birdSprite = new Sprite(bird1);
        birdSprite.flip(true,false);
        xPositive = true;
        yPositive = true;
        speed = 300;

        birdObject = new Rectangle(x, y, bird1.getWidth(), bird1.getHeight());
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

    public void update(float dt, Bird anotherBird, Bird anotherBird2) {
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

        if (birdObject.overlaps(anotherBird.getBirdObject()) || birdObject.overlaps(anotherBird2.getBirdObject())) {
            this.xPositive = !this.xPositive;
            this.yPositive = !this.yPositive;
        }

        this.moveY(speed*dt);
        this.moveX(speed*dt);
        birdObject.setPosition(pos.x, pos.y);
    }

    public void moveX(float speed) {
        if (xPositive) {
            pos.x += speed;
        }
        else {
            pos.x -= speed;
        }

        if (xPositive && (pos.x > Exercise1.WIDTH-bird1.getWidth())) {
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
        if(yPositive && (pos.y > Exercise1.HEIGHT-bird1.getHeight())) {
            pos.y -= speed;
            yPositive = false;
        }
        if(!yPositive && (pos.y < 0)) {
            pos.y += speed;
            yPositive = true;
        }
    }
}