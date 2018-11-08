package com.tetris8bit.game.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tetris8bit.game.BlockPuzzle8bit;
import com.tetris8bit.game.TestGame;

public class SettingScreen implements Screen {
    SpriteBatch batch;
    Texture img;
    public float time;
    protected final Game game;
    public SettingScreen(Game game){
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        this.game=game;
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 150, 150);
        batch.end();

        if(Gdx.input.isTouched()){
            //time+=
            game.setScreen(TestGame.getInstance(game,false));
        }
    }
    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }
    @Override
    public void show(){

    }
    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        batch.dispose();
        img.dispose();
    }
}
