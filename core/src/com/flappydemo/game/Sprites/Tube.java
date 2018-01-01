package com.flappydemo.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Tube class contains tubes that the bird will collide with.
 * Each Tube object contains 2 parts, a top tube and a bottom tube.
 * The tubes are created with an initial random location
 */

public class Tube {
    private static final int FLUCTUATION = 150; //adjust for tube position variance
    private static final int TUBE_GAP = 100;    //distance between top and bottom tube
    private static final int LOWEST_OPENING = 80;   //lowest the tube can go
    public static final int TUBE_WIDTH = 52;    //the tubes are 52 pixels wide

    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBotTube;     //position of each tube
    private Random rand;
    private Rectangle boundsTop, boundsBot;     //hitbox for collision


    public Tube(float x){
        topTube = new Texture("sprites/pipe-green-top.png");
        bottomTube = new Texture("sprites/pipe-green-bottom.png");
        rand = new Random();

        //random position
        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        //hitbox
        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x, posBotTube.y, bottomTube.getWidth(), bottomTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    /*
        gives the tubes a new height
     */
    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posBotTube.x, posBotTube.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }
}
