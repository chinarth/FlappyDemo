package com.flappydemo.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Arthur on 2017-10-29.
 */

public abstract class state {

    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gam;

    protected state(GameStateManager gam){
        this.gam = gam;
        cam = new OrthographicCamera();
        mouse = new Vector3();

    }
    protected abstract void handleInput();
    public abstract void update(float dt);          //dt is delta time
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
