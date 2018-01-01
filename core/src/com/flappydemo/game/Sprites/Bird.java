package com.flappydemo.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
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

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bird = new Texture("sprites/yellowbird-midflap.png");
        bounds = new Rectangle(x, y, bird.getWidth(), bird.getHeight());
    }

    public void update(float dt){
        //check if the bird hit the bottom, only add gravity if not at bottom
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

    public Texture getTexture() {
        return bird;
    }

    public void jump(){
        velocity.y = 300;
    }

    public Rectangle getBounds(){
        return bounds;
    }
}
