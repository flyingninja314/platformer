package com.baezm.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.baezm.platformer.model.Player;

public class PlayerController {

    public static Player player;

    public static void initializeController() {
        player = new Player(new Vector2(0,4),70, 100);
//        created player and spriteBatch variable
    }

    public static void update(float deltaTime) {
        player.update(deltaTime);
    }

    public static void draw(Batch spriteBatch) {
        player.draw(spriteBatch);
    }

}