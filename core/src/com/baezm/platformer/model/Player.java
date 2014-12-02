package com.baezm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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

}