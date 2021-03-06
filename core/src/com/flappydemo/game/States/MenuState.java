package com.flappydemo.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flappydemo.game.FlappyDemo;
//import com.sun.prism.Texture;


/**
 * Created by Arthur on 2017-10-29.
 */

public class MenuState extends State {

    private Texture background;
    private Texture playbutton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("sprites/background-day.png");
        playbutton = new Texture("sprites/play.png");
        cam.setToOrtho(false, FlappyDemo.WIDTH, FlappyDemo.HEIGHT); //reset camera
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);   //camera
        sb.begin();
        sb.draw(background, 0, 0, FlappyDemo.WIDTH, FlappyDemo.HEIGHT );
        sb.draw(playbutton, (FlappyDemo.WIDTH / 2)- (playbutton.getWidth() / 2), (FlappyDemo.HEIGHT / 2) - (playbutton.getHeight() / 2));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbutton.dispose();
        System.out.println("disposed");
    }
}
