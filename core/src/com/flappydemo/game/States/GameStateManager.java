package com.flappydemo.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Arthur on 2017-10-29.
 */

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){              //constructor
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(State state){
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(float dt){   //takes in delta time
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
