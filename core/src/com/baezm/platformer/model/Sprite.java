package com.baezm.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.baezm.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    public Body physicsBody;
    public Vector2 position;
    //    position of player -> vector2 has x and y coordinate
    public Spritesheet spriteSheet;
    public float width;
    public float height;
    public String currentAnimation;

    protected float stateTime;
    protected HashMap<String, Animation> animations;
    //    makes a table
    public Sprite(Vector2 position, int width, int height) {
        this.position = position;
//        initializing player's position to start on game screen
        this.width = width * (LevelController.UNIT_SCALE);
        this.height = height * (LevelController.UNIT_SCALE);
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
//        gets sprite sheet
        animations = new HashMap<String, Animation>();
        stateTime = 0f;
//        time the player has been in game
    }

    public void draw(Batch spriteBatch) {
//        void return type -> the function doesn't return anything, it is just executed
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, width);
//        animation.getKeyframe..... gets character animation and loops from player spawn
//        multiply by (1/70f) to get character set to scale
    }

    public void update(float deltaTime) {
        stateTime += deltaTime;
//        updates so that the animation works

    }
}