package com.mygdx.game;


import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.LocalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter;


// wrapper for assetmanager basically
public class Loader {
	static AssetManager manager;
	
	public Loader(){
		manager = new AssetManager();
		FileHandleResolver resolver = new LocalFileHandleResolver();

		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));
	}
	
	public static void addMult(String[] fonts, int size, String[] names){
		int i;
		for(i=0;i<fonts.length;i++){
			LoadFont(fonts[i],size,names[i]);
		}
		
	}
	
	public static void LoadFont(String s, int size, String name){
		

		FreeTypeFontLoaderParameter sizeParams = new FreeTypeFontLoaderParameter();
		sizeParams.fontFileName = "fonts/" + s;       
		sizeParams.fontParameters.size = size;   
		sizeParams.fontParameters.minFilter = TextureFilter.Linear;
		sizeParams.fontParameters.magFilter = TextureFilter.Linear;                            
		manager.load(name,BitmapFont.class,sizeParams);
		manager.finishLoading();
	}

	
	
	public static BitmapFont fontget(String fontname){
		return(manager.get(fontname));
	}
	

}
