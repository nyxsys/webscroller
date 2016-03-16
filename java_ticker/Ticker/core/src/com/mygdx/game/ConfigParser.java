package com.mygdx.game;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;


public class ConfigParser {
	XmlReader xml = new XmlReader();
	public String defaultMessage;
	Element root;
	public float speed;
	public float target;
	public String font;
	public String split;
	public String imgName;
	public float imgOffsetX;
	public float imgOffsetY;
	public int fontSize;
	
	
	ConfigParser(){

		try {
			root = xml.parse(Gdx.files.local(("config.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		defaultMessage = root.get("default-message") + " ";
		speed = Float.parseFloat(root.get("speed"));
		target = Float.parseFloat(root.get("img-size"));
		fontSize = Integer.parseInt(root.get("font-size"));
		imgOffsetX = Float.parseFloat(root.get("img-offset-x"));
		imgOffsetY = Float.parseFloat(root.get("img-offset-y"));
		font = root.get("font");
		split = root.get("split");
		imgName = root.get("img");
		ColorSetting();
		
				
	}
	private void ColorSetting() {
		Element color = root.getChildByName("color-list");
		ColorGenerator.setBase(color.get("base-color"));
		Array<Element> colors = color.getChildrenByName("color");
		while(colors.size > 0){
			ColorGenerator.add(colors.pop().getText());
		}
		// TODO Auto-generated method stub
		
	}
}
