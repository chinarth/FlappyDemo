package com.flappydemo.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Arthur on 2017-12-29.
 */

public class Tube {
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 80;
    public static final int TUBE_WIDTH = 52;

    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBotTube;
    private Random rand;

    public Tube(float x){
        topTube = new Texture("sprites/pipe-green-top.png");
        bottomTube = new Texture("sprites/pipe-green-bottom.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
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

    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

    }
}
