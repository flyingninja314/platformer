package com.baezm.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();
//        gets the height and width of the window so that the map isn't warped

    public static void initializeController() {
        camera = new OrthographicCamera(14f, 14f * (height / width));
//        OrthographicCamera(14f, 14f) says that the camera sees 14 tiles up and 14 tiles across ===> this seats the frame
//        fixes the warping of the map
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
//          camera view is like a graph, so without setting camera position, the map appears in the 1st quadrant of a 4 quadrant graph (       |  x    ) and this line fixes it so that the map is on the whole screen
//                                                                                                                                     (-------|-------)
//                                                                                                                                     (       |       )

    }

    public static void update() {
        camera.update();
    }

}