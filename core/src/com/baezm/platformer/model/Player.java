package com.baezm.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.baezm.platformer.controller.LevelController;

public class Player extends Sprite {

    public Player(Vector2 position, int width, int height) {
        super(position, width, height);

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        Body playerBody = LevelController.gameWorld.createBody(bodyDefinition);
        playerBody.setUserData(this);
//        create body in game world with type and position

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f);
//        create shape

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        playerBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();
//        attach shape to body

        animations.put("walk", spriteSheet.createAnimation(31, 32, .13f));
        animations.put("climb", spriteSheet.createAnimation(23, 24, .13f));
        animations.put("ducking", spriteSheet.createAnimation(25, 25, .13f));
        animations.put("standing", spriteSheet.createAnimation(22, 22, .13f));
        animations.put("jumping", spriteSheet.createAnimation(27, 27, .13f));
        animations.put("hurting", spriteSheet.createAnimation(26, 26, .13f));
        animations.put("idle", spriteSheet.createAnimation(28, 28, .13f));
        animations.put("swim", spriteSheet.createAnimation(29, 30, .13f));
//        animations.put("walk", spriteSheet.createAnimation(9, 10, .13f));
//        animations.put("climb", spriteSheet.createAnimation(1, 2, .13f));

        animations.put("walkleft", spriteSheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("swimleft", spriteSheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("idleleft", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("standleft", spriteSheet.flipAnimation(animations.get("stand"), true, false));
        animations.put("jumpleft", spriteSheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("duckleft", spriteSheet.flipAnimation(animations.get("duck"), true, false));

        currentAnimation = "walkleft";
    }

    public void draw(Batch spriteBatch) {
//        void return type -> the function doesn't return anything, it is just executed
        super.draw(spriteBatch);
    }

    public void update(float deltaTime) {
        super.update(deltaTime);
    }

}