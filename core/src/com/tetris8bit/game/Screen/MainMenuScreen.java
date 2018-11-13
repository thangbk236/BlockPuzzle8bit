package com.tetris8bit.game.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.tetris8bit.game.Assets.GameAsset;
import com.tetris8bit.game.Assets.GameConstant;
import com.tetris8bit.game.Assets.GameGrid;
import com.tetris8bit.game.Assets.GameHome;
import com.tetris8bit.game.BlockPuzzle8bit;

public class MainMenuScreen implements Screen {
    private OrthographicCamera camera;
    SpriteBatch batch;
    protected final Game game;
    private int gameId;
    protected static MainMenuScreen mainMenuScreen;
    GameGrid gameGrid;
    GameHome gameHome;

    public MainMenuScreen(Game game){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameConstant.S_WIDTH, GameConstant.S_HEIGHT);
        camera.update();
        batch = new SpriteBatch();
        this.game=game;
        gameGrid=new GameGrid(0);
        gameHome=new GameHome(game);
    }

    public static MainMenuScreen getInstance(Game game,boolean newscreen){
        if (newscreen){
            mainMenuScreen=new MainMenuScreen(game);
        }
        else {
            if(mainMenuScreen==null){
                mainMenuScreen=new MainMenuScreen(game);
            }
        }
        return mainMenuScreen;
    }
    @Override
    public void render(float delta){

        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameGrid.GameUpdate(delta,batch);
        gameHome.GameUpdate(delta,batch);
    }
    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        batch.setProjectionMatrix(camera.combined);
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
    }
}
