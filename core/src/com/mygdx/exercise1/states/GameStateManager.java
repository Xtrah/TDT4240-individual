package com.mygdx.exercise1.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    private static GameStateManager instance = null;
    private Stack<State> states;

    private GameStateManager() {
        states = new Stack<State>();
    }

    public void push(State state) {
        states.push(state);
    }

    public void pop() {
        states.pop();
    }

    public void set(State state) {
        states.pop();
        states.push(state);
    }

    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }

    public static GameStateManager getInstance() {
        if (instance == null) {
            instance = new GameStateManager();
        }
        return instance;
    }
}
