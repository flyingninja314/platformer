package com.baezm.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.baezm.platformer.model.Player;

public class PlayerController {

    public static Player player;

    public static void initializeController() {
        player = new Player(70, 100);
//        created player and spriteBatch variable
    }

    public static void update(float deltaTime) {
        player.update(deltaTime);
    }

    public static void draw(Batch spriteBatch) {
        player.draw(spriteBatch);
    }

}