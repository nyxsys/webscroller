package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class Builder {

	static BitmapFont choice;
	static Color color;
	static float offset;
	static float speed;
	static String split;

	
	

	public static void setFont(String font, int size){
		Loader.LoadFont(font, size, font);
		choice = Loader.fontget(font);
	}
	
	
	public static void update(Ticker ticker){
		int i;
		for(i = 0; i<2; i++){
			for(FontDecorator text : ticker.active[i]){
				text.font = choice;
			}
			ticker.spot[i] = ticker.spot[i]-speed;
			if(ticker.spot[i]<ticker.end){
				ticker.spot[i]=ticker.start+offset;
			}
		}

	}
	
	
	public static boolean testMessage(String message) {
		
		GlyphLayout layout = new GlyphLayout();
		layout.setText(choice, message);
		if(((int)layout.width) < Gdx.graphics.getWidth()){
			return false;
		}
		return true;
	}
	
	
	public static void setMsg(String message, Ticker ticker) {
		
		split = ticker.config.split;
		
		GlyphLayout layout = new GlyphLayout();
		layout.setText(choice, message + split);
		
		ticker.start = Gdx.graphics.getWidth();
		
		
		
		ticker.end = -1 * layout.width;
		ticker.yOffset = layout.height + ((Gdx.graphics.getHeight() - layout.height)/2);
		
		offset = ((-1* ticker.end) - ticker.start);
		speed = ticker.config.speed;
		ticker.spot[0] = ticker.start+offset;
		ticker.spot[1] = 0;
		
		
		ticker.active[0] = new TextGroup(message, Ticker.defaultFont, split);
		ticker.active[1] = new TextGroup(ticker.active[0]);
	}
	
}
