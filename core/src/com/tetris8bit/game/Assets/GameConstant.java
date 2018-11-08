package com.tetris8bit.game.Assets;

import com.badlogic.gdx.Gdx;

public class GameConstant {

    public static final float   V_HEIGHT       = Gdx.graphics.getHeight();     // gia tri chieu cao man hinh mac dinh
    public static final float   V_WIDTH       = Gdx.graphics.getWidth();      // gia tri chieu rong man hinh mac dinh

    public static final float   S_HEIGHT       = 1440.0f;     // gia tri chieu cao man hinh sau khi fix
    public static final float   S_WIDTH       = V_WIDTH*S_HEIGHT/V_HEIGHT;      // gia tri chieu rong man hinh sau khi fix

}
