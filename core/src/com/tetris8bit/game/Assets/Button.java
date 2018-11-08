package com.tetris8bit.game.Assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Button {
    private Texture textureOnClick;
    private Texture textureOnRelease;
    private Vector2 texturePosition;
    private Vector2 texturePositionCenter;
    public boolean isClick; // khi button duoc click
    public boolean isSound; // cho phep co tieng hay ko khi click
    public boolean isCircle;
    public Button(String _textureOnClick,String _textureOnRelease,Vector2 _texturePositionCenter,boolean _isCircle){
        textureOnClick=new Texture(_textureOnClick);
        textureOnRelease=new Texture(_textureOnRelease);
        texturePosition=new Vector2();
        texturePositionCenter=new Vector2();
        isCircle=_isCircle;
        this.texturePositionCenter.set(_texturePositionCenter.x,_texturePositionCenter.y);
        this.texturePosition.set(texturePositionCenter.x-textureOnClick.getWidth()/2.0f,texturePositionCenter.y-textureOnClick.getHeight()/2.0f);
    }

    public boolean checkOnClick(){
        if (GameTouch.IsTouch()) {
            if (isCircle) {  // neu button co dang hinh tron
                // xac dinh toa do tam hinh tron
                // tinh toan xem toa do touch co nam trong hinh tron hay khong
                for (int i = 0; i < GameTouch.touchnum; i++) {
                    if ((GameTouch.touchX[i] - texturePositionCenter.x) * (GameTouch.touchX[i] - texturePositionCenter.x) + (GameTouch.touchY[i] - texturePositionCenter.y) * (GameTouch.touchY[i] - texturePositionCenter.y) <= textureOnClick.getWidth() * textureOnClick.getWidth() / 4.0f) {
                        return true;
                    }
                }
            } else {  // neu button co dang hinh chu nhat
                for (int i = 0; i < GameTouch.touchnum; i++){
                    if((GameTouch.touchX[i]>=texturePositionCenter.x-textureOnClick.getWidth()/2.0f)&&(GameTouch.touchX[i]<=texturePositionCenter.x+textureOnClick.getWidth()/2.0f)&&(GameTouch.touchY[i]>=texturePositionCenter.y-textureOnClick.getHeight()/2.0f)&&(GameTouch.touchY[i]<=texturePositionCenter.y+textureOnClick.getHeight()/2.0f)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void render(SpriteBatch batch){
        isClick=checkOnClick();
        batch.begin();
        if (isClick){
            batch.draw(textureOnClick,texturePosition.x,texturePosition.y);
        }
        else {
            batch.draw(textureOnRelease,texturePosition.x,texturePosition.y);
        }
        if(isSound){

        }
        else {

        }
        batch.end();
    }

    public void dipose(){
        textureOnClick.dispose();
        textureOnRelease.dispose();
    }
}
