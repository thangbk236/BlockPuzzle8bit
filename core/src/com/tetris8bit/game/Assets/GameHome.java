package com.tetris8bit.game.Assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.tetris8bit.game.Screen.GamePlayScreen;
import com.tetris8bit.game.Screen.MainMenuScreen;
import com.tetris8bit.game.Screen.SettingScreen;

public class GameHome {
    private Button LeaderBoard;
    private Button PlayGame;
    private Button SettingGame;

    private boolean isLeaderBoard;
    private boolean isPlayGame;
    private boolean isSettingGame;
    protected final Game game;
    public GameHome(Game game){
        LeaderBoard = new Button("ButtonEdge/LeaderBoard.png","ButtonEdge/LeaderBoard.png",GameConstant.BUTTON_LEADERBOARD,false);
        PlayGame = new Button("ButtonEdge/PlayGame.png","ButtonEdge/PlayGame.png",GameConstant.BUTTON_PLAYGAME,true);
        SettingGame = new Button("ButtonEdge/SettingGame.png","ButtonEdge/SettingGame.png",GameConstant.BUTTON_SETTING,true);
        this.game = game;
    }

    public void CheckButtonEvent(float delta){
        if (LeaderBoard.checkOnClick()){
            if (!isLeaderBoard){
                isLeaderBoard=true;
            }
        }
        else {
            if (isLeaderBoard){
                isLeaderBoard=false;
                //game.setScreen(SettingScreen.getInstance(game,false,0));
            }
        }
        if (PlayGame.checkOnClick()){
            if (!isPlayGame){
                isPlayGame=true;
            }
        }
        else {
            if (isPlayGame){
                isPlayGame=false;
                game.setScreen(GamePlayScreen.getInstance(game,false));
            }
        }
        if (SettingGame.checkOnClick()){
            if (!isSettingGame){
                isSettingGame=true;
            }
        }
        else {
            if (isSettingGame){
                isSettingGame=false;
                game.setScreen(SettingScreen.getInstance(game,false,0));
            }
        }
    }

    public void  GameUpdate(float deltaTime,SpriteBatch batch){
        CheckButtonEvent(deltaTime);
        LeaderBoard.render(batch);
        PlayGame.render(batch);
        SettingGame.render(batch);
        batch.begin();
        GameAsset.GoodMorningfont.draw(batch,"WELCOME",GameConstant._WELCOME_STR.x,GameConstant._WELCOME_STR.y,0, Align.center,false);
        GameAsset.GoodMorningfont.draw(batch,"TO",GameConstant._TO_STR.x,GameConstant._TO_STR.y,0, Align.center,false);
        GameAsset.GoodMorningfont.draw(batch,"BLOCK PUZZLE",GameConstant._BLOCKPZZLE_STR.x,GameConstant._BLOCKPZZLE_STR.y,0, Align.center,false);
        GameAsset.GoodMorningfont.draw(batch,"8BIT",GameConstant._8BIT_STR.x,GameConstant._8BIT_STR.y,0, Align.center,false);
        batch.end();
    }
}
