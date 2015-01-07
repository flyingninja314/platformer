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
import com.baezm.platformer.model.Player;

public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public Batch spriteBatch;
    public Player player;

    public static World gameWorld;
    private Box2DDebugRenderer debugRenderer;

    public GameScreen() {
        map = new TmxMapLoader().load("map/level01.tmx");
//        gets the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
//        tells program the size of a tile ===> f stands for floating decimal number

        gameWorld = new World(new Vector2(0, -10), true);
//        Vector2 has a negative y-value so that gravity acts downwards
        debugRenderer = new Box2DDebugRenderer();

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
        spriteBatch = renderer.getSpriteBatch();
//        access sprite batch associated with level map and storing it in the spriteBatch variable => draw player on the same scale as the map
        player = new Player();
//        created player and spriteBatch variable
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.41f, 0.41f, 0.41f, 1f);
//        set color of clear
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        clears screen with the color you chose

        camera.update();
        renderer.setView(camera);
//        setting camera on renderer
        renderer.render();
//        tell renderer to display itself

       player.update(delta);

        spriteBatch.begin();
        player.draw(spriteBatch);
        spriteBatch.end();
//        controls handling of drawing on the screen -> it needs to know when to start drawing and when to stop
//        everything that needs to be drawn by spriteBatch must be between the begin and end

        debugRenderer.render(gameWorld, camera.combined);
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