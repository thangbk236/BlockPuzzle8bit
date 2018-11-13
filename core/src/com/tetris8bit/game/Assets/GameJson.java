package com.tetris8bit.game.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.tetris8bit.game.Screen.GamePlayScreenElement.GamePlayScreenTetrisPlay;

public class GameJson {
    public static FileHandle fileHandle = Gdx.files.local("TetrisJson.json");
    public static Json json = new Json();
    public static GamePlayScreenTetrisPlay gameJsonData;
    public static void save() {
        json.setOutputType(JsonWriter.OutputType.json);
        fileHandle.writeString(json.prettyPrint(gameJsonData),false);
    }
    public static void load() {
        gameJsonData = new GamePlayScreenTetrisPlay();
        if (saveFileExists()) {    // neu file chi dinh khong ton tai
            gameJsonData=json.fromJson(GamePlayScreenTetrisPlay.class,fileHandle);
        }
    }
    public static boolean saveFileExists() {
        return fileHandle.exists();
    }
}
