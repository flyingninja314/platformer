package com.baezm.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
//    position of player -> vector2 has x and y coordinate

    public Animation animation;
    public Spritesheet spriteSheet;

    private float stateTime;
//

    public Player() {
        position = new Vector2(0,4);
//        initializing player's position to start on game screen
        spriteSheet = new Spritesheet("img/aliens.png");
//        gets sprite sheet
        animation = spriteSheet.createAnimation();

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