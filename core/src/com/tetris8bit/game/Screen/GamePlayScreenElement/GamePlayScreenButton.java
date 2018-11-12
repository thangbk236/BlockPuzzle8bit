package com.tetris8bit.game.Screen.GamePlayScreenElement;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tetris8bit.game.Assets.GameButton;
import com.tetris8bit.game.Assets.GameConstant;
import com.tetris8bit.game.Screen.SettingScreen;

public class GamePlayScreenButton {
    protected final Game game;
    private GameButton GamePlayUpButton;
    private GameButton GamePlayDownButton;
    private GameButton GamePlayLeftButton;
    private GameButton GamePlayRightButton;
    private GameButton GamePlayFireButton;
    private GameButton GamePlayRunButton;
    private GameButton GamePlayStopButton;
    private GameButton GamePlaySettingButton;

    public static boolean isUpButton;
    public static boolean isDownButton;
    public static boolean isLeftButton;
    public static boolean isRightButton;
    public static boolean isFireButton;
    public static boolean isRunButton;
    public static boolean isStopButton;
    public boolean isPlaySettingButton;

    public GamePlayScreenButton(Game game){
        GamePlayUpButton = new GameButton("Button/GamePlayUpButton.png","Button/GamePlayUpButton.png",GameConstant.BUTTON_UP,true);
        GamePlayDownButton = new GameButton("Button/GamePlayDownButton.png","Button/GamePlayDownButton.png",GameConstant.BUTTON_DOWN,true);
        GamePlayLeftButton = new GameButton("Button/GamePlayLeftButton.png","Button/GamePlayLeftButton.png",GameConstant.BUTTON_LEFT,true);
        GamePlayRightButton = new GameButton("Button/GamePlayRightButton.png","Button/GamePlayRightButton.png",GameConstant.BUTTON_RIGHT,true);
        GamePlayFireButton = new GameButton("Button/GamePlayFireButton.png","Button/GamePlayFireButton.png",GameConstant.BUTTON_FIRE,true);
        GamePlayRunButton = new GameButton("Button/GamePlayRunButton.png","Button/GamePlayRunButton.png",GameConstant.BUTTON_RUN,true);
        GamePlayStopButton = new GameButton("Button/GamePlayStopButton.png","Button/GamePlayStopButton.png",GameConstant.BUTTON_STOP,true);
        GamePlaySettingButton = new GameButton("ButtonEdge/SettingGame.png","ButtonEdge/SettingGame.png",GameConstant.BUTTON_SETTING,true);
        this.game=game;

    }
    public void CheckButtonEvent(float delta){
        if (GamePlayUpButton.checkOnClick()){
            if (!isUpButton){
                isUpButton=true;
            }
        }
        else {
            if (isUpButton){
                isUpButton=false;
            }
        }

        if (GamePlayDownButton.checkOnClick()){
            if (!isDownButton){
                isDownButton=true;
            }
        }
        else {
            if (isDownButton){
                isDownButton=false;
            }
        }

        if (GamePlayLeftButton.checkOnClick()){
            if (!isLeftButton){
                isLeftButton=true;
            }
        }
        else {
            if (isLeftButton){
                isLeftButton=false;
            }
        }

        if (GamePlayRightButton.checkOnClick()){
            if (!isRightButton){
                isRightButton=true;
            }
        }
        else {
            if (isRightButton){
                isRightButton=false;
            }
        }

        if (GamePlayFireButton.checkOnClick()){
            if (!isFireButton){
                isFireButton=true;
            }
        }
        else {
            if (isFireButton){
                isFireButton=false;
            }
        }

        if (GamePlayRunButton.checkOnClick()){
            if (!isRunButton){
                isRunButton=true;
            }
        }
        else {
            if (isRunButton){
                isRunButton=false;
            }
        }

        if (GamePlayStopButton.checkOnClick()){
            if (!isStopButton){
                isStopButton=true;
            }
        }
        else {
            if (isStopButton){
                isStopButton=false;

                if (GamePlayScreenTetris.gameState==3){
                    GamePlayScreenTetris.gameState=1;

                }
                else if (GamePlayScreenTetris.gameState==1){
                    GamePlayScreenTetris.gameState=3;
                }

            }
        }

        if (GamePlaySettingButton.checkOnClick()){
            if (!isPlaySettingButton){
                isPlaySettingButton=true;
            }
        }
        else {
            if (isPlaySettingButton){
                isPlaySettingButton=false;
                game.setScreen(SettingScreen.getInstance(game,false,1));
            }
        }
    }

    public void render(float deltaTime,SpriteBatch batch){
        CheckButtonEvent(deltaTime);
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        GamePlayUpButton.render(batch);
        GamePlayDownButton.render(batch);
        GamePlayLeftButton.render(batch);
        GamePlayRightButton.render(batch);
        GamePlayFireButton.render(batch);
        GamePlayRunButton.render(batch);
        GamePlayStopButton.render(batch);
        GamePlaySettingButton.render(batch);
    }
}
