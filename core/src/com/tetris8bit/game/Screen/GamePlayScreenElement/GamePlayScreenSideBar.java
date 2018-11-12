package com.tetris8bit.game.Screen.GamePlayScreenElement;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.tetris8bit.game.Assets.GameAsset;
import com.tetris8bit.game.Assets.GameConstant;

public class GamePlayScreenSideBar {
    public static int MAX_SCORE;
    public static int HI_SCORE;
    public static int SCORE;
    public static int DISPLAY_SCORE;
    public static int LEVEL;

    public GamePlayScreenSideBar(){
        MAX_SCORE=9999999;// gia tri toi da de hien thi


    }
    public void render(float deltaTime,SpriteBatch batch){
        if (SCORE>MAX_SCORE){
            SCORE=MAX_SCORE;//toi da
        }
        DISPLAY_SCORE=SCORE*100;    // tinh diem cao nhat
        if(DISPLAY_SCORE>HI_SCORE){
            HI_SCORE=DISPLAY_SCORE;
        }

        batch.begin();
        GameAsset.font.draw(batch,"HI-SCORE",GameConstant.HI_SCORE_STR.x,GameConstant.HI_SCORE_STR.y,0,Align.center,false);
        GameAsset.font.draw(batch,"SCORE",GameConstant.SCORE_STR.x,GameConstant.SCORE_STR.y,0,Align.center,false);
        GameAsset.font.draw(batch,"LEVEL",GameConstant.LEVEL_STR.x,GameConstant.LEVEL_STR.y,0,Align.center,false);

        GameAsset.normalfont.draw(batch,String.format("%d",HI_SCORE),GameConstant._HI_SCORE_STR.x,GameConstant._HI_SCORE_STR.y,0,Align.center,false);
        GameAsset.normalfont.draw(batch,String.format("%d",DISPLAY_SCORE),GameConstant._SCORE_STR.x,GameConstant._SCORE_STR.y,0,Align.center,false);
        GameAsset.normalfont.draw(batch,String.format("%d",LEVEL),GameConstant._LEVEL_STR.x,GameConstant._LEVEL_STR.y,0,Align.center,false);
        batch.end();
    }
}
