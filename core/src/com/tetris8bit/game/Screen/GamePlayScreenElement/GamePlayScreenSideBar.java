package com.tetris8bit.game.Screen.GamePlayScreenElement;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.tetris8bit.game.Assets.GameAsset;
import com.tetris8bit.game.Assets.GameConstant;
import com.tetris8bit.game.Assets.GameJson;

public class GamePlayScreenSideBar {
    public GamePlayScreenSideBar(){

    }
    public void render(float deltaTime,SpriteBatch batch){

        batch.begin();
        GameAsset.font.draw(batch,"HI-SCORE",GameConstant.HI_SCORE_STR.x,GameConstant.HI_SCORE_STR.y,0,Align.center,false);
        GameAsset.font.draw(batch,"SCORE",GameConstant.SCORE_STR.x,GameConstant.SCORE_STR.y,0,Align.center,false);
        GameAsset.font.draw(batch,"LEVEL",GameConstant.LEVEL_STR.x,GameConstant.LEVEL_STR.y,0,Align.center,false);

        GameAsset.normalfont.draw(batch,String.format("%d",GameJson.gameJsonData.HI_SCORE),GameConstant._HI_SCORE_STR.x,GameConstant._HI_SCORE_STR.y,0,Align.center,false);
        GameAsset.normalfont.draw(batch,String.format("%d",GameJson.gameJsonData.SCORE),GameConstant._SCORE_STR.x,GameConstant._SCORE_STR.y,0,Align.center,false);
        GameAsset.normalfont.draw(batch,String.format("%d",GameJson.gameJsonData.LEVEL),GameConstant._LEVEL_STR.x,GameConstant._LEVEL_STR.y,0,Align.center,false);
        batch.end();
    }
}
