package com.tetris8bit.game.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tetris8bit.game.Assets.GameButton;
import com.tetris8bit.game.Assets.GameConstant;
import com.tetris8bit.game.Assets.GameJson;
import com.tetris8bit.game.Screen.GamePlayScreenElement.GamePlayScreenTetrisPlay;

public class SettingScreen implements Screen {

    private static SettingScreen settingScreen;
    private OrthographicCamera camera;
    SpriteBatch batch;
    public float time;
    protected final Game game;
    private int gameId;
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

    public SettingScreen(Game game){
        SettingBackground = new GameButton("ButtonEdge/SettingBackground.png","ButtonEdge/SettingBackground.png","Music/move.wav",GameConstant.SettingBackGround,false);
        SettingNewGame = new GameButton("ButtonEdge/NewGame.png","ButtonEdge/NewGame.png","Music/move.wav",GameConstant.SettingNewGame,false);
        SettingSounOn = new GameButton("ButtonEdge/SoundOn.png","ButtonEdge/SoundOff.png","Music/move.wav",GameConstant.SettingSoundOn,false);
        SettingVibrate = new GameButton("ButtonEdge/VibrateOn.png","ButtonEdge/VibrateOff.png","Music/move.wav",GameConstant.SettingVibrate,false);
        SettingExit = new GameButton("ButtonEdge/Exit.png","ButtonEdge/Exit.png","Music/move.wav",GameConstant.SettingExit,false);
        SettingClose = new GameButton("ButtonEdge/Close.png","ButtonEdge/Close.png","Music/move.wav",GameConstant.SettingClose,false);
        SettingSounOn.isClick=GamePlayScreenTetrisPlay.isSound;
        SettingVibrate.isClick=GamePlayScreenTetrisPlay.isVibrate;
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
                SettingNewGame.isClick=true;
            }
        }
        else {
            if (isNewGameLatch){
                isNewGameLatch=false;
                SettingNewGame.isClick=false;
                GameJson.gameJsonData=new GamePlayScreenTetrisPlay();
                game.setScreen(GamePlayScreen.getInstance(game,true));
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
                GameJson.gameJsonData.isSound=SettingSounOn.isClick;
                GameJson.save();
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
                GameJson.gameJsonData.isVibrate=SettingVibrate.isClick;
                GameJson.save();
            }
        }
        if (SettingExit.checkOnClick()){
            if (!isExitLatch){
                isExitLatch=true;
                SettingExit.isClick=true;
            }
        }
        else {
            if (isExitLatch){
                isExitLatch=false;
                SettingExit.isClick=false;
                System.exit(0);
            }
        }
        if (SettingClose.checkOnClick()){
            if(!isCloseLatch){
                isCloseLatch=true;
                SettingClose.isClick=true;
            }
        }
        else {
            if (isCloseLatch){
                isCloseLatch=false;
                SettingClose.isClick=false;
                switch (gameId){
                    case 0: // duoc goi tu main menu screen
                        game.setScreen(MainMenuScreen.getInstance(game,false));
                        break;
                    case 1: // duoc goi tu game play screen
                        game.setScreen(GamePlayScreen.getInstance(game,false));
                        break;
                    default:
                        break;
                }
                //game.setScreen(TestGame.getInstance(game,false));
            }
        }
    }
    public static SettingScreen getInstance(Game game,boolean newscreen,int gameId){
        if (newscreen){
            settingScreen=new SettingScreen(game);
        }
        else {
            if(settingScreen==null){
                settingScreen=new SettingScreen(game);
            }
        }
        settingScreen.gameId=gameId;
        return settingScreen;
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
        SettingBackground.dipose();
        SettingNewGame.dipose();
        SettingSounOn.dipose();
        SettingVibrate.dipose();
        SettingExit.dipose();
        SettingClose.dipose();
    }
}
