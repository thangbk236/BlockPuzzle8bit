package com.tetris8bit.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.tetris8bit.game.Assets.Button;
import com.tetris8bit.game.Assets.GameTouch;
import com.tetris8bit.game.Screen.MainMenuScreen;
import com.tetris8bit.game.Screen.SettingScreen;

public class TestGame implements Screen {
    GameTouch gameTouch;

    public int i;

    private static TestGame testGame;

    public static final float   V_HEIGHT       = Gdx.graphics.getHeight();     // gia tri chieu cao man hinh mac dinh
    public static final float   V_WIDTH       = Gdx.graphics.getWidth();      // gia tri chieu rong man hinh mac dinh

    public static final float   S_HEIGHT       = 1440.0f;     // gia tri chieu cao man hinh sau khi fix
    public static final float   S_WIDTH       = V_WIDTH*S_HEIGHT/V_HEIGHT;      // gia tri chieu rong man hinh sau khi fix

    public Vector2 ScreenCenterPos;
    public Vector2 SettingBackgroundPos;
    public Vector2 NewGamePos;
    public Vector2 SoundOffPos;
    public Vector2 VibratePos;
    public Vector2 ExitPos;
    public Vector2 ClosePos;
    public float ButtonMargin;

    private BitmapFont font;
    private OrthographicCamera camera;
    SpriteBatch batch;
    Texture img;
    Texture NewGame;
    Texture SoundOff;
    Texture VibrateOff;
    Texture Exit;
    Texture SettingBackground;
    Texture Close;

    public float time;
    protected final Game game;

    public boolean isNewGame;
    public boolean isSounOff;
    public boolean isVibrateOff;
    public boolean isExit;


    public Button newgamebtn;

    public TestGame(Game game){
        gameTouch = new GameTouch();
        font = new BitmapFont();
        i=0;
        ScreenCenterPos = new Vector2(S_WIDTH/2.0f,S_HEIGHT/2.0f);
        SettingBackgroundPos = new Vector2();
        NewGamePos = new Vector2();
        SoundOffPos = new Vector2();
        VibratePos = new Vector2();
        ExitPos = new Vector2();
        ClosePos = new Vector2();
        ButtonMargin = 30.0f;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 2560, 1440);
        camera.update();
        batch = new SpriteBatch();
        img = new Texture("ButtonEdge/buttonedge.png");
        NewGame = new Texture("ButtonEdge/NewGame.png");
        SoundOff = new Texture("ButtonEdge/SoundOff.png");
        VibrateOff = new Texture("ButtonEdge/VibrateOff.png");
        Exit = new Texture("ButtonEdge/Exit.png");
        SettingBackground = new Texture("ButtonEdge/SettingBackground.png");
        Close = new Texture("ButtonEdge/Close.png");


        SettingBackgroundPos.set(S_WIDTH/2.0f-SettingBackground.getWidth()/2.0f,S_HEIGHT/2.0f-SettingBackground.getHeight()/2.0f);
        SoundOffPos.set(S_WIDTH/2.0f-SoundOff.getWidth()/2.0f,S_HEIGHT/2.0f+ButtonMargin);
        VibratePos.set(S_WIDTH/2.0f-VibrateOff.getWidth()/2.0f,S_HEIGHT/2.0f-ButtonMargin-VibrateOff.getHeight());
        NewGamePos.set(S_WIDTH/2.0f-NewGame.getWidth()/2.0f,SoundOffPos.y+SoundOff.getHeight()+ButtonMargin);
        ExitPos.set(S_WIDTH/2.0f-Exit.getWidth()/2.0f,VibratePos.y-Exit.getHeight()-ButtonMargin);
        ClosePos.set(SettingBackgroundPos.x+SettingBackground.getWidth()-Close.getWidth()/2.0f,SettingBackgroundPos.y+SettingBackground.getHeight()-Close.getHeight());


        newgamebtn=new Button("ButtonEdge/NewGame.png","ButtonEdge/SoundOff.png",NewGamePos);

        this.game=game;
    }
    public boolean CheckClick(GameTouch gametouch,Texture texture){
        return false;
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
        isNewGame=false;
        isSounOff=false;
        isVibrateOff=false;
        isExit=false;


        GameTouch.GameUpdate(delta);



        time+=delta;
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(SettingBackground, SettingBackgroundPos.x,SettingBackgroundPos.y);
        batch.draw(Exit,ExitPos.x,ExitPos.y);
        batch.draw(VibrateOff,VibratePos.x,VibratePos.y);
        batch.draw(SoundOff,SoundOffPos.x,SoundOffPos.y);
        //batch.draw(NewGame,NewGamePos.x,NewGamePos.y);


        batch.draw(Close,ClosePos.x,ClosePos.y);
        batch.end();
        newgamebtn.render(batch,false);
        //Gdx.app.log("i = ",String.format("%d",i));
        //Gdx.app.log("time = ",String.format("%f",time));
        //Gdx.app.log("fps = ",String.format("%f",1.0f/delta));
        if(Gdx.input.isTouched()){
            //game.setScreen(new SettingScreen(game));
            i++;
        }
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
        img.dispose();
    }
}
