package com.flappydemo.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Arthur on 2017-10-29.
 */

public class GameStateManager {

    private Stack<state> states;

    public GameStateManager(){              //constructor
        states = new Stack<state>();
    }

    public void push(state state){
        states.push(state);
    }

    public void pop(state state){
        states.pop();
    }

    public void set(state state){
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
