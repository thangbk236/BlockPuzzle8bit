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
import com.tetris8bit.game.BlockPuzzle8bit;

public class GamePlayScreen implements Screen {
    private static GamePlayScreen gamePlayScreen;
    private OrthographicCamera camera;
    SpriteBatch batch;
    public float time;
    protected final Game game;
    private int gameId;

    public boolean onClickLatch;

    public GamePlayScreen(Game game){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameConstant.S_WIDTH, GameConstant.S_HEIGHT);
        camera.update();
        batch = new SpriteBatch();
        this.game=game;

        onClickLatch=false;
    }


    public static GamePlayScreen getInstance(Game game,boolean newscreen){
        if (newscreen){
            gamePlayScreen=new GamePlayScreen(game);
        }
        else {
            if(gamePlayScreen==null){
                gamePlayScreen=new GamePlayScreen(game);
            }
        }
        return gamePlayScreen;
    }
    @Override
    public void render(float delta){


    if (Gdx.input.isTouched()){
        if (!onClickLatch){
            onClickLatch=true;
        }
    }
    if (onClickLatch){
        onClickLatch=false;
        game.setScreen(SettingScreen.getInstance(game,false,1));
    }




        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
