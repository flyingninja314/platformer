package com.baezm.platformer;

import com.badlogic.gdx.Game;
import com.baezm.platformer.view.GameScreen;

public class Platformer extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}