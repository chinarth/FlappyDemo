package com.flappydemo.game.Sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Arthur on 2017-12-31.
 */

public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    /*
        region is the sprite sheet, frame count is # of sprites in the sheet, cycleTime is max time
     */
    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;  //width of each sprite
        //split the sprite sheet into the array
        for (int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;  //max time PER frame
        frame = 0;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime){
            frame++;    //move to next frame
            currentFrameTime = 0;
        }
        if (frame >= frameCount){   //out of frames, loop back
            frame = 0;
        }
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}
