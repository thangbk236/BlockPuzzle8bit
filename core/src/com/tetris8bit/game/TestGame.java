package com.tetris8bit.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tetris8bit.game.Assets.GameButton;
import com.tetris8bit.game.Assets.GameConstant;
import com.tetris8bit.game.Screen.SettingScreen;

public class TestGame implements Screen {

    private static TestGame testGame;
    private OrthographicCamera camera;
    SpriteBatch batch;
    public float time;
    protected final Game game;
    private boolean isNewGameLatch;
    private boolean isSoundOnLatch;
    private boolean isVibrateOnLatch;
    private boolean isExitLatch;
    private boolean isCloseLatch;

    private GameButton SettingBackground;
    private GameButton SettingNewGame;
    private GameButton SettingSounOn;
    private GameButton SettingVibrate;
    private GameButton SettingExit;
    private GameButton SettingClose;

    public TestGame(Game game){

        SettingBackground = new GameButton("ButtonEdge/SettingBackground.png","ButtonEdge/SettingBackground.png","Music/move.wav",GameConstant.SettingBackGround,false);
        SettingNewGame = new GameButton("ButtonEdge/NewGame.png","ButtonEdge/NewGame.png","Music/move.wav",GameConstant.SettingNewGame,false);
        SettingSounOn = new GameButton("ButtonEdge/SoundOn.png","ButtonEdge/SoundOff.png","Music/move.wav",GameConstant.SettingSoundOn,false);
        SettingVibrate = new GameButton("ButtonEdge/VibrateOn.png","ButtonEdge/VibrateOff.png","Music/move.wav",GameConstant.SettingVibrate,false);
        SettingExit = new GameButton("ButtonEdge/Exit.png","ButtonEdge/Exit.png","Music/move.wav",GameConstant.SettingExit,false);
        SettingClose = new GameButton("ButtonEdge/Close.png","ButtonEdge/Close.png","Music/move.wav",GameConstant.SettingClose,false);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameConstant.S_WIDTH, GameConstant.S_HEIGHT);
        camera.update();
        batch = new SpriteBatch();
        this.game=game;
    }
    public void CheckButtonEvent(float delta){
        if (SettingNewGame.checkOnClick()){
            if (!isNewGameLatch){
                isNewGameLatch=true;
            }
        }
        else {
            if (isNewGameLatch){
                isNewGameLatch=false;
                game.setScreen(SettingScreen.getInstance(game,false,0));
            }
        }

        if (SettingSounOn.checkOnClick()){
            if (!isSoundOnLatch){
                isSoundOnLatch=true;

            }
        }
        else {
            if (isSoundOnLatch){
                isSoundOnLatch=false;
                if (SettingSounOn.isClick){
                    SettingSounOn.isClick=false;
                }
                else {
                    SettingSounOn.isClick=true;
                }
            }
        }
        if (SettingVibrate.checkOnClick()){
            if (!isVibrateOnLatch){
                isVibrateOnLatch=true;

            }
        }
        else {
            if (isVibrateOnLatch){
                isVibrateOnLatch=false;
                if (SettingVibrate.isClick){
                    SettingVibrate.isClick=false;
                }
                else {
                    SettingVibrate.isClick=true;
                }
            }
        }
        if (SettingExit.checkOnClick()){
            if (!isExitLatch){
                isExitLatch=true;

            }
        }
        else {
            if (isExitLatch){
                isExitLatch=false;
                System.exit(0);
            }
        }
        if (SettingClose.checkOnClick()){
            if(!isCloseLatch){
                isCloseLatch=true;

            }
        }
        else {
            if (isCloseLatch){
                isCloseLatch=false;
                game.setScreen(SettingScreen.getInstance(game,false,0));
            }
        }
    }
    public static TestGame getInstance(Game game,boolean newgame){
        if (newgame){
            testGame=new TestGame(game);
        }
        else {
            if(testGame==null){
                testGame=new TestGame(game);
            }
        }
        return testGame;
    }
    @Override
    public void render(float delta){
        CheckButtonEvent(delta);
        time+=delta;
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SettingBackground.render(batch);
        SettingNewGame.render(batch);
        SettingSounOn.render(batch);
        SettingVibrate.render(batch);
        SettingExit.render(batch);
        SettingClose.render(batch);
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
