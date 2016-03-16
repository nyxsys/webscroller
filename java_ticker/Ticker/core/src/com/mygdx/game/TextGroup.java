package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class TextGroup implements Iterable<FontDecorator>{
	private ArrayList<FontDecorator> group = new ArrayList<FontDecorator>();
	private static BitmapFont font;
	String split;
	boolean first = true;
	public TextGroup(String message, String font, String split) {
		TextGroup.font = Loader.fontget(font);
		this.split = split;
		
		String[] sections = message.split(split);
		for(String subString: sections){
			FontDecorator temp = new FontDecorator();
			temp.message = subString;
			set(temp);
			setWidth(temp);
			group.add(temp);
			if(!first){
				group.add(dashes());
			}
			else{
				group.add(blank());
				first = false;
			}
		}
		setOffsets();
		
	}
	private FontDecorator blank() {
		FontDecorator temp = new FontDecorator();
		temp.message = split;
		temp.font = font;
		temp.color = ColorGenerator.getWhite();
		setWidth(temp);
		temp.message = " ";
		return temp;
	}
	public float getWidth(int index){
		return(group.get(index).width);
	}
	public float getOffset(int index) {

		return(group.get(index).offset);
	}

	public TextGroup(TextGroup textGroup) {
		this.group = textGroup.group;
	}

	
	/*
	 * Set offset from left of this string group
	 */
	private void setOffsets() {
		int off = 0;
		for(FontDecorator text: group){
			text.offset = off;
			off += text.width;
		}
	}


	private FontDecorator dashes() {
		FontDecorator temp = new FontDecorator();
		temp.message = split;
		temp.font = font;
		temp.color = ColorGenerator.getWhite();
		setWidth(temp);
		return temp;
	}


	@Override
	public Iterator<FontDecorator> iterator() {
		Iterator<FontDecorator> fontIterator = group.iterator();
		return fontIterator;
	}
	
	
	public static void set( FontDecorator text){
		text.font = font;
		text.color = ColorGenerator.colorPick();
	}
	
	public static void setWidth(FontDecorator text){
		GlyphLayout layout = new GlyphLayout();
		layout.setText(text.font, text.message);
		text.width = layout.width;
	}
	
	
}


