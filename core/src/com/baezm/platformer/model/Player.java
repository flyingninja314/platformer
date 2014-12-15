package com.baezm.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Player {
    public Vector2 position;
//    position of player -> vector2 has x and y coordinate
    public Spritesheet spriteSheet;
    public String currentAnimation;

    private float stateTime;
    private HashMap<String, Animation> animations;
//    makes a table

    public Player() {
        position = new Vector2(0,4);
//        initializing player's position to start on game screen
        spriteSheet = new Spritesheet("img/aliens.png");
//        gets sprite sheet
        animations = new HashMap<String, Animation>();
        animations.put("walk", spriteSheet.createAnimation(31, 32));
        animations.put("climb", spriteSheet.createAnimation(23, 24));
        animations.put("ducking", spriteSheet.createAnimation(25, 25));
        animations.put("standing", spriteSheet.createAnimation(22, 22));
        animations.put("jumping", spriteSheet.createAnimation(27, 27));
        animations.put("hurting", spriteSheet.createAnimation(26, 26));
        animations.put("idle", spriteSheet.createAnimation(28, 28));
        animations.put("swim", spriteSheet.createAnimation(29, 30));
//        animations.put("walk", spriteSheet.createAnimation(9, 10, .13f));
//        animations.put("climb", spriteSheet.createAnimation(1, 2, .13f));

        stateTime = 0f;
//        time the player has been in game

    }

    public void draw(Batch spriteBatch, String currentAnimation) {
//        void return type -> the function doesn't return anything, it is just executed
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));
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