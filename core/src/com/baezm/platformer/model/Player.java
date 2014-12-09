package com.baezm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
//    position of player -> vector2 has x and y coordinate
    public Texture spriteSheet;
//    image for character's sprite

    public TextureRegion[] spriteFrames;

    public Animation animation;
    private float stateTime;
//

    public Player() {
        position = new Vector2(0,4);
//        initializing player's position to start on game screen
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
//        gets sprite sheet to make player

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100);
//        splits sprite sheet so that character it the full character

        int counter = 0;
        for(int row = 0; row < spriteSheetFrames.length; row++) {
//            cuts sprite sheet into rows
            for(int column = 0; column < spriteSheetFrames[row].length; column++) {
//                cuts row into columns
                counter++;
            }
        }

        spriteFrames = new TextureRegion[counter];

        counter = 0;
        for(TextureRegion[] row : spriteSheetFrames) { //            output each row as an arrays
            for(TextureRegion sprite: row) {
                spriteFrames[counter++] = sprite;
            }

        }

        TextureRegion[] animationFrames = new TextureRegion[2];
//        stores the animation, allows 2 frames
        animationFrames[0] = spriteFrames[12];
//        index of this animationFrames is the 1st frame for walking
        animationFrames[1] = spriteFrames[35];
//        2nd frame is 2nd walking frame
        animation = new Animation(.13f, animationFrames);
//        new animation using frames in animationFrames; each frame lasts 1 second (1f)
        stateTime = 0f;
//        time the player has been in game

    }

    public void draw(Batch spriteBatch) {
//        void return type -> the function doesn't return anything, it is just executed
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));
//        animation.getKeyframe..... gets character animation and loops from player spawn
//        multiply by (1/70f) to get character set to scale
    }

    public void update(float deltaTime) {
        stateTime += deltaTime;
//        updates so that the animation works
        position.x += deltaTime;
//        += deltaTime so that he doesn't nyoom off the screen
    }

}