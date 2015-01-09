package com.baezm.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.baezm.platformer.controller.CameraController;
import com.baezm.platformer.controller.LevelController;
import com.baezm.platformer.model.Player;

public class GameScreen implements Screen {


    public Player player;


    public GameScreen() {
        LevelController.initializeController();
        CameraController.initializeController();

        player = new Player(70, 100);
//        created player and spriteBatch variable
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.41f, 0.41f, 0.41f, 1f);
//        set color of clear
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        clears screen with the color you chose

        LevelController.update(delta);

        player.update(delta);
        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
//        gets the correct viewport height and sets it to re-sized window size
        camera.update();
//        anytime you modify the camera, you have to update it
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}