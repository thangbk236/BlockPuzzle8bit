package com.tetris8bit.game.Screen.GamePlayScreenElement;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.tetris8bit.game.Assets.GameAsset;
import com.tetris8bit.game.Assets.GameConstant;
import com.tetris8bit.game.Assets.GameGrid;
import com.tetris8bit.game.Screen.GameOverScreen;

public class GamePlayScreenTetris {
    protected final Game game;
    private GameGrid gameGrid;
    public static int gameState;
    private float gameCountDownTime;
    private int gameCountDown;
    public GamePlayScreenTetrisPlay gamePlayScreenTetrisPlay;
    public GamePlayScreenTetris(Game game){
        gamePlayScreenTetrisPlay = new GamePlayScreenTetrisPlay();
        gameGrid=new GameGrid(1);
        gameCountDownTime=0.0f;
        gameCountDown=3;
        this.game = game;
    }
    public void render(float delta, SpriteBatch batch){
        gameGrid.GameUpdate(delta,batch);

        switch (gameState){
            case 0: // khi tao moi hoac tro ve tu nut setting thi se co 1 bo dem lui 3s
                ProcessCountDown(delta,batch);
                break;
            case 1: // khi an nut stop thi se cho dung man hinh choi game va hien chu pause
                ProcessStop(delta,batch);
                break;
            case 2: // khi game over thi se hien thi chu game over
                ProcessGameOver(delta,batch);
                break;
            case 3: // khi choi game binh thuong
                ProcessGamePlay(delta,batch);
                break;
        }
    }


    public void ProcessCountDown(float delta, SpriteBatch batch){

        if (gameCountDown>0){
            batch.begin();
            GameAsset.GoodMorningBigfont.draw(batch,String.format("%d",gameCountDown),GameConstant._TO_STR.x,GameConstant._TO_STR.y,0, Align.center,false);
            batch.end();
            gameCountDownTime+=delta;
            if (gameCountDownTime>=1.0f){
                gameCountDownTime=0.0f;
                gameCountDown-=1;
            }
        }
        else {
            gameState=3;    // chuyen sang man hinh game play
            gameCountDown=3;    // reset lai bo dem
        }



    }
    public void ProcessStop(float delta, SpriteBatch batch){
        gamePlayScreenTetrisPlay.GameDraw(batch);
        batch.begin();
        GameAsset.GoodMorningfont.draw(batch,"PAUSE",GameConstant._TO_STR.x,GameConstant._TO_STR.y,0, Align.center,false);
        batch.end();

    }
    public void ProcessGameOver(float delta, SpriteBatch batch){
        gamePlayScreenTetrisPlay.GameDraw(batch);
        if (gameCountDown>0){
            batch.begin();
            GameAsset.GoodMorningfont.draw(batch,"GAME OVER",GameConstant._TO_STR.x,GameConstant._TO_STR.y,0, Align.center,false);
            batch.end();
            gameCountDownTime+=delta;
            if (gameCountDownTime>=1.0f){
                gameCountDownTime-=1.0f;
                gameCountDown-=1;
            }
        }
        else {
            gameCountDown=3;
            game.setScreen(new GameOverScreen(game));
        }
    }
    public void ProcessGamePlay(float delta, SpriteBatch batch){
        gamePlayScreenTetrisPlay.render(delta,batch);

    }

    public void dispose(){

    }
}
