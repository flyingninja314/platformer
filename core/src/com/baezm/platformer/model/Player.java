package com.baezm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
//    position of player -> vector2 has x and y coordinate
    public Texture spriteSheet;
//    image for character's sprite

    public Player() {
        position = new Vector2(0,0);
//        initializing player's position to origin on game screen
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
//        gets sprite sheet to make player
    }

    public void draw(Batch spriteBatch) {
//        void return type -> the function doesn't return anything, it is just executed
        spriteBatch.draw(spriteSheet, 0, 0, 70, 100);
    }

    public void update(float deltaTime) {

    }

}