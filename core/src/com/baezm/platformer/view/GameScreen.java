package com.baezm.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        map = new TmxMapLoader().load("map/level01.tmx");
//        gets the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
//        tells program the size of a tile ===> f stands for floating decimal number

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
//        gets the height and width of the window so that the map isn't warped

        camera = new OrthographicCamera(14f, 14f * (height / width));
//        OrthographicCamera(14f, 14f) says that the camera sees 14 tiles up and 14 tiles across ===> this seats the frame
//        fixes the warping of the map
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
//          camera view is like a graph, so without setting camera position, the map appears in the 1st quadrant of a 4 quadrant graph (       |  x    ) and this line fixes it so that the map is on the whole screen
//                                                                                                                                     (-------|-------)
//                                                                                                                                     (       |       )

    }

    @Override
    public void render(float delta) {
        camera.update();
        renderer.setView(camera);
//        setting camera on renderer
        renderer.render();
//        tell renderer to display itself
    }

    @Override
    public void resize(int width, int height) {

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