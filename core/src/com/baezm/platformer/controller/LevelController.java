package com.baezm.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {
    public static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;

    public static Batch spriteBatch;

    public static World gameWorld;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController() {

        map = new TmxMapLoader().load("map/level01.tmx");
//        gets the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
//        tells program the size of a tile ===> f stands for floating decimal number
        spriteBatch = renderer.getSpriteBatch();
//        access sprite batch associated with level map and storing it in the spriteBatch variable => draw player on the same scale as the map
        gameWorld = new World(new Vector2(0, -10), true);
//        Vector2 has a negative y-value so that gravity acts downwards
        debugRenderer = new Box2DDebugRenderer();

    }

    public static void draw() {
        spriteBatch.begin();
        player.draw(spriteBatch);
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
        gameWorld.step(1/60f, 1,1);
//        updates screen 60 times per second
    }

}