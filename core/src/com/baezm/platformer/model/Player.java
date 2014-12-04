package com.baezm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
//    position of player -> vector2 has x and y coordinate
    public Texture spriteSheet;
//    image for character's sprite

    public TextureRegion[] spriteFrames;

    public Player() {
        position = new Vector2(0,0);
//        initializing player's position to origin on game screen
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
//        gets sprite sheet to make player

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100);
//        splits sprite sheet so that character it the full character

        int counter = 0;
        for(int row = 0; row < spriteSheetFrames.length; row++) {
//            cuts spritesheet into rows
            for(int column = 0; column < spriteSheetFrames[row].length; column++) {
//                makes row into columns
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

    public void draw(Batch spriteBatch) {
//        void return type -> the function doesn't return anything, it is just executed
        spriteBatch.draw(spriteFrames[0], 0, 0, 70, 100);
    }

    public void update(float deltaTime) {

    }

}