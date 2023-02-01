package com.mygdx.exercise1.states;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.exercise1.Exercise1;
import com.mygdx.exercise1.sprites.PongBall;
import com.mygdx.exercise1.sprites.PongPlayerLeft;
import com.mygdx.exercise1.sprites.PongPlayerRight;

public class PongState extends State {

    private PongPlayerLeft player1;
    private PongPlayerRight player2;
    private PongBall ball;
    private BitmapFont font;
    private int leftScore;
    private int rightScore;


    public PongState(GameStateManager gsm) {
        super(gsm);
        player1 = new PongPlayerLeft();
        player2 = new PongPlayerRight();
        ball = new PongBall(Exercise1.WIDTH / 2, Exercise1.HEIGHT / 2);
        font = new BitmapFont();
    }

    public void incLeftScore() {
        this.leftScore += 1;
    }

    public void incRightScore() {
        this.rightScore += 1;
    }
    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        player1.update(dt, ball);
        player2.update(dt, ball);
        ball.update(dt, player1, player2, this);

        if (this.leftScore == 21 || this.rightScore == 21) {
            this.gsm.pop();
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(player1.getBirdSprite(), player1.getPos().x, player1.getPos().y);
        sb.draw(player2.getBirdSprite(), player2.getPos().x, player2.getPos().y);
        sb.draw(ball.getBirdSprite(), ball.getPos().x, ball.getPos().y);
        font.draw(sb, this.leftScore + "|" + this.rightScore, 25, Exercise1.HEIGHT - 25);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
