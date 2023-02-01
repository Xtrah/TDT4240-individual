package com.mygdx.exercise1;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.exercise1.Exercise1;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle(Exercise1.TITLE);
		config.setWindowedMode(Exercise1.WIDTH, Exercise1.HEIGHT);
		new Lwjgl3Application(new Exercise1(), config);
	}
}