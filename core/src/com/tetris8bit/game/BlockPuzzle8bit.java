package com.tetris8bit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tetris8bit.game.Assets.GameAsset;
import com.tetris8bit.game.Screen.GameOverScreen;
import com.tetris8bit.game.Screen.GamePlayScreen;
import com.tetris8bit.game.Screen.MainMenuScreen;
import com.tetris8bit.game.Screen.SettingScreen;

public class BlockPuzzle8bit extends Game {

	GameAsset gameAsset;
	private PlayServices playservices;

	public BlockPuzzle8bit(PlayServices playservices) {
		this.playservices = playservices;
	}

	TestGame testgame;
	@Override
	public void create () {
		gameAsset = new GameAsset();
		testgame = new TestGame(this);
		//this.setScreen(testgame);
		this.setScreen(TestGame.getInstance(this,true));
	}

	@Override
	public void render () {

		super.render();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void dispose () {

	}
}
