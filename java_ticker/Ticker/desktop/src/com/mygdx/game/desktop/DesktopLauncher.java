package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Ticker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Ticker";
		config.samples = 16;
		config.vSyncEnabled = true;
		config.allowSoftwareMode = false;
		config.backgroundFPS = 30;
		config.foregroundFPS = 30;
		config.height = 50;
		config.width = 1280;
		
		config.addIcon("icon.png", Files.FileType.Internal);
		new LwjglApplication(new Ticker(), config);
	}
}
