package com.flappydemo.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Bird class contains information on the bird object that the player plays as.
 * The gravity pulling the bird down is implemented here.
 */

public class Bird {
    private static final int GRAVITY = -15;     //gravity constant
    private static final int MOVEMENT = 100;    //horizontal movement
    private Vector3 position;       //position of the bird
    private Vector3 velocity;       //this is for gravity, since horizontal movement is constant

    private Texture bird;
    private Rectangle bounds;
    private Animation birdAnimation;
    private Sound flap;

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        //bird = new Texture("sprites/yellowbird-midflap.png");
        bird = new Texture("sprites/yellowbird-animation.png");
        birdAnimation = new Animation(new TextureRegion(bird), 3, 0.5f);
        bounds = new Rectangle(x, y, bird.getWidth() / 3, bird.getHeight());
        flap = Gdx.audio.newSound(Gdx.files.internal("audio/wing.ogg"));
    }

    public void update(float dt){
        //check if the bird hit the bottom, only add gravity if not at bottom
        birdAnimation.update(dt);
        if (position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);   //smooths out the motion
        position.add(MOVEMENT * dt, velocity.y, 0);     //update location
        if (position.y < 0) {   //don't let the bird fall through the ground
            position.y = 0;
        }
        velocity.scl(1/dt);     //resets the motion smoothing
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    public void jump(){
        velocity.y = 250;
        flap.play(0.5f);
    }

    public Rectangle getBounds(){
        return bounds;
    }
    public void dispose(){
        bird.dispose();
        flap.dispose();
    }
}
