package com.mygdx.game;

import com.badlogic.gdx.Input.TextInputListener;

public class MessageEntry implements TextInputListener{
	String message = null;
	String current = null;
	public boolean bad = false;
	public boolean good = false;
	public boolean newMsg = true;
	
	@Override
	   public void input (String message) {
		if(Builder.testMessage(message)){
			this.message = message;
			good = true;
		}
		else{
			current = message;
			bad = true;
		}
	   }

	   @Override
	   public void canceled () {
	   }
}
