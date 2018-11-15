package com.tetris8bit.game;

import com.badlogic.gdx.Game;
import com.tetris8bit.game.Assets.GameAsset;
import com.tetris8bit.game.Assets.GameJson;
import com.tetris8bit.game.Screen.MainMenuScreen;

public class BlockPuzzle8bit extends Game {

	GameAsset gameAsset;
	public static PlayServices playservices;

	public BlockPuzzle8bit(PlayServices playservices) {
		this.playservices = playservices;
	}
	@Override
	public void create () {
		gameAsset = new GameAsset();
		GameJson.load();
		this.setScreen(MainMenuScreen.getInstance(this,true));
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
