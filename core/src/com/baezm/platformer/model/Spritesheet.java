package com.baezm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {

    public Texture spriteSheet;
//    image for character's sprite

    public TextureRegion[] spriteFrames;

    public Animation animation;

    public Spritesheet(String pathToFile) {

        spriteSheet = new Texture(Gdx.files.internal(pathToFile));
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

    }

    public Animation createAnimation() {

        TextureRegion[] animationFrames = new TextureRegion[2];
//        stores the animation, allows 2 frames
        animationFrames[0] = spriteFrames[9];
//        index of this animationFrames is the 1st frame for walking
        animationFrames[1] = spriteFrames[10];
//        2nd frame is 2nd walking frame
        animation = new Animation(.13f, animationFrames);
//        new animation using frames in animationFrames; each frame lasts 1 second (1f)
        return animation;

    }

    public Animation flipAnimation(Animation originalAnimation, boolean flipX, boolean flipY) {

        int frameCount = originalAnimation.getKeyFrames().length;
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];

        for(int index = 0; index <= frameCount - 1; index++) { //subtract 1 from frameCount
            flippedFrames[index] = new TextureRegion(originalAnimation.getKeyFrames()[index]);
            flippedFrames[index].flip(flipX, flipY);
        }

        return new Animation(originalAnimation.getFrameDuration(), flippedFrames);

    }

}