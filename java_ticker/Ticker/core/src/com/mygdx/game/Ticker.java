package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
 * TODO:
 * Make a menu to edit the message string (useable after this)
 */



public class Ticker extends ApplicationAdapter {
	static String defaultFont;
	SpriteBatch batch;
	BitmapFont font;
	Loader loader;
	TextGroup[] active = new TextGroup[2];
	MessageEntry entry; 
	ConfigParser config;
	
	
	float imgOffset;
	float[] spot = new float[2];
	float start;
	float end;
	float yOffset;
	public ScrollImg scrollImg;
	private float first;
	private float yspot;
	
	
	@Override
	public void create () {
		
		
		config = new ConfigParser();
		loader = new Loader();
		batch = new SpriteBatch();
		
		defaultFont = config.font;
		Builder.setFont(defaultFont, config.fontSize);
		
		scrollImg = new ScrollImg(config.imgName,config.target);
		imgOffset = config.imgOffsetX;
		yspot = 5 + config.imgOffsetY;
		
		entry = new MessageEntry();
		entry.message = "0";
		Gdx.input.getTextInput(entry, "Message", config.defaultMessage, ".____________________________________________________________________________________________________________.");
	}


	
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));
		
		batch.begin();
		if(entry.good){
			if(entry.newMsg){
				Builder.setMsg(entry.message, this);
				entry.newMsg = false;
				first = active[0].getWidth(0) + ((active[0].getWidth(1) - config.target) / 2);
			}
			Builder.update(this);
			
			
			
			
			int i = 0;
			for(TextGroup group : active){
				for(FontDecorator text : group){
					text.font.setColor(text.color);
					text.font.draw(batch, text.message, spot[i] + text.offset, yOffset);
				}
				i = 1;
			}
			
			
			//batch.draw(scrollImg.sprite, spot[0] + first + imgOffset , yspot, scrollImg.width , scrollImg.height);
			//batch.draw(scrollImg.sprite, spot[1] + first + imgOffset, yspot, scrollImg.width , scrollImg.height);
			
			
			batch.draw(scrollImg.sprite, spot[0] + first + imgOffset, yspot, 0, 0, scrollImg.width, scrollImg.height, scrollImg.scaleWidth, scrollImg.scaleHeight, (float) 0);
			batch.draw(scrollImg.sprite, spot[1] + first + imgOffset, yspot, 0, 0, scrollImg.width, scrollImg.height, scrollImg.scaleWidth, scrollImg.scaleHeight, (float) 0);

		}
		else if(entry.bad){
			entry.bad = false;
			Gdx.input.getTextInput(entry, "Message - Try Again", entry.current, "");
		}
		batch.end();
	}
	

	
	
}
