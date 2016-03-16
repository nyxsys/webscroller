package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ScrollImg {
	
	public float width;
	public float height;
	public float scale;
	Texture texture;
	public Sprite sprite;
	public float scaleWidth;
	public float scaleHeight;


	ScrollImg(String name, float targetSize){
		texture = new Texture("img/" + name);
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		sprite = new Sprite(texture);

		width = sprite.getWidth();
		height = sprite.getHeight();
		setScale(targetSize);
		
		
	}


	private void setScale(float targetSize) {
		if(width > height){
			float ratio = width / height;
			scaleHeight = targetSize / height;
			scaleWidth = (targetSize * ratio)/ width;
		}
		else{
			float ratio = height / width;
			scaleWidth =  targetSize / width;
			scaleHeight = (targetSize * ratio) / height;
		}
	}

}
