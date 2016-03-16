package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;

public class ColorGenerator {
	static ArrayList<Color> colors = new ArrayList<Color>();
	private static Color baseColor;
	
	public static Color colorPick(){
		int rand = new Random().nextInt(colors.size());
		return(colors.get(rand));
	}
	public static void add(String color){
		colors.add(Color.valueOf(color));
	}
	public static void setBase(String color){
		baseColor = Color.valueOf(color);
	}

	public static Color getWhite() {
		return baseColor;
	}
	
}
