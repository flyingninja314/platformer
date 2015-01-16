package com.baezm.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.baezm.platformer.model.Level;
import com.baezm.platformer.model.Sprite;

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;

    public static Batch spriteBatch;

    public static World gameWorld;
    public static Array<Body> worldBodies;
    private static Box2DDebugRenderer debugRenderer;


    public static void initializeController() {
        level = new Level("map/level01.tmx");
        renderer = new OrthogonalTiledMapRenderer(Level.map, UNIT_SCALE);
//        tells program the size of a tile ===> f stands for floating decimal number
        spriteBatch = renderer.getSpriteBatch();
//        access sprite batch associated with level map and storing it in the spriteBatch variable => draw player on the same scale as the map
        gameWorld = new World(new Vector2(0, 0), true);
//        Vector2 has a negative y-value so that gravity acts downwards
        debugRenderer = new Box2DDebugRenderer();

    }

    public static void draw() {
        spriteBatch.begin();
        PlayerController.draw(spriteBatch);
        spriteBatch.end();
//        controls handling of drawing on the screen -> it needs to know when to start drawing and when to stop
//        everything that needs to be drawn by spriteBatch must be between the begin and end

        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update(float deltaTime) {
        renderer.setView(CameraController.camera);
//        setting camera on renderer
        renderer.render();
//        tell renderer to display itself
        updateWorldBodies();
        gameWorld.step(1/60f, 1,1);
//        updates screen 60 times per second
    }

    private static void updateWorldBodies() {
        worldBodies.clear();
        gameWorld.getBodies(worldBodies);

        for(Body body : worldBodies){
            Sprite spriteBody = (Sprite)body.getUserData();
            spriteBody.position = body.getPosition();
        }
    }

}